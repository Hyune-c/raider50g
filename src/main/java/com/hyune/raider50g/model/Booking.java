package com.hyune.raider50g.model;

import static com.hyune.raider50g.message.Booking.INVALID_CONTENT;

import com.hyune.raider50g.exception.CustomParseException;
import com.hyune.raider50g.model.type.BookingType;
import com.hyune.raider50g.model.type.ClassType;
import java.util.Arrays;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Booking {

  private final int VALID_PARSED_LENGTH = 3;

  private final String type;
  private final String classType;
  private final String name;

  public Booking(String content) {
    if (!isValidContent(content)) {
      throw new CustomParseException(INVALID_CONTENT);
    }
    String[] splitContent = content.replaceAll(" ", "").split(",");

    this.type = splitContent[0];
    this.classType = splitContent[1];
    this.name = splitContent[2];
  }

  private boolean isValidContent(String content) {
    String[] splitContent = content.replaceAll(" ", "").split(",");

    log.debug("### isValidContent : {}, {}, {}", splitContent.length == VALID_PARSED_LENGTH,
        isValidBookingType(splitContent[0]), isValidClassType(splitContent[1]));
    return (splitContent.length == VALID_PARSED_LENGTH)
        && isValidBookingType(splitContent[0])
        && isValidClassType(splitContent[1]);
  }

  private boolean isValidBookingType(String bookingType) {
    return Arrays.stream(BookingType.values()).anyMatch(type -> type.getType().equals(bookingType));
  }

  private boolean isValidClassType(String classType) {
    return Arrays.stream(ClassType.values()).anyMatch(type -> type.getType().contains(classType));
  }
}
