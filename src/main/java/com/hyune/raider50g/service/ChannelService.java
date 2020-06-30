package com.hyune.raider50g.service;

import com.google.gson.Gson;
import com.hyune.raider50g.common.type.Channel;
import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.property.ApiURL;
import com.hyune.raider50g.property.Token;
import com.hyune.raider50g.repository.BookingRepository;
import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class ChannelService {

  private final BookingRepository bookingRepository;

  private String makeBookingList(Channel channel, LocalDate raidDate, List<Booking> bookings) {
    StringBuilder sb = new StringBuilder();

    String title = "```" + channel.getKey() + "\t" + raidDate + "\t" + bookings.size() + "/40```";
    sb.append(title);

    sb.append("```");
    for (ClassType classType : ClassType.values()) {
      sb.append(classType.getNames().get(0)).append("\t");
      sb.append(bookings.stream()
          .filter(booking -> classType.equals(booking.getRaider().getClassType()))
          .map(booking -> booking.getRaider().getRaiderId())
          .collect(Collectors.joining("\t")));
      sb.append("\n");
    }
    sb.append("```");

    return sb.toString();
  }

  public void sendBookingList(Channel channel, LocalDate raidDate) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("User-Agent", "PostmanRuntime/7.25.0");
    headers.add("Authorization", "Bot " + Token.getBotToken());

    Map<String, String> payloads = new HashMap<>();
    String bookingListString = makeBookingList(channel, raidDate, bookingRepository.find(raidDate));
    payloads.put("content", bookingListString);

    HttpEntity<String> request = new HttpEntity<>(new Gson().toJson(payloads), headers);

    URI uri = UriComponentsBuilder
        .fromHttpUrl(ApiURL.DISCORD_API)
        .pathSegment("channels", "{channelId}", "messages")
        .build(channel.getChannelId());

    new RestTemplate().postForObject(uri.toString(), request, Object.class);
  }
}

