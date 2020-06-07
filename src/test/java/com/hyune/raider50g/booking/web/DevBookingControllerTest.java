package com.hyune.raider50g.booking.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.hyune.raider50g.booking.data.RaidInfo;
import com.hyune.raider50g.booking.data.Raider;
import com.hyune.raider50g.booking.data.type.ClassType;
import com.hyune.raider50g.booking.data.type.RaidType;
import com.hyune.raider50g.booking.web.model.BookingCommand;
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
    RaidType raidType = RaidType.BLACKWING;
    LocalDate raidDate = LocalDate.now().plusDays(7);
    RaidInfo raidInfo = RaidInfo.builder()
        .raidType(raidType)
        .raidDate(raidDate).build();

    ClassType classType = ClassType.DRUID;
    String raiderId = "드루티어는오십골";
    Raider raider = Raider.builder()
        .classType(classType)
        .raiderId(raiderId).build();

    // when
    BookingCommand bookingCommand = BookingCommand.builder()
        .raidInfo(raidInfo.getTestRaidInfo())
        .raider(raider).build();

    // then
    assertThat(bookingCommand).isNotNull();
    assertThat(bookingCommand.getRaider().getRaiderId()).isEqualTo(raiderId);
    assertThat(bookingCommand.getRaidInfo().getRaidDate()).isEqualTo(raidDate);
    assertThat(bookingCommand.getRaidInfo().getCancel()).isNull();
    assertThat(bookingCommand.getRaidInfo().getCreatedAt()).isNull();
  }
}
