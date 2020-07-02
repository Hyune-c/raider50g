package com.hyune.raider50g.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.RaidInfo;
import com.hyune.raider50g.domain.booking.Raider;
import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Booking : Service")
@SpringBootTest
public class BookingServiceTest {

  @Autowired
  BookingService bookingService;

  @DisplayName("초대 매크로 만들기")
  @Test
  public void makeInviteMacro() {
    // given
    LocalDate findDate = LocalDate.of(2020, 7, 5);

    // when
    String inviteMacro = bookingService.makeInviteMacro(findDate);

    // then
    assertThat(inviteMacro)
        .contains("/초대 ");
  }

  @DisplayName("취소하기")
  @Test
  public void cancelBooking() {
    // given
    DungeonType dungeonType = DungeonType.BLACKWING;
    LocalDate raidDate = LocalDate.of(2020, 7, 5);
    RaidInfo raidInfo = RaidInfo.of(dungeonType, raidDate);

    ClassType classType = ClassType.DRUID;
    String raiderId = "드루티어는오십골";
    Raider raider = Raider.builder()
        .classType(classType)
        .raiderId(raiderId)
        .build();

    BookingCommand bookingCommand = BookingCommand.builder()
        .raidInfo(raidInfo)
        .raider(raider)
        .build();

    // when
    Booking cancelBooking = bookingService.cancelBooking(bookingCommand);

    // then
    assertThat(cancelBooking.getRaidInfo().getCancel())
        .isTrue();
  }
}