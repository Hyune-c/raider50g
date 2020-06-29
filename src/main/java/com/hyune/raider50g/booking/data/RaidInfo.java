package com.hyune.raider50g.booking.data;

import com.hyune.raider50g.booking.data.type.DungeonType;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
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
  private LocalDate createdAt = LocalDate.now();

  public static RaidInfo from(DungeonType dungeonType, LocalDate raidDate) {
    return RaidInfo.builder()
        .dungeonType(dungeonType)
        .raidDate(raidDate)
        .build();
  }

  public void cancel() {
    this.cancel = true;
  }
}
