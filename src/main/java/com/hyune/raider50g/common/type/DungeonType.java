package com.hyune.raider50g.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DungeonType {
  TEST("TEST", "UNKNOWN", "704974161008787489"),
  BLACKWING("BLACKWING", "검은날개둥지", "675761367709646879"),
  AHNQIRAJ("AHNQIRAJ", "안퀴라즈사원", "739010555049934879");

  private final String key;
  private final String name;
  private final String channelId;
}
