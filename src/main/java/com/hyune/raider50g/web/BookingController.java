package com.hyune.raider50g.web;

import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import com.hyune.raider50g.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}