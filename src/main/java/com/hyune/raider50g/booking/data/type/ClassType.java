package com.hyune.raider50g.booking.data.type;

import static java.util.Arrays.asList;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassType {
  DRUID("DRUID", asList("드루")), HUNTER("HUNTER", asList("냥꾼")), MAGE("MAGE", asList("법사")), PRIEST(
      "PRIEST", asList("사제")), ROUGE("ROUGE", asList("도적")), SHAMAN("SHAMAN",
      asList("술사", "주술사")), WARLOCK("WARLOC¬K", asList("흑마")), WARRIOR_DEALER("WARRIOR_DEALER",
      asList("딜전")), WARRIOR_TANK("WARRIOR_TANK", asList("탱전"));

  private final String key;
  private final List<String> names;
}
