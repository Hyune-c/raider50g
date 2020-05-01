package com.hyune.raider50g.service;

import com.hyune.raider50g.Util.JsonUtil;
import com.hyune.raider50g.config.ConfigureDiscordApi;
import com.hyune.raider50g.model.Message;
import com.hyune.raider50g.property.Mock;
import java.net.URI;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class DiscordService {

  private final DiscordApi discordApi;

  public DiscordService() {
    this.discordApi = ConfigureDiscordApi.getDiscordApi();
  }

  public List<Message> getChannelMessages(String after) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bot " + Mock.getBotToken());

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromHttpUrl(Mock.DISCORD_API_URL)
        .path("/channels/" + Mock.CHANNEL_BLACKWING + "/messages");
    if (!ObjectUtils.isEmpty(after)) {
      uriComponentsBuilder.queryParam("after", after);
    }
    URI uri = uriComponentsBuilder.build(false).toUri();

    try {
      ResponseEntity<String> response = new RestTemplate().exchange(
          uri, HttpMethod.GET, new HttpEntity<String>(headers), String.class);
      return JsonUtil.arrayToMessage(response.getBody());
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Message getChannelMessage(String messageId) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bot " + Mock.getBotToken());

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromHttpUrl(Mock.DISCORD_API_URL)
        .path("/channels/" + Mock.CHANNEL_BLACKWING + "/messages/" + messageId);
    URI uri = uriComponentsBuilder.build(false).toUri();

    ResponseEntity<String> response = new RestTemplate().exchange(
        uri, HttpMethod.GET, new HttpEntity<String>(headers), String.class);

    return JsonUtil.objectToMessage(response.getBody());
  }

  public String booking(String messageId) {

    return null;
  }
}
