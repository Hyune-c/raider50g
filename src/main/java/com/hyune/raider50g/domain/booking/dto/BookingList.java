package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.RaidInfo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;

@Builder
public class BookingList {

  private RaidInfo raidInfo;
  private RaiderList raiderList;

  public static BookingList of(RaidInfo raidInfo, List<Booking> bookings) {
    return BookingList.builder()
        .raidInfo(raidInfo)
        .raiderList(RaiderList.of(bookings))
        .build();
  }

  private int bookingCount() {
    return raiderList.size();
  }

  public String createBookingSheet() {
    final String CATEGORY = "직업 현재/최대\t예약 인원\t(2~3탱전 10힐 4~5손님)";
    final String BOOKING_SHEET_FORMAT = "%s\n\n```%s``````%s``````%s```";
    return String.format(BOOKING_SHEET_FORMAT
        , getNotice(), getTitle(), CATEGORY, getContent());
  }

  private String getContent() {
    final String CONTENT_FORMAT = "%s\t%s";
    return Arrays.stream(ClassType.values())
        .map(classType -> String.format(CONTENT_FORMAT
            , classHeader(classType), classBody(classType)))
        .collect(Collectors.joining("\n", "", "\n"));
  }

  private String getTitle() {
    final String TITLE_FORMAT = "%s\t%s (일) PM 19:00\t%d/40";
    return String.format(TITLE_FORMAT
        , raidInfo.getDungeonType().getName(), raidInfo.getRaidDate(), bookingCount());
  }

  private String getNotice() {
    final String NOTICE_FORMAT = "손님팟 룰 : %s";
    final String NOTICE_CONTENT = "https://discordapp.com/channels/256380741229871104/684266401661583439/730015381598502963";
    return String.format(NOTICE_FORMAT, NOTICE_CONTENT);
  }

  private String classHeader(ClassType classType) {
    final String CLASS_HEADER_FORMAT = "%s (%d/%d)";
    return String.format(CLASS_HEADER_FORMAT
        , classType.getName(), raiderList.size(classType), classType.getMaxCount());
  }

  private String classBody(ClassType classType) {
    return (raiderList.size(classType) == 0)
        ? ""
        : String.join("\t", raiderList.getRaiders(classType));
  }
}
