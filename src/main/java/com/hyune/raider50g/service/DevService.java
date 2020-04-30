package com.hyune.raider50g.service;

import com.hyune.raider50g.config.ConfigureDiscordApi;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DevService {

  private final DiscordApi discordApi;

  public DevService() {
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
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
