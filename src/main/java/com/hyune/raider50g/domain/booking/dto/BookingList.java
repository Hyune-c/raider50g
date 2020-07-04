package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.RaidInfo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Builder
@AllArgsConstructor
public class BookingList {

  private RaidInfo raidInfo;
  private MultiValueMap<String, String> bookingsSheet;

  public static BookingList of(RaidInfo raidInfo, List<Booking> bookings) {
    MultiValueMap<String, String> bookingsMap = new LinkedMultiValueMap<>();
    bookings.forEach(
        booking -> bookingsMap.add(booking.getClassType().getName(), booking.getRaiderId()));

    return BookingList.builder()
        .raidInfo(raidInfo)
        .bookingsSheet(bookingsMap)
        .build();
  }

  public int bookingCount() {
    int result = 0;
    for (String key : bookingsSheet.keySet()) {
      result += bookingsSheet.get(key).size();
    }

    return result;
  }

  public String getTitle() {
    return String.format("%s\t%s (일) PM 19:00\t%d/40"
        , raidInfo.getDungeonType().getName()
        , raidInfo.getRaidDate()
        , bookingCount());
  }

  public String getContents() {
    StringBuilder sb = new StringBuilder();

    for (String key : bookingsSheet.keySet()) {
      sb.append(key + " " + bookingsSheet.get(key).size() + "\t");
      bookingsSheet.get(key).forEach(raiderName -> sb.append(raiderName + "\t"));
      sb.append("\n");
    }

    return sb.toString();
  }

  public String createBookingSheet() {
    return String.format("```%s``````%s```", getTitle(), getContents());
  }
}
