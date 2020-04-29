package com.hyune.raider50g.controller;

import com.hyune.raider50g.config.ConfigureDiscordApi;
import com.hyune.raider50g.service.DevService;
import org.javacord.api.DiscordApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev-api")
public class DevController {

  private final DiscordApi discordApi;
  private final DevService devService;

  public DevController(DevService devService) {
    this.devService = devService;
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
  }

  @GetMapping("/test")
  public String test() {
    return "hello";
  }

  @GetMapping("/pingpong")
  public String addPingPong() {
    devService.addPingPong(discordApi);
    return "hello";
  }

  @GetMapping("/redblack")
  public String addRedBlack() {
    devService.addRedBlack(discordApi);
    return "hello";
  }
}
