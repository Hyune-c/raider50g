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

  public Booking cancelBooking(BookingCommand bookingCommand) {
    Booking findBooking = bookingRepository.findOne(bookingCommand.getRaidInfo().getRaidDate()
        , bookingCommand.getRaider().getRaiderId());
    return bookingRepository.cancel(findBooking);
  }

  public String makeInviteMacro(LocalDate findDate) {
    return bookingRepository.findAll(findDate).stream()
        .map(booking -> booking.getRaider().inviteMacro())
        .collect(Collectors.joining("\n"));
  }
}
