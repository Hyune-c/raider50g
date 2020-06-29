package com.hyune.raider50g.service;

import com.hyune.raider50g.common.type.Channel;
import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.repository.BookingRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChannelService {

  private final BookingRepository bookingRepository;

  private String makeBookingList(Channel channel, LocalDate raidDate, List<Booking> bookings) {
    StringBuilder sb = new StringBuilder();

    String title = "```" + channel.getKey() + "\t" + raidDate + "\t" + bookings.size() + "/40```";
    sb.append(title);

    sb.append("```");
    for (ClassType classType : ClassType.values()) {
      sb.append(classType.getNames().get(0)).append("\t");
      sb.append(bookings.stream()
          .filter(booking -> classType.equals(booking.getRaider().getClassType()))
          .map(booking -> booking.getRaider().getRaiderId())
          .collect(Collectors.joining("\t")));
      sb.append("\n");
    }
    sb.append("```");

    return sb.toString();
  }

  public String sendBookingList(Channel channel, LocalDate raidDate) {
    return makeBookingList(channel, raidDate, bookingRepository.find(raidDate));
  }
}
