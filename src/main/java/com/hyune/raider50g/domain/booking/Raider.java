package com.hyune.raider50g.domain.booking;

import com.hyune.raider50g.common.type.ClassType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Embeddable
public class Raider {

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ClassType classType;

  @Column(nullable = false)
  private String raiderId;

  public String inviteMacro() {
    return "/초대 " + raiderId;
  }
}
