package com.hyune.raider50g.service;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.USER_AGENT;

import com.hyune.raider50g.config.property.DiscordProperty;
import com.hyune.raider50g.domain.channel.DiscordMessage;
import com.hyune.raider50g.domain.channel.DiscordUser;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.javacord.api.entity.user.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

  private final WebClient webClient;
  private final Consumer<HttpHeaders> headersConsumer;

  public WebClientService(WebClient.Builder webClientBuilder, DiscordProperty discordProperty) {
    this.webClient = webClientBuilder.baseUrl(discordProperty.getApiUrl()).build();
    this.headersConsumer = headers -> {
      headers.add(AUTHORIZATION, "Bot " + discordProperty.getToken());
      headers.add(USER_AGENT, "PostmanRuntime/7.25.0");
      headers.add(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    };
  }

  public Mono<Object> postMessages(String channelId, String jsonBody) {
    Function<UriBuilder, URI> uriFunction = (uriBuilder -> uriBuilder
        .pathSegment("channels", "{channelId}", "messages")
        .build(channelId));

    return webClient
        .post()
        .uri(uriFunction)
        .headers(headersConsumer)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(jsonBody)
        .retrieve()
        .bodyToMono(Object.class);
  }

  public List<DiscordMessage> getMessages(String channelId, int limit, String findAuthor) {
    Function<UriBuilder, URI> uriFunction = (uriBuilder -> uriBuilder
        .pathSegment("channels", "{channelId}", "messages")
        .queryParam("limit", limit)
        .build(channelId));

    Mono<ArrayList> clientResponse = WebClient.create()
        .get()
        .uri(uriFunction)
        .headers(headersConsumer)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(ArrayList.class);

    ArrayList<LinkedHashMap<String, Object>> response = clientResponse.block();
    List<DiscordMessage> discordMessages = new ArrayList<>();

    if (Objects.isNull(response)) {
      return discordMessages;
    }

    // Discord API 에서 온 응답을 파싱합니다
    discordMessages = response.stream()
        .map(obj -> {
          long id = Long.parseLong(obj.get("id").toString());
          String content = obj.get("content").toString();
          LinkedHashMap<String, Object> objAuthor =
              (LinkedHashMap<String, Object>) obj.get("author");
          DiscordUser discordUser = DiscordUser.of(objAuthor.get("username").toString());
          LocalDateTime createdAt = LocalDateTime
              .parse(obj.get("timestamp").toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

          return new DiscordMessage(id, content, discordUser, createdAt);
        })
        .collect(Collectors.toList());

    // author 파라미터가 있는 경우 filter 한 메세지를 리턴합니다
    return (Objects.isNull(findAuthor))
        ? discordMessages
        : discordMessages.stream()
            .filter(message -> {
              User messageAuthor = message.getUserAuthor().orElseGet(DiscordUser::new);
              return messageAuthor.getName().equals(findAuthor);
            })
            .collect(Collectors.toList());
  }
}
