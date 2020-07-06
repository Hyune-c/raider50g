package com.hyune.raider50g.domain.channel;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.DiscordClient;
import org.javacord.api.entity.Icon;
import org.javacord.api.entity.activity.Activity;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.user.UserStatus;
import org.javacord.api.listener.ObjectAttachableListener;
import org.javacord.api.listener.channel.group.GroupChannelChangeNameListener;
import org.javacord.api.listener.channel.group.GroupChannelCreateListener;
import org.javacord.api.listener.channel.group.GroupChannelDeleteListener;
import org.javacord.api.listener.channel.server.ServerChannelChangeOverwrittenPermissionsListener;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelMemberJoinListener;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelMemberLeaveListener;
import org.javacord.api.listener.channel.user.PrivateChannelCreateListener;
import org.javacord.api.listener.channel.user.PrivateChannelDeleteListener;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.javacord.api.listener.message.reaction.ReactionRemoveListener;
import org.javacord.api.listener.server.member.ServerMemberBanListener;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;
import org.javacord.api.listener.server.member.ServerMemberLeaveListener;
import org.javacord.api.listener.server.member.ServerMemberUnbanListener;
import org.javacord.api.listener.server.role.UserRoleAddListener;
import org.javacord.api.listener.server.role.UserRoleRemoveListener;
import org.javacord.api.listener.user.UserAttachableListener;
import org.javacord.api.listener.user.UserChangeActivityListener;
import org.javacord.api.listener.user.UserChangeAvatarListener;
import org.javacord.api.listener.user.UserChangeDeafenedListener;
import org.javacord.api.listener.user.UserChangeDiscriminatorListener;
import org.javacord.api.listener.user.UserChangeMutedListener;
import org.javacord.api.listener.user.UserChangeNameListener;
import org.javacord.api.listener.user.UserChangeNicknameListener;
import org.javacord.api.listener.user.UserChangeSelfDeafenedListener;
import org.javacord.api.listener.user.UserChangeSelfMutedListener;
import org.javacord.api.listener.user.UserChangeStatusListener;
import org.javacord.api.listener.user.UserStartTypingListener;
import org.javacord.api.util.event.ListenerManager;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class DiscordUser implements User {

  private String name;

  public static DiscordUser of(String name) {
    return DiscordUser.builder()
        .name(name)
        .build();
  }

  @Override
  public String getDiscriminator() {
    return null;
  }

  @Override
  public boolean isBot() {
    return false;
  }

  @Override
  public Optional<Activity> getActivity() {
    return Optional.empty();
  }

  @Override
  public UserStatus getStatus() {
    return null;
  }

  @Override
  public UserStatus getStatusOnClient(DiscordClient client) {
    return null;
  }

  @Override
  public Icon getAvatar() {
    return null;
  }

  @Override
  public boolean hasDefaultAvatar() {
    return false;
  }

  @Override
  public Optional<PrivateChannel> getPrivateChannel() {
    return Optional.empty();
  }

  @Override
  public CompletableFuture<PrivateChannel> openPrivateChannel() {
    return null;
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
  public String getName() {
    return name;
  }

  @Override
  public ListenerManager<UserChangeSelfMutedListener> addUserChangeSelfMutedListener(
      UserChangeSelfMutedListener listener) {
    return null;
  }

  @Override
  public List<UserChangeSelfMutedListener> getUserChangeSelfMutedListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeSelfDeafenedListener> addUserChangeSelfDeafenedListener(
      UserChangeSelfDeafenedListener listener) {
    return null;
  }

  @Override
  public List<UserChangeSelfDeafenedListener> getUserChangeSelfDeafenedListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeDiscriminatorListener> addUserChangeDiscriminatorListener(
      UserChangeDiscriminatorListener listener) {
    return null;
  }

  @Override
  public List<UserChangeDiscriminatorListener> getUserChangeDiscriminatorListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeActivityListener> addUserChangeActivityListener(
      UserChangeActivityListener listener) {
    return null;
  }

  @Override
  public List<UserChangeActivityListener> getUserChangeActivityListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeMutedListener> addUserChangeMutedListener(
      UserChangeMutedListener listener) {
    return null;
  }

  @Override
  public List<UserChangeMutedListener> getUserChangeMutedListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeDeafenedListener> addUserChangeDeafenedListener(
      UserChangeDeafenedListener listener) {
    return null;
  }

  @Override
  public List<UserChangeDeafenedListener> getUserChangeDeafenedListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserStartTypingListener> addUserStartTypingListener(
      UserStartTypingListener listener) {
    return null;
  }

  @Override
  public List<UserStartTypingListener> getUserStartTypingListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeNicknameListener> addUserChangeNicknameListener(
      UserChangeNicknameListener listener) {
    return null;
  }

  @Override
  public List<UserChangeNicknameListener> getUserChangeNicknameListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeAvatarListener> addUserChangeAvatarListener(
      UserChangeAvatarListener listener) {
    return null;
  }

  @Override
  public List<UserChangeAvatarListener> getUserChangeAvatarListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeStatusListener> addUserChangeStatusListener(
      UserChangeStatusListener listener) {
    return null;
  }

  @Override
  public List<UserChangeStatusListener> getUserChangeStatusListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserChangeNameListener> addUserChangeNameListener(
      UserChangeNameListener listener) {
    return null;
  }

  @Override
  public List<UserChangeNameListener> getUserChangeNameListeners() {
    return null;
  }

  @Override
  public ListenerManager<GroupChannelCreateListener> addGroupChannelCreateListener(
      GroupChannelCreateListener listener) {
    return null;
  }

  @Override
  public List<GroupChannelCreateListener> getGroupChannelCreateListeners() {
    return null;
  }

  @Override
  public ListenerManager<GroupChannelChangeNameListener> addGroupChannelChangeNameListener(
      GroupChannelChangeNameListener listener) {
    return null;
  }

  @Override
  public List<GroupChannelChangeNameListener> getGroupChannelChangeNameListeners() {
    return null;
  }

  @Override
  public ListenerManager<GroupChannelDeleteListener> addGroupChannelDeleteListener(
      GroupChannelDeleteListener listener) {
    return null;
  }

  @Override
  public List<GroupChannelDeleteListener> getGroupChannelDeleteListeners() {
    return null;
  }

  @Override
  public ListenerManager<PrivateChannelCreateListener> addPrivateChannelCreateListener(
      PrivateChannelCreateListener listener) {
    return null;
  }

  @Override
  public List<PrivateChannelCreateListener> getPrivateChannelCreateListeners() {
    return null;
  }

  @Override
  public ListenerManager<PrivateChannelDeleteListener> addPrivateChannelDeleteListener(
      PrivateChannelDeleteListener listener) {
    return null;
  }

  @Override
  public List<PrivateChannelDeleteListener> getPrivateChannelDeleteListeners() {
    return null;
  }

  @Override
  public ListenerManager<ServerChannelChangeOverwrittenPermissionsListener> addServerChannelChangeOverwrittenPermissionsListener(
      ServerChannelChangeOverwrittenPermissionsListener listener) {
    return null;
  }

  @Override
  public List<ServerChannelChangeOverwrittenPermissionsListener> getServerChannelChangeOverwrittenPermissionsListeners() {
    return null;
  }

  @Override
  public ListenerManager<ServerVoiceChannelMemberLeaveListener> addServerVoiceChannelMemberLeaveListener(
      ServerVoiceChannelMemberLeaveListener listener) {
    return null;
  }

  @Override
  public List<ServerVoiceChannelMemberLeaveListener> getServerVoiceChannelMemberLeaveListeners() {
    return null;
  }

  @Override
  public ListenerManager<ServerVoiceChannelMemberJoinListener> addServerVoiceChannelMemberJoinListener(
      ServerVoiceChannelMemberJoinListener listener) {
    return null;
  }

  @Override
  public List<ServerVoiceChannelMemberJoinListener> getServerVoiceChannelMemberJoinListeners() {
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
  public ListenerManager<MessageCreateListener> addMessageCreateListener(
      MessageCreateListener listener) {
    return null;
  }

  @Override
  public List<MessageCreateListener> getMessageCreateListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserRoleAddListener> addUserRoleAddListener(UserRoleAddListener listener) {
    return null;
  }

  @Override
  public List<UserRoleAddListener> getUserRoleAddListeners() {
    return null;
  }

  @Override
  public ListenerManager<UserRoleRemoveListener> addUserRoleRemoveListener(
      UserRoleRemoveListener listener) {
    return null;
  }

  @Override
  public List<UserRoleRemoveListener> getUserRoleRemoveListeners() {
    return null;
  }

  @Override
  public ListenerManager<ServerMemberLeaveListener> addServerMemberLeaveListener(
      ServerMemberLeaveListener listener) {
    return null;
  }

  @Override
  public List<ServerMemberLeaveListener> getServerMemberLeaveListeners() {
    return null;
  }

  @Override
  public ListenerManager<ServerMemberBanListener> addServerMemberBanListener(
      ServerMemberBanListener listener) {
    return null;
  }

  @Override
  public List<ServerMemberBanListener> getServerMemberBanListeners() {
    return null;
  }

  @Override
  public ListenerManager<ServerMemberUnbanListener> addServerMemberUnbanListener(
      ServerMemberUnbanListener listener) {
    return null;
  }

  @Override
  public List<ServerMemberUnbanListener> getServerMemberUnbanListeners() {
    return null;
  }

  @Override
  public ListenerManager<ServerMemberJoinListener> addServerMemberJoinListener(
      ServerMemberJoinListener listener) {
    return null;
  }

  @Override
  public List<ServerMemberJoinListener> getServerMemberJoinListeners() {
    return null;
  }

  @Override
  public <T extends UserAttachableListener & ObjectAttachableListener> Collection<ListenerManager<T>> addUserAttachableListener(
      T listener) {
    return null;
  }

  @Override
  public <T extends UserAttachableListener & ObjectAttachableListener> void removeUserAttachableListener(
      T listener) {

  }

  @Override
  public <T extends UserAttachableListener & ObjectAttachableListener> Map<T, List<Class<T>>> getUserAttachableListeners() {
    return null;
  }

  @Override
  public <T extends UserAttachableListener & ObjectAttachableListener> void removeListener(
      Class<T> listenerClass, T listener) {

  }
}
