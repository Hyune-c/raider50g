package com.hyune.raider50g.controller;

import com.hyune.raider50g.config.ConfigureDiscordApi;
import org.javacord.api.DiscordApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discord")
public class DiscordController {

  private final DiscordApi discordApi;

  public DiscordController() {
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
  }

  @GetMapping("/init")
  public String test() {
    discordApi.addMessageCreateListener(event -> {
      if (event.getMessageContent().equalsIgnoreCase("!ping")) {
        event.getChannel().sendMessage("Pong!!!");
      }
    });

    return "hello";
  }
}
