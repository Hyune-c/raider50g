package com.hyune.raider50g.model.type;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassType {
  DRUID(Arrays.asList("드루")), HUNTER(Arrays.asList("냥꾼")), MAGE(Arrays.asList("법사")), PRIEST(
      Arrays.asList("사제")), ROUGE(Arrays.asList("도적")), SHAMAN(Arrays.asList("술사", "주술사")), WARLOCK(
      Arrays.asList("흑마")), WARRIOR_TANK(Arrays.asList("탱전")), WARRIOR_DEALER(Arrays.asList("딜전"));

  private final List<String> type;
}
