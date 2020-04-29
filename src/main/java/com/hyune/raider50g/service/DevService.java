package com.hyune.raider50g.service;

import com.hyune.raider50g.config.ConfigureDiscordApi;
import org.javacord.api.DiscordApi;
import org.springframework.stereotype.Service;

@Service
public class DevService {

  private final DiscordApi discordApi;

  public DevService() {
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
  }

  public void addPingPong() {
    discordApi.addMessageCreateListener(event -> {
      if (event.getMessageContent().equalsIgnoreCase("!ping")) {
        event.getChannel().sendMessage("Pong!!!");
      }
    });
  }

  public void addRedBlack() {
    discordApi.addMessageCreateListener(event -> {
      if (event.getMessageContent().equalsIgnoreCase("red")) {
        event.getChannel().sendMessage("black!!!");
      }
    });
  }
}
