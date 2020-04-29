package com.hyune.raider50g.service;

import org.javacord.api.DiscordApi;
import org.springframework.stereotype.Service;

@Service
public class DevService {

  public void addPingPong(DiscordApi discordApi){
    discordApi.addMessageCreateListener(event -> {
      if (event.getMessageContent().equalsIgnoreCase("!ping")) {
        event.getChannel().sendMessage("Pong!!!");
      }
    });
  }

  public void addRedBlack(DiscordApi discordApi){
    discordApi.addMessageCreateListener(event -> {
      if (event.getMessageContent().equalsIgnoreCase("red")) {
        event.getChannel().sendMessage("black!!!");
      }
    });
  }
}
