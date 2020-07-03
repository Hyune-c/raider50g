package com.hyune.raider50g.service;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.USER_AGENT;

import com.google.gson.Gson;
import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.config.property.DiscordProperty;
import com.hyune.raider50g.domain.booking.BookingList;
import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
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

  private final DiscordProperty discordProperty;
  private final BookingService bookingService;

  public Mono<Object> postBookingList(DungeonType dungeonType, LocalDate raidDate) {
    BookingList bookingList = bookingService.createBookingList(dungeonType, raidDate);
    Map<String, String> payloads = new HashMap<>();
    payloads.put("content", bookingList.createBookingSheet());

    return postMessages(dungeonType.getChannelId(), new Gson().toJson(payloads));
  }

  public Mono<Object> postMessages(String channelId, String jsonBody) {
    URI uri = UriComponentsBuilder
        .fromHttpUrl(discordProperty.getApiUrl())
        .pathSegment("channels", "{channelId}", "messages")
        .build(channelId);
    Consumer<HttpHeaders> headersConsumer = headers -> {
      headers.add(AUTHORIZATION, "Bot " + discordProperty.getToken());
      headers.add(USER_AGENT, "PostmanRuntime/7.25.0");
      headers.add(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    };

    return WebClient.create()
        .post()
        .uri(uri)
        .headers(headersConsumer)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(jsonBody)
        .retrieve()
        .bodyToMono(Object.class);
  }
}

