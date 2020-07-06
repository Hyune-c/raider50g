package com.hyune.raider50g.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "discord")
public class DiscordProperty {

  private String token;
  private String apiUrl;
  private String userAgent;
}
