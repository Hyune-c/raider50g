package com.hyune.raider50g.booking.web;

import com.hyune.raider50g.booking.web.model.BookingCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/dev-api/booking")
@RestController
public class DevBookingController {

  @PostMapping
  public BookingCommand makeBookingCommand(@RequestBody BookingCommand bookingCommand) {
    return bookingCommand;
  }
}
