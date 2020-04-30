package com.hyune.raider50g.service;

import com.hyune.raider50g.config.ConfigureDiscordApi;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DiscordService {

  private final DiscordApi discordApi;

  public DiscordService() {
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
  }
}
