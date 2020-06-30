package com.hyune.raider50g;

import com.hyune.raider50g.config.property.DiscordProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(DiscordProperty.class)
@SpringBootApplication
public class Raider50gApplication {

  public static void main(String[] args) {
    SpringApplication.run(Raider50gApplication.class, args);
  }
}
