package com.hyune.raider50g.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Channel {

  TEST("TEST", "704974161008787489"),
  BLACKWING("BLACKWING", "675761367709646879");

  private final String key;
  private final String channelId;
}
