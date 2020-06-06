package com.hyune.raider50g.booking.web.model;

import com.hyune.raider50g.booking.data.RaidInfo;
import com.hyune.raider50g.booking.data.Raider;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BookingCommand {

  private RaidInfo raidInfo;
  private Raider raider;

  @Builder
  public BookingCommand(RaidInfo raidInfo, Raider raider) {
    this.raidInfo = raidInfo;
    this.raider = raider;
  }
}
