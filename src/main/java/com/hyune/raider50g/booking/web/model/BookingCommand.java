package com.hyune.raider50g.booking.web.model;

import com.hyune.raider50g.booking.data.RaidInfo;
import com.hyune.raider50g.booking.data.Raider;
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
}
