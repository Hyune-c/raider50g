package com.hyune.raider50g.domain.channel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.emoji.CustomEmoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageActivity;
import org.javacord.api.entity.message.MessageAttachment;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageType;
import org.javacord.api.entity.message.Reaction;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.user.User;
import org.javacord.api.listener.ObjectAttachableListener;
import org.javacord.api.listener.message.CachedMessagePinListener;
import org.javacord.api.listener.message.CachedMessageUnpinListener;
import org.javacord.api.listener.message.MessageAttachableListener;
import org.javacord.api.listener.message.MessageDeleteListener;
import org.javacord.api.listener.message.MessageEditListener;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.javacord.api.listener.message.reaction.ReactionRemoveAllListener;
import org.javacord.api.listener.message.reaction.ReactionRemoveListener;
import org.javacord.api.util.event.ListenerManager;

@Getter
@Builder
@AllArgsConstructor
public class DiscordMessage implements Message {

  private String id;
  private String content;
  private User author;
  private LocalDateTime createdAt;

  @Override
  public Optional<Instant> getLastEditTimestamp() {
    return Optional.empty();
  }

  @Override
  public List<MessageAttachment> getAttachments() {
    return null;
  }

  @Override
  public List<CustomEmoji> getCustomEmojis() {
    return null;
  }

  @Override
  public MessageType getType() {
    return null;
  }

  @Override
  public TextChannel getChannel() {
    return null;
  }

  @Override
  public Optional<MessageActivity> getActivity() {
    return Optional.empty();
  }

  @Override
  public boolean isPinned() {
    return false;
  }

  @Override
  public boolean isTts() {
    return false;
  }

  @Override
  public boolean mentionsEveryone() {
    return false;
  }

  @Override
  public List<Embed> getEmbeds() {
    return null;
  }

  @Override
  public Optional<User> getUserAuthor() {
    return Optional.ofNullable(author);
  }

  @Override
  public MessageAuthor getAuthor() {
    return null;
  }

  @Override
  public boolean isCachedForever() {
    return false;
  }

  @Override
  public void setCachedForever(boolean cachedForever) {

  }

  @Override
  public List<Reaction> getReactions() {
    return null;
  }

  @Override
  public List<User> getMentionedUsers() {
    return null;
  }

  @Override
  public List<Role> getMentionedRoles() {
    return null;
  }

  @Override
  public CompletableFuture<Void> addReactions(String... unicodeEmojis) {
    return null;
  }

  @Override
  public CompletableFuture<Void> removeReactionByEmoji(User user, String unicodeEmoji) {
    return null;
  }

  @Override
  public CompletableFuture<Void> removeReactionByEmoji(String unicodeEmoji) {
    return null;
  }

  @Override
  public CompletableFuture<Void> removeReactionsByEmoji(User user, String... unicodeEmojis) {
    return null;
  }

  @Override
  public CompletableFuture<Void> removeReactionsByEmoji(String... unicodeEmojis) {
    return null;
  }

  @Override
  public CompletableFuture<Void> removeOwnReactionByEmoji(String unicodeEmoji) {
    return null;
  }

  @Override
  public CompletableFuture<Void> removeOwnReactionsByEmoji(String... unicodeEmojis) {
    return null;
  }

  @Override
  public int compareTo(Message o) {
    return 0;
  }

  @Override
  public DiscordApi getApi() {
    return null;
  }

  @Override
  public long getId() {
    return 0;
  }

  @Override
  public ListenerManager<ReactionRemoveAllListener> addReactionRemoveAllListener(
      ReactionRemoveAllListener listener) {
    return null;
  }

  @Override
  public List<ReactionRemoveAllListener> getReactionRemoveAllListeners() {
    return null;
  }

  @Override
  public ListenerManager<ReactionAddListener> addReactionAddListener(ReactionAddListener listener) {
    return null;
  }

  @Override
  public List<ReactionAddListener> getReactionAddListeners() {
    return null;
  }

  @Override
  public ListenerManager<ReactionRemoveListener> addReactionRemoveListener(
      ReactionRemoveListener listener) {
    return null;
  }

  @Override
  public List<ReactionRemoveListener> getReactionRemoveListeners() {
    return null;
  }

  @Override
  public ListenerManager<MessageEditListener> addMessageEditListener(MessageEditListener listener) {
    return null;
  }

  @Override
  public List<MessageEditListener> getMessageEditListeners() {
    return null;
  }

  @Override
  public ListenerManager<CachedMessageUnpinListener> addCachedMessageUnpinListener(
      CachedMessageUnpinListener listener) {
    return null;
  }

  @Override
  public List<CachedMessageUnpinListener> getCachedMessageUnpinListeners() {
    return null;
  }

  @Override
  public ListenerManager<MessageDeleteListener> addMessageDeleteListener(
      MessageDeleteListener listener) {
    return null;
  }

  @Override
  public List<MessageDeleteListener> getMessageDeleteListeners() {
    return null;
  }

  @Override
  public ListenerManager<CachedMessagePinListener> addCachedMessagePinListener(
      CachedMessagePinListener listener) {
    return null;
  }

  @Override
  public List<CachedMessagePinListener> getCachedMessagePinListeners() {
    return null;
  }

  @Override
  public <T extends MessageAttachableListener & ObjectAttachableListener> Collection<ListenerManager<T>> addMessageAttachableListener(
      T listener) {
    return null;
  }

  @Override
  public <T extends MessageAttachableListener & ObjectAttachableListener> void removeMessageAttachableListener(
      T listener) {

  }

  @Override
  public <T extends MessageAttachableListener & ObjectAttachableListener> Map<T, List<Class<T>>> getMessageAttachableListeners() {
    return null;
  }

  @Override
  public <T extends MessageAttachableListener & ObjectAttachableListener> void removeListener(
      Class<T> listenerClass, T listener) {

  }
}
