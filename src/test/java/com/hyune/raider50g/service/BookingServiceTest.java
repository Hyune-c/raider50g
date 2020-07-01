package com.hyune.raider50g.service;

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

  @DisplayName("makeInviteMacro")
  @Test
  void makeInviteMacro() {
    // given
    LocalDate findDate = LocalDate.of(2020, 7, 5);

    // when
    String inviteMacro = bookingService.makeInviteMacro(findDate);

    // then
    System.out.println(inviteMacro);
  }
}
