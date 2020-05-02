package com.hyune.raider50g.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookingType {
  BOOKING("예약"), CANCEL("취소");

  private final String type;
}
