package com.hyune.raider50g.booking.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RaidType {
  BLACKWING("BLACKWING", "검은날개둥지");

  private final String key;
  private final String name;
}
