package com.hyune.raider50g.web;

import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import com.hyune.raider50g.service.BookingService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/booking")
@RestController
public class BookingController {

  private final BookingService bookingService;

  @PostMapping
  public Booking createBooking(@RequestBody BookingCommand bookingCommand) {
    return bookingService.createBooking(bookingCommand);
  }

  @PatchMapping
  public Booking cancelBooking(@RequestBody BookingCommand bookingCommand) {
    return bookingService.cancelBooking(bookingCommand);
  }

  @GetMapping("/invite-macro")
  public String makeInviteMacro(
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate raidDate,
      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String exceptUserName) {
    return bookingService.makeInviteMacro(raidDate, exceptUserName);
  }
}
