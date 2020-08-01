package com.hyune.raider50g.domain.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
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
public class Booking implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Builder.Default
  @Column(nullable = false)
  private Boolean cancel = false;

  @Builder.Default
  @Column(nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

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

  public void cancel() {
    if (cancel) {
      throw new RuntimeException("이미 취소된 예약 입니다");
    }

    cancel = true;
  }

  @JsonIgnore
  public String getUserName() {
    return raider.getUserName();
  }

  @JsonIgnore
  public ClassType getClassType() {
    return raider.getClassType();
  }

  @JsonIgnore
  public String inviteMacro() {
    return "/초대 " + raider.getUserName();
  }
}
