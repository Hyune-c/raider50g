package com.hyune.raider50g.controller;

import com.hyune.raider50g.config.ConfigureDiscordApi;
import com.hyune.raider50g.service.DiscordService;
import org.javacord.api.DiscordApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discord")
public class DiscordController {

  private final DiscordApi discordApi;
  private final DiscordService discordService;

  public DiscordController(DiscordService discordService) {
    this.discordService = discordService;
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
  }
}
