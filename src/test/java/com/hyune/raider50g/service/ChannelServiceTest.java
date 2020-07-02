package com.hyune.raider50g.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.hyune.raider50g.common.type.Channel;
import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.repository.BookingRepository;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Channel : Service")
@SpringBootTest
public class ChannelServiceTest {

  @Autowired
  private ChannelService channelService;

  @Autowired
  private BookingRepository bookingRepository;

  @DisplayName("예약 인원 리스트 만들기")
  @Test
  public void makeBookingList() {
    // given
    Channel channel = Channel.BLACKWING;
    LocalDate raidDate = LocalDate.of(2020, 7, 5);
    List<Booking> bookings = bookingRepository.findAll(raidDate);

    // when
    String bookingList = channelService.createBookingListString(channel, raidDate, bookings);

    System.out.println(bookingList);
    // then
    assertThat(bookingList)
        .startsWith("```BLACKWING")
        .contains("드루\t드루티어는오십골");
  }
}
