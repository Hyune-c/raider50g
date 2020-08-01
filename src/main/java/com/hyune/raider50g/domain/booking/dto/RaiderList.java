package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.Booking;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Builder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Builder
public class RaiderList {

  private MultiValueMap<ClassType, String> descList;

  public static RaiderList of(List<Booking> bookings) {
    MultiValueMap<ClassType, String> descList = new LinkedMultiValueMap<>();
    bookings.forEach(booking -> descList.add(booking.getClassType(), booking.getUserName()));

    return RaiderList.builder()
        .descList(descList)
        .build();
  }

  public int size() {
    return descList.keySet().stream()
        .mapToInt(key -> descList.get(key).size())
        .reduce(Integer::sum)
        .orElse(0);
  }

  public int size(ClassType classType) {
    return (Objects.isNull(descList.get(classType)))
        ? 0
        : descList.get(classType).size();
  }

  public List<String> getRaiders(ClassType classType) {
    return new ArrayList<>(descList.get(classType));
  }
}
