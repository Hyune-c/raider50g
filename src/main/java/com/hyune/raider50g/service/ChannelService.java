package com.hyune.raider50g.service;

import com.google.gson.Gson;
import com.hyune.raider50g.common.type.DungeonType;
import com.hyune.raider50g.domain.booking.dto.BookingList;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ChannelService {

  private final BookingService bookingService;
  private final WebClientService webClientService;

  public Mono<Object> postBookingList(DungeonType dungeonType, LocalDate raidDate) {
    BookingList bookingList = bookingService.createBookingList(dungeonType, raidDate);
    Map<String, String> payloads = new HashMap<>();
    payloads.put("content", bookingList.createBookingSheet());

    return webClientService.postMessages(dungeonType.getChannelId(), new Gson().toJson(payloads));
  }
}
