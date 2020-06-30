package com.hyune.raider50g.domain.booking;

import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private RaidInfo raidInfo;

  @Embedded
  private Raider raider;

  public static Booking of(BookingCommand bookingCommand) {
    return Booking.builder()
        .raidInfo(bookingCommand.getRaidInfo())
        .raider(bookingCommand.getRaider())
        .build();
  }
}
