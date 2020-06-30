package com.hyune.raider50g.web;

import com.hyune.raider50g.common.type.Channel;
import com.hyune.raider50g.service.ChannelService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/channel")
@RestController
public class ChannelController {

  private final ChannelService channelService;

  @GetMapping("/{channelName}")
  public void sendBookingList(@PathVariable String channelName,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate raidDate) {
    channelService.sendBookingList(Channel.valueOf(channelName), raidDate);
  }
}
