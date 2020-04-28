package com.hyune.raider50g.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

  private static String BOT_TOKEN;

  public static String getBotToken() {
    return BOT_TOKEN;
  }

  @Value("${discord.token}")
  public void setBotToken(String botToken) {
    BOT_TOKEN = botToken;
  }
}
