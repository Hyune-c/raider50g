package com.hyune.raider50g.booking.data;


import com.hyune.raider50g.model.type.ClassType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class Raider {

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ClassType classType;

  @Column(nullable = false)
  private String raiderId;
}
