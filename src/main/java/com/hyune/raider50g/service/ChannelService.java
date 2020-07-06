package com.hyune.raider50g.service;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.USER_AGENT;

import com.google.gson.Gson;
import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.config.property.DiscordProperty;
import com.hyune.raider50g.domain.booking.dto.BookingList;
import com.hyune.raider50g.domain.channel.DiscordMessage;
import com.hyune.raider50g.domain.channel.DiscordUser;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

  public List<DiscordMessage> getMessages(String channelId, int limit, String author) {
    URI uri = UriComponentsBuilder
        .fromHttpUrl(discordProperty.getApiUrl())
        .pathSegment("channels", "{channelId}", "messages")
        .queryParam("limit", limit)
        .build(channelId);
    Consumer<HttpHeaders> headersConsumer = headers -> {
      headers.add(AUTHORIZATION, "Bot " + discordProperty.getToken());
      headers.add(USER_AGENT, "PostmanRuntime/7.25.0");
      headers.add(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    };

    Mono<ArrayList> clientResponse = WebClient.create()
        .get()
        .uri(uri)
        .headers(headersConsumer)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(ArrayList.class);

    ArrayList<LinkedHashMap<String, Object>> response = clientResponse.block();

    // Discord API 에서 온 응답을 파싱합니다
    List<DiscordMessage> discordMessages = (Objects.isNull(response))
        ? null
        : response.stream()
            .map(obj -> {
              LinkedHashMap<String, Object> objAuthor = (LinkedHashMap<String, Object>) obj
                  .get("author");
              DiscordUser discordUser = DiscordUser.of(objAuthor.get("username").toString());
              return DiscordMessage.of(obj.get("content").toString(), discordUser);
            })
            .collect(Collectors.toList());

    // author 파라미터가 있는 경우 filter 한 메세지를 리턴합니다
    return (Objects.isNull(author) || Objects.isNull(discordMessages))
        ? discordMessages
        : discordMessages.stream()
            .filter(message -> author.equals(message.getAuthorUser().getUserName()))
            .collect(Collectors.toList());
  }
}
