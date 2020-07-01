package com.hyune.raider50g.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassType {

  DRUID("DRUID", "드루"), HUNTER("HUNTER", "냥꾼"), MAGE("MAGE", "법사"), PRIEST("PRIEST", "사제"), ROUGE(
      "ROUGE", "도적"), SHAMAN("SHAMAN", "술사"), WARLOCK("WARLOCK", "흑마"), WARRIOR_DEALER(
      "WARRIOR_DEALER", "딜전"), WARRIOR_TANK("WARRIOR_TANK", "탱전");

  private final String key;
  private final String name;
}
