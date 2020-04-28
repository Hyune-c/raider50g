package com.hyune.raider50g;

import com.hyune.raider50g.config.Properties;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Raider50gApplication {

  public static void main(String[] args) {
    SpringApplication.run(Raider50gApplication.class, args);

    String token = Properties.getBotToken();
    log.debug("### token : {} ", token);

    DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

    api.addMessageCreateListener(event -> {
      if (event.getMessageContent().equalsIgnoreCase("!ping")) {
        event.getChannel().sendMessage("Pong!");
      }
    });
  }
}
