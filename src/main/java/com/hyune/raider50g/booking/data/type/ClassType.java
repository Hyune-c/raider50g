package com.hyune.raider50g.booking.data.type;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassType {
  DRUID("DRUID", Arrays.asList("드루")), HUNTER("HUNTER", Arrays.asList("냥꾼")), MAGE("MAGE", Arrays
      .asList("법사")), PRIEST("PRIEST", Arrays.asList("사제")), ROUGE("ROUGE",
      Arrays.asList("도적")), SHAMAN("SHAMAN", Arrays.asList("술사", "주술사")), WARLOCK("WARLOCK",
      Arrays.asList("흑마")), WARRIOR_DEALER("WARRIOR_DEALER", Arrays.asList("딜전")), WARRIOR_TANK(
      "WARRIOR_TANK", Arrays.asList("탱전"));

  private final String key;
  private final List<String> names;
}
