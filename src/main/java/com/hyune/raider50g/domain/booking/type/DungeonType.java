package com.hyune.raider50g.domain.booking.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DungeonType {
  BLACKWING("BLACKWING", "검은날개둥지");

  private final String key;
  private final String name;
}
