package com.hyune.raider50g.booking.data;


import com.hyune.raider50g.booking.data.type.RaidType;
import com.hyune.raider50g.model.type.ClassType;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Boolean cancel;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RaidType raidType;

  @Column(nullable = false)
  private LocalDate date;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ClassType classType;

  @Column(nullable = false)
  private String raiderId;

  @Column(nullable = false)
  private LocalDate createdAt;
}
