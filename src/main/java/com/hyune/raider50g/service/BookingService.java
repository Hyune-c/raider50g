package com.hyune.raider50g.service;

import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.RaidInfo;
import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import com.hyune.raider50g.domain.booking.dto.BookingList;
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
        , bookingCommand.getRaider().getUserName());
    return bookingRepository.cancel(findBooking);
  }

  public String makeInviteMacro(LocalDate findDate, String exceptUserName) {
    return bookingRepository.findAll(findDate).stream()
        .filter(booking -> !booking.getUserName().equals(exceptUserName))
        .map(booking -> booking.getRaider().inviteMacro())
        .collect(Collectors.joining("\n"));
  }

  public BookingList createBookingList(DungeonType dungeonType, LocalDate raidDate) {
    RaidInfo raidInfo = RaidInfo.builder()
        .dungeonType(dungeonType)
        .raidDate(raidDate)
        .build();
    return BookingList.of(raidInfo, bookingRepository.findAll(raidDate));
  }
}
