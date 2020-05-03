package com.hyune.raider50g.service;

import static com.hyune.raider50g.message.Booking.INVALID_AUTHOR;

import com.hyune.raider50g.Util.JsonUtil;
import com.hyune.raider50g.config.ConfigureDiscordApi;
import com.hyune.raider50g.exception.FailedBookingException;
import com.hyune.raider50g.model.Booking;
import com.hyune.raider50g.model.Message;
import com.hyune.raider50g.property.ApiURL;
import com.hyune.raider50g.property.Channel;
import com.hyune.raider50g.property.Token;
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
    headers.add("Authorization", "Bot " + Token.getBotToken());

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromHttpUrl(ApiURL.DISCORD_API)
        .path("/channels/" + Channel.BLACKWING + "/messages");
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
    headers.add("Authorization", "Bot " + Token.getBotToken());

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromHttpUrl(ApiURL.DISCORD_API)
        .path("/channels/" + Channel.BLACKWING + "/messages/" + messageId);
    URI uri = uriComponentsBuilder.build(false).toUri();

    ResponseEntity<String> response = new RestTemplate().exchange(
        uri, HttpMethod.GET, new HttpEntity<String>(headers), String.class);

    return JsonUtil.objectToMessage(response.getBody());
  }

  public Booking booking(Message message) {
    if (message.getAuthor().isBot()) {
      throw new FailedBookingException(INVALID_AUTHOR);
    }

    return new Booking(message.getContent());
  }

  public Message sendMessage(String channelId, Message message) {
    if (message.getAuthor().isBot()) {
      throw new FailedBookingException(INVALID_AUTHOR);
    }

    return null;
  }
}
