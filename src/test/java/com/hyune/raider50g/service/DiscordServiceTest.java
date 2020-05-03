package com.hyune.raider50g.service;

import static com.hyune.raider50g.message.Booking.INVALID_AUTHOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.hyune.raider50g.Util.JsonUtil;
import com.hyune.raider50g.exception.FailedBookingException;
import com.hyune.raider50g.message.Mock;
import com.hyune.raider50g.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiscordServiceTest {

  @Autowired
  private DiscordService discordService;

  @Test
  void booking_bot() {
    assertThatExceptionOfType(FailedBookingException.class).isThrownBy(() -> {
      discordService.booking(JsonUtil.objectToMessage(Mock.BOOKING_BOT));
    }).withMessage(INVALID_AUTHOR);
  }

  @Test
  void booking_not_bot() {
    assertThat(discordService.booking(JsonUtil.objectToMessage(Mock.BOOKING_NOT_BOT)))
        .isInstanceOf(Booking.class);
  }
}
