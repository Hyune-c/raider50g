package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.Builder;

@Builder
public class RaiderList {

  private HashMap<ClassType, ArrayList<String>> descMap;

  public static RaiderList of(List<Booking> bookings) {
    HashMap<ClassType, ArrayList<String>> descMap = new HashMap<>();
    Arrays.stream(ClassType.values())
        .forEach(classType -> descMap.put(classType, new ArrayList<>()));
    bookings.forEach(booking -> descMap.get(booking.getClassType()).add(booking.getUserName()));

    return RaiderList.builder()
        .descMap(descMap)
        .build();
  }

  public int size() {
    return descMap.keySet().stream()
        .mapToInt(key -> descMap.get(key).size())
        .reduce(Integer::sum)
        .orElse(0);
  }

  public int size(ClassType classType) {
    return (Objects.isNull(descMap.get(classType)))
        ? 0
        : descMap.get(classType).size();
  }

  public List<String> getRaiders(ClassType classType) {
    return Optional.ofNullable(descMap.get(classType))
        .orElse(new ArrayList<>());
  }
}
