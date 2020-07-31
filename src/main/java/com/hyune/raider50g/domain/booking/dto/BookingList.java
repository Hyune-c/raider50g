package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.RaidInfo;
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

  private final RaidInfo raidInfo;
  private final RaiderList raiderList;

  public static BookingList of(RaidInfo raidInfo, List<Booking> bookings) {
    return BookingList.builder()
        .raidInfo(raidInfo)
        .raiderList(RaiderList.of(bookings))
        .build();
  }

  private int bookingCount() {
    return raiderList.raiderCount();
  }

  public String createBookingSheet() {
    String notice = String.format("손님팟 룰 : %s",
        "https://discordapp.com/channels/256380741229871104/684266401661583439/730015381598502963");
    String title = String.format("%s\t%s (일) PM 19:00\t%d/40"
        , raidInfo.getDungeonType().getName()
        , raidInfo.getRaidDate()
        , bookingCount());
    String category = "직업 현재/최대\t예약 인원\t(2~3탱전 10힐 4~5손님)";
    String contents = Arrays.stream(ClassType.values())
        .map(raiderList::makeClassLine)
        .collect(Collectors.joining("\n", "", "\n"));

    return String.format("%s\n\n", notice) + String
        .format("```%s``````%s``````%s```", title, category, contents);
  }
}
