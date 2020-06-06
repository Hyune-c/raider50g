package com.hyune.raider50g.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Token {

  private static String BOT_TOKEN;

  @Value("${discord.token}")
  public void setDiscordApi(String botToken) {
    BOT_TOKEN = botToken;
  }

  public static String getBotToken() {
    return BOT_TOKEN;
  }
}
