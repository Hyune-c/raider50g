package com.hyune.raider50g.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.hyune.raider50g.domain.booking.Booking;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Booking : Repository")
@SpringBootTest
class BookingRepositoryTest {

  @Autowired
  private BookingRepository bookingRepository;

  @DisplayName("find")
  @Nested
  class FindTest {

    @DisplayName("One")
    @Test
    void findOne() {
      // given
      LocalDate findDate = LocalDate.of(2020, 7, 5);
      String findUserId = "드루티어는오십골";

      // when
      Booking findBookings = bookingRepository.findOne(findDate, findUserId);

      // then
      assertThat(findBookings)
          .isNotNull();
    }

    @DisplayName("All")
    @Test
    void findAll() {
      // given
      LocalDate findDate = LocalDate.of(2020, 7, 5);

      // when
      List<Booking> findBookings = bookingRepository.findAll(findDate);

      // then
      assertThat(findBookings).hasSizeGreaterThan(0);
    }
  }
}
