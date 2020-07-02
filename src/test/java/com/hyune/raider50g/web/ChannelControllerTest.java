package com.hyune.raider50g.web;

import com.hyune.raider50g.common.type.Channel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChannelControllerTest {

  @LocalServerPort
  private int port;

  private WebTestClient webTestClient;

  @Before
  public void setUp() {
    String baseUrl = String.format("http://localhost:%d/api", port);
    webTestClient = WebTestClient.bindToServer().baseUrl(baseUrl)
        .build();
  }

  @DisplayName("예약 리스트 보내기")
  @Test
  public void sendBookingList() {
    System.out.println("asdf");
    // given
    Channel channel = Channel.TEST;
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
        .pathSegment("channels", channel.getKey())
        .queryParam("raidDate", "2020-07-05");

    // when
    ResponseSpec responseSpec = webTestClient.get()
        .uri(uriComponentsBuilder.toUriString())
        .accept(MediaType.APPLICATION_JSON)
        .exchange();

    // then
    responseSpec.expectStatus().isOk();
    responseSpec.expectHeader().contentType(MediaType.APPLICATION_JSON);
    responseSpec.expectBody()
        .jsonPath("$.content").isNotEmpty()
        .jsonPath("$.author.username").isEqualTo("50G BOT");
  }
}
