package com.hyune.raider50g.service;

import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.domain.channel.DiscordMessage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("WebClient : Service")
@SpringBootTest
public class WebClientServiceTest {

  @Autowired
  WebClientService webClientService;

  @Nested
  @DisplayName("채널에서 메세지들 가져오기")
  public class GetMessagesTest {

    @DisplayName("지정된 author 없이")
    @Test
    public void withNullAuthor() {
      // given

      // when
      List<DiscordMessage> discordMessages = webClientService
          .getMessages(DungeonType.TEST.getChannelId(), 50, null);

      // then
      Assertions.assertThat(discordMessages)
          .hasSize(50);
    }

    @DisplayName("지정된 author 있이")
    @Test
    public void withAuthor() {
      // given

      // when
      List<DiscordMessage> discordMessages = webClientService
          .getMessages(DungeonType.TEST.getChannelId(), 50, "50G BOT");

      // then
      Assertions.assertThat(discordMessages)
          .hasSizeGreaterThan(0)
          .hasSizeLessThan(50);
    }
  }
}
