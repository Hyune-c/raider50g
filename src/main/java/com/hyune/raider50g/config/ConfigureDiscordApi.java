package com.hyune.raider50g.config;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigureDiscordApi {
  private static DiscordApi discordApi;

  @Value("${discord.token}")
  public void setDiscordApi(String botToken) {
    discordApi = new DiscordApiBuilder().setToken(botToken).login().join();
  }

  public static DiscordApi getDiscordApi() {
    return discordApi;
  }
}
