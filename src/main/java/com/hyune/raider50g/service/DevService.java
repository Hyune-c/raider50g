package com.hyune.raider50g.service;

import com.hyune.raider50g.Util.JsonUtil;
import com.hyune.raider50g.config.ConfigureDiscordApi;
import com.hyune.raider50g.property.Mock;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class DevService {

  private final DiscordApi discordApi;

  public DevService() {
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
  }

  public JSONArray getChannelMessages() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bot " + Mock.getBotToken());

    UriComponents uriComponents = UriComponentsBuilder
        .fromHttpUrl(Mock.DISCORD_API_URL)
        .path("/channels/" + Mock.CHANNEL_BLACKWING + "/messages")
        .build(false);

    ResponseEntity<String> response = new RestTemplate().exchange(
        uriComponents.toUri(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);

    try {
      JsonUtil.arrayParser(response.getBody());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String addPingPong() {
    discordApi.addMessageCreateListener(event -> {
      if (event.getMessageContent().equalsIgnoreCase("!ping")) {
        event.getChannel().sendMessage("Pong!!!");
      }
    });

    return "add PingPong";
  }

  public String addEcho() {
    discordApi.addMessageCreateListener(event -> {
          log.debug("### User : {}", event.getMessage().getUserAuthor().get());

          if (!event.getMessage().getUserAuthor().get().getName().equals("50G BOT")) {
            event.getChannel().sendMessage("echo :: " + event.getMessageContent());
          }
        }
    );

    return "add Echo";
  }
}
