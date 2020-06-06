package com.hyune.raider50g.booking.data;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

  @Builder
  public Booking(RaidInfo raidInfo, Raider raider) {
    this.raidInfo = raidInfo;
    this.raider = raider;
  }
}
