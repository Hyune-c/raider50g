package com.hyune.raider50g.booking.web;

import com.hyune.raider50g.Util.JsonUtil;
import com.hyune.raider50g.booking.data.RaidInfo;
import com.hyune.raider50g.booking.data.Raider;
import com.hyune.raider50g.booking.data.type.ClassType;
import com.hyune.raider50g.booking.data.type.DungeonType;
import com.hyune.raider50g.booking.web.model.BookingCommand;
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

@DisplayName("Booking")
@WebMvcTest(BookingController.class)
class BookingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @DisplayName("/api/booking 를 통해 기본 값이 설정된 객체가 정상적으로 생성되는지")
  @Test
  void check_Maked_BookingCommand() throws Exception {
    // given
    DungeonType dungeonType = DungeonType.BLACKWING;
    LocalDate raidDate = LocalDate.now().plusDays(7);
    RaidInfo raidInfo = RaidInfo.from(dungeonType, raidDate);

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
