package com.hyune.raider50g.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassType {

  DRUID("DRUID", "드루", 2, 2),
  HUNTER("HUNTER", "냥꾼", 3, 3),
  MAGE("MAGE", "법사", 6, 7),
  PRIEST("PRIEST", "사제", 4, 5),
  ROUGE("ROUGE", "도적", 4, 6),
  SHAMAN("SHAMAN", "술사", 4, 6),
  WARLOCK("WARLOCK", "흑마", 2, 3),
  WARRIOR_DEALER("WARRIOR_DEALER", "딜전", 4, 6),
  WARRIOR_TANK("WARRIOR_TANK", "탱전", 2, 3),
  GUEST("GUEST", "손님", 4, 5);

  private final String key;
  private final String name;
  private final int minCount;
  private final int maxCount;
}
