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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Builder
@AllArgsConstructor
public class BookingList {

  private RaidInfo raidInfo;
  private MultiValueMap<String, String> bookingsMap;

  public static BookingList of(RaidInfo raidInfo, List<Booking> bookings) {
    MultiValueMap<String, String> bookingsMap = new LinkedMultiValueMap<>();
    bookings.forEach(
        booking -> bookingsMap.add(booking.getClassType().getName(), booking.getRaiderId()));

    return BookingList.builder()
        .raidInfo(raidInfo)
        .bookingsMap(bookingsMap)
        .build();
  }

  public Integer bookingCount() {
    return bookingsMap.keySet().stream()
        .map(key -> bookingsMap.get(key).size())
        .reduce(Integer::sum)
        .orElse(0);
  }

  public String getTitle() {
    return String.format("%s\t%s (일) PM 19:00\t%d/40"
        , raidInfo.getDungeonType().getName()
        , raidInfo.getRaidDate()
        , bookingCount());
  }

  public String getContents() {
    // 예약된 인원이 존재하는 직업을 String 화 합니다
    String existClass = bookingsMap.keySet().stream()
        .map(key -> bookingsMap.get(key).stream()
            .collect(Collectors.joining("\t", key + " " + bookingsMap.get(key).size() + "\t", "")))
        .collect(Collectors.joining("\n", "", "\n"));

    // 예약된 인원이 존재하지 않는 직업을 String 화 합니다
    String notExistClass = (ClassType.values().length == bookingsMap.size())
        ? ""
        : Arrays.stream(ClassType.values())
            .map(ClassType::getName)
            .filter(className -> !bookingsMap.containsKey(className))
            .collect(Collectors.joining(" 0 \n", "", " 0 \n"));

    return existClass + notExistClass;
  }

  public String createBookingSheet() {
    return String.format("```%s``````%s```", getTitle(), getContents());
  }
}
