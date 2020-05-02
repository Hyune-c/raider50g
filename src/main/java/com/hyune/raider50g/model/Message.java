package com.hyune.raider50g.model;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@Slf4j
public class Message {

  private final String id;
  private final String content;
  private final Date timestamp;
  private final User author;

  private final int VALID_PARSED_LENGTH = 3;

  public Message(String id, User user, String content, Date timestamp) {
    this.id = id;
    this.author = user;
    this.content = content;
    this.timestamp = timestamp;
  }

  public boolean isBookingMessage() {
    if (author.isBot() || !isParsedContent()) {
      log.debug("### author.isBot() : {}", author.isBot());
      log.debug("### !isParsed() : {}", !isParsedContent());
      return false;
    }

    return true;
  }

  private boolean isParsedContent() {
    String[] splitContent = content.replaceAll(" ", "").split(",");
    log.debug("### splitContent : {}", (Object) splitContent);
    return splitContent.length == VALID_PARSED_LENGTH;
  }
}
