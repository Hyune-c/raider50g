package com.hyune.raider50g.domain.booking;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.data.TestJsonData;
import com.hyune.raider50g.domain.booking.dto.BookingList;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BookingList : POJO")
class BookingListTest {

  @DisplayName("예약 인원 리스트 만들기")
  @Test
  public void createBookingList() {
    // given
    DungeonType dungeonType = DungeonType.BLACKWING;
    LocalDate raidDate = LocalDate.of(2020, 7, 5);
    RaidInfo raidInfo = RaidInfo.builder()
        .dungeonType(dungeonType)
        .raidDate(raidDate)
        .build();

    List<Booking> bookings = new Gson().fromJson(
        TestJsonData.LIST_OF_BOOKING
        , new TypeToken<List<Booking>>() {
        }.getType());

    // when
    BookingList bookingList = BookingList.of(raidInfo, bookings);

    // then
    assertThat(bookingList)
        .isNotNull();
    assertThat(bookingList.createBookingSheet())
        .contains("드루티어는오십골")
        .contains("사제 (0/");
  }
}
