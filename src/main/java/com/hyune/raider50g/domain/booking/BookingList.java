package com.hyune.raider50g.domain.booking;

import com.hyune.raider50g.common.type.ClassType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BookingList {

  private RaidInfo raidInfo;
  private List<Booking> bookings;

  public String getTitle() {
    return String.format("%s\t%s (일) PM 19:00\t%d/40", raidInfo.getDungeonType().getName(),
        raidInfo.getRaidDate(), bookings.size());
  }

  public String getContents() {
    return Arrays.stream(ClassType.values()).map(classType ->
        classType.getName() + "\t" + bookings.stream()
            .filter(booking -> booking.getClassType().equals(classType))
            .map(Booking::getRaiderId)
            .collect(Collectors.joining("\t"))
    ).collect(Collectors.joining("\n"));
  }

  public String createBookingSheet() {
    return String.format("```%s``````%s```", getTitle(), getContents());
  }
}
