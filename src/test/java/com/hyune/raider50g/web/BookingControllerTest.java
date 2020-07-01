package com.hyune.raider50g.web;

import com.hyune.raider50g.util.JsonUtil;
import com.hyune.raider50g.domain.booking.RaidInfo;
import com.hyune.raider50g.domain.booking.Raider;
import com.hyune.raider50g.domain.booking.dto.BookingCommand;
import com.hyune.raider50g.common.type.ClassType;
import com.hyune.raider50g.common.type.DungeonType;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Booking : Web")
@WebMvcTest(BookingController.class)
class BookingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @DisplayName("예약하기")
  @Test
  void createBooking() throws Exception {
    // given
    DungeonType dungeonType = DungeonType.BLACKWING;
    LocalDate raidDate = LocalDate.now().plusDays(7);
    RaidInfo raidInfo = RaidInfo.of(dungeonType, raidDate);

    ClassType classType = ClassType.DRUID;
    String raiderId = "드루티어는오십골";
    Raider raider = Raider.builder()
        .classType(classType)
        .raiderId(raiderId)
        .build();

    BookingCommand bookingCommand = BookingCommand.builder()
        .raidInfo(raidInfo)
        .raider(raider)
        .build();

    String bookingCommandJson = JsonUtil.getGson().toJson(bookingCommand);

    // when
    ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/booking")
        .content(bookingCommandJson)
        .contentType(MediaType.APPLICATION_JSON_VALUE));

    // then
    result.andExpect(MockMvcResultMatchers.status().isOk());
  }
}
