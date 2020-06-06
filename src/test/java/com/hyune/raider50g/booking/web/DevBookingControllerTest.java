package com.hyune.raider50g.booking.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.hyune.raider50g.booking.data.RaidInfo;
import com.hyune.raider50g.booking.data.Raider;
import com.hyune.raider50g.booking.data.type.RaidType;
import com.hyune.raider50g.booking.web.model.BookingCommand;
import com.hyune.raider50g.model.type.ClassType;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@DisplayName("예약")
@WebMvcTest(DevBookingControllerTest.class)
class DevBookingControllerTest {

  @DisplayName("Input 객체인 BookingCommand 가 정상적으로 생성되었는지")
  @Test
  void checkInput_BookingCommand() {
    // given
    LocalDate raidDate = LocalDate.now().plusDays(7);
    String raiderId = "드루티어는오십골";

    // when
    RaidInfo raidInfo = RaidInfo.builder()
        .raidType(RaidType.BLACKWING)
        .raidDate(raidDate).build().getTestRaidInfo();
    Raider raider = Raider.builder()
        .classType(ClassType.DRUID)
        .raiderId(raiderId).build();
    BookingCommand bookingCommand = BookingCommand.builder()
        .raidInfo(raidInfo)
        .raider(raider).build();

    // then
    assertThat(bookingCommand).isNotNull();
    assertThat(bookingCommand.getRaider().getRaiderId()).isEqualTo(raiderId);
    assertThat(bookingCommand.getRaidInfo().getRaidDate()).isEqualTo(raidDate);
    assertThat(bookingCommand.getRaidInfo().getCancel()).isNull();
    assertThat(bookingCommand.getRaidInfo().getCreatedAt()).isNull();
  }
}
