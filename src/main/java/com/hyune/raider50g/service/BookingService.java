package com.hyune.raider50g.service;

import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import com.hyune.raider50g.repository.BookingRepository;
import java.time.LocalDate;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookingService {

  private final BookingRepository bookingRepository;

  public Booking createBooking(BookingCommand bookingCommand) {
    return bookingRepository.save(Booking.of(bookingCommand));
  }

  public String makeInviteMacro(LocalDate findDate) {
    return bookingRepository.find(findDate).stream()
        .map(booking -> "/초대 " + booking.getRaider().getRaiderId())
        .collect(Collectors.joining("\n"));
  }
}
