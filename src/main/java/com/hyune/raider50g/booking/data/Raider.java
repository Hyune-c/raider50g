package com.hyune.raider50g.booking.data;


import com.hyune.raider50g.booking.data.type.ClassType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class Raider {

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ClassType classType;

  @Column(nullable = false)
  private String raiderId;

  @Builder
  public Raider(ClassType classType, String raiderId) {
    this.classType = classType;
    this.raiderId = raiderId;
  }
}
