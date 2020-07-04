package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.RaidInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

  private final RaidInfo raidInfo;
  private final MultiValueMap<ClassType, String> classListMap;

  public static BookingList of(RaidInfo raidInfo, List<Booking> bookings) {
    MultiValueMap<ClassType, String> classListMap = new LinkedMultiValueMap<>();
    bookings.forEach(
        booking -> classListMap.add(booking.getClassType(), booking.getRaiderId()));

    return BookingList.builder()
        .raidInfo(raidInfo)
        .classListMap(classListMap)
        .build();
  }

  private Integer bookingCount() {
    return classListMap.keySet().stream()
        .map(key -> classListMap.get(key).size())
        .reduce(Integer::sum)
        .orElse(0);
  }

  private String makeClassLine(ClassType key) {
    return (Objects.isNull(classListMap.get(key)))
        // 예약이 없는 직업군이면
        ? String.format("%s (0/%d)", key.getName(), key.getMaxCount())
        // 예약이 있는 직업군이면
        : classListMap.get(key).stream().collect(Collectors.joining(
            "\t",
            String.format("%s (%d/%d)", key.getName(), classListMap.get(key).size(),
                key.getMaxCount()),
            ""));
  }

  public String createBookingSheet() {
    String title = String.format("%s\t%s (일) PM 19:00\t%d/40"
        , raidInfo.getDungeonType().getName()
        , raidInfo.getRaidDate()
        , bookingCount());
    String category = "직업 현재/최대\t예약 인원\t(2~3탱전 11힐)";
    String contents = Arrays.stream(ClassType.values())
        .map(this::makeClassLine)
        .collect(Collectors.joining("\n", "", "\n"));

    return String.format("```%s``````%s``````%s```", title, category, contents);
  }
}
