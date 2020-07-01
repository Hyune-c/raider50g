package com.hyune.raider50g.domain.booking;

import com.hyune.raider50g.common.type.DungeonType;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class RaidInfo {

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private DungeonType dungeonType;

  @Column(nullable = false)
  private LocalDate raidDate;

  @ApiModelProperty(hidden = true)
  @Builder.Default
  @Column(nullable = false)
  private Boolean cancel = false;

  @ApiModelProperty(hidden = true)
  @Builder.Default
  @Column(nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  public static RaidInfo of(DungeonType dungeonType, LocalDate raidDate) {
    return RaidInfo.builder()
        .dungeonType(dungeonType)
        .raidDate(raidDate)
        .build();
  }

  public void cancel() {
    if (cancel) {
      throw new RuntimeException("이미 취소된 예약 입니다");
    }

    cancel = true;
  }
}
