package com.hyune.raider50g.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {

  private final boolean bot;
  private final String id;
  private final String username;

  public User(boolean bot, String id, String username) {
    this.bot = bot;
    this.id = id;
    this.username = username;
  }
}
