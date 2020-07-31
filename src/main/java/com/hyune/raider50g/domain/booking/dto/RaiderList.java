package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
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
public class RaiderList {

  private final MultiValueMap<ClassType, String> classListMap;

  public static RaiderList of(List<Booking> bookings) {
    MultiValueMap<ClassType, String> classListMap = new LinkedMultiValueMap<>();
    bookings.forEach(booking -> classListMap.add(booking.getClassType(), booking.getUserName()));

    return RaiderList.builder()
        .classListMap(classListMap)
        .build();
  }

  public int raiderCount() {
    return classListMap.keySet().stream()
        .map(key -> classListMap.get(key).size())
        .reduce(Integer::sum)
        .orElse(0);
  }

  public String makeClassLine(ClassType key) {
    return (Objects.isNull(classListMap.get(key)))
        // 예약이 없는 직업군이면
        ? String.format("%s (0/%d)", key.getName(), key.getMaxCount())
        // 예약이 있는 직업군이면
        : classListMap.get(key).stream().collect(Collectors.joining(
            "\t",
            String.format("%s (%d/%d)\t", key.getName(), classListMap.get(key).size(),
                key.getMaxCount()),
            ""));
  }
}
