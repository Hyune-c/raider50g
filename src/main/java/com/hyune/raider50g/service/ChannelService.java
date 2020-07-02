package com.hyune.raider50g.service;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.USER_AGENT;

import com.google.gson.Gson;
import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.config.property.DiscordProperty;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.repository.BookingRepository;
import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ChannelService {

  private final BookingRepository bookingRepository;
  private final DiscordProperty discordProperty;

  private String bookingListTitle(DungeonType channel, LocalDate raidDate, int raiderCount) {
    return String.format("%s\t%s (일) PM 19:00\t%d/40", channel.getKey(), raidDate, raiderCount);
  }

  private String bookingListContent(List<Booking> bookings) {
    return Arrays.stream(ClassType.values()).map(classType ->
        classType.getName() + "\t" + bookings.stream()
            .filter(booking -> booking.getClassType().equals(classType))
            .map(Booking::getRaiderId)
            .collect(Collectors.joining("\t"))
    ).collect(Collectors.joining("\n"));
  }

  public String createBookingListString(DungeonType channel, LocalDate raidDate) {
    List<Booking> bookings = bookingRepository.findAll(raidDate);
    return "```"
        + bookingListTitle(channel, raidDate, bookings.size())
        + "```"
        + "```"
        + bookingListContent(bookings)
        + "```";
  }

  public Mono<Object> sendBookingList(DungeonType channel, String bookingListString) {
    URI uri = UriComponentsBuilder
        .fromHttpUrl(discordProperty.getApiUrl())
        .pathSegment("channels", "{channelId}", "messages")
        .build(channel.getChannelId());
    Consumer<HttpHeaders> headersConsumer = headers -> {
      headers.add(AUTHORIZATION, "Bot " + discordProperty.getToken());
      headers.add(USER_AGENT, "PostmanRuntime/7.25.0");
      headers.add(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    };
    Map<String, String> payloads = new HashMap<>();
    payloads.put("content", bookingListString);

    return WebClient.create()
        .post()
        .uri(uri)
        .headers(headersConsumer)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(new Gson().toJson(payloads))
        .retrieve()
        .bodyToMono(Object.class);
  }
}

