package com.hyune.raider50g.controller;

import com.hyune.raider50g.service.DiscordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discord")
public class DiscordController {

  private final DiscordService discordService;

  public DiscordController(DiscordService discordService) {
    this.discordService = discordService;
  }
}
