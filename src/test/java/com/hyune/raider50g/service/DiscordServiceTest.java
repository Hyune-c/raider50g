package com.hyune.raider50g.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.hyune.raider50g.Util.JsonUtil;
import com.hyune.raider50g.message.Mock;
import com.hyune.raider50g.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiscordServiceTest {

  @Autowired
  private DiscordService discordService;

  @Test
  void booking_bot() {
    assertThat(discordService.booking(JsonUtil.objectToMessage(Mock.BOOKING_BOT)))
        .isNull();
  }

  @Test
  void booking_not_bot() {
    assertThat(discordService.booking(JsonUtil.objectToMessage(Mock.BOOKING_NOT_BOT)))
        .isInstanceOf(Message.class);
  }
}
