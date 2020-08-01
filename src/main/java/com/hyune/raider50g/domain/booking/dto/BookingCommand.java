package com.hyune.raider50g.domain.booking.dto;

import com.hyune.raider50g.domain.booking.RaidInfo;
import com.hyune.raider50g.domain.booking.Raider;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BookingCommand {

  private RaidInfo raidInfo;
  private Raider raider;

  public LocalDate getRaidDate() {
    return raidInfo.getRaidDate();
  }

  public String getRaiderName() {
    return raider.getUserName();
  }
}
