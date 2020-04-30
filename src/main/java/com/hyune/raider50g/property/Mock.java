package com.hyune.raider50g.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mock {

  private static String BOT_TOKEN;

  @Value("${discord.token}")
  public void setDiscordApi(String botToken) {
    BOT_TOKEN = botToken;
  }

  public static String getBotToken() {
    return BOT_TOKEN;
  }

  public static String DISCORD_API_URL = "https://discordapp.com/api";
  public static String CHANNEL_BLACKWING = "704974219079057488";
}
