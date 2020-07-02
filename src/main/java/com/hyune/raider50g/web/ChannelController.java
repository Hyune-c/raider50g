package com.hyune.raider50g.web;

import com.hyune.raider50g.common.type.Channel;
import com.hyune.raider50g.service.ChannelService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/api/channels")
@RestController
public class ChannelController {

  private final ChannelService channelService;

  @GetMapping("/{targetChannel}")
  public Mono<Object> sendBookingList(@PathVariable Channel targetChannel,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate raidDate) {
    String bookingListString = channelService.createBookingListString(targetChannel, raidDate);
    return channelService.sendBookingList(targetChannel, bookingListString);
  }
}
