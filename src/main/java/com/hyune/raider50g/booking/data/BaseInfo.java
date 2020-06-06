package com.hyune.raider50g.booking.data;


import com.hyune.raider50g.booking.data.type.RaidType;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class BaseInfo {

  @Column(nullable = false)
  private Boolean cancel;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RaidType raidType;

  @Column(nullable = false)
  private LocalDate date;

  @Column(nullable = false)
  private LocalDate createdAt;
}
