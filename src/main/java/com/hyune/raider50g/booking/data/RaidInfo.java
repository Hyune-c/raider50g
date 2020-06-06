package com.hyune.raider50g.booking.data;


import com.hyune.raider50g.booking.data.type.RaidType;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
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
public class RaidInfo {

  @ApiModelProperty(hidden = true)
  @Column(nullable = false)
  private final LocalDate createdAt = LocalDate.now();

  @ApiModelProperty(hidden = true)
  @Column(nullable = false)
  private Boolean cancel = false;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RaidType raidType;

  @Column(nullable = false)
  private LocalDate raidDate;

  @Builder
  public RaidInfo(RaidType raidType, LocalDate raidDate) {
    this.raidType = raidType;
    this.raidDate = raidDate;
  }

  public void cancel() {
    this.cancel = true;
  }
}
