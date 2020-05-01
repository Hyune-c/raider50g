package com.hyune.raider50g.controller;

import com.hyune.raider50g.model.ApiResponse;
import com.hyune.raider50g.service.DiscordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discord")
public class DiscordController {

  private final DiscordService discordService;

  public DiscordController(DiscordService discordService) {
    this.discordService = discordService;
  }

  @GetMapping("/messages")
  public ApiResponse messages(
      @RequestParam(required = false) String after) {
    return ApiResponse.ok(discordService.getChannelMessages(after));
  }

  @GetMapping("/messages/{messageId}")
  public ApiResponse message(@PathVariable String messageId) {
    return ApiResponse.ok(discordService.getChannelMessage(messageId));
  }

  @GetMapping("/booking")
  public ApiResponse booking(@RequestParam String messageId) {
    return ApiResponse.ok(discordService.booking(messageId));
  }
}
