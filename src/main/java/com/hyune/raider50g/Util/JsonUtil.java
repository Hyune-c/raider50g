package com.hyune.raider50g.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hyune.raider50g.model.Message;
import com.hyune.raider50g.model.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Slf4j
public class JsonUtil {

  private static final Gson gson;

  static {
    gson = new GsonBuilder().create();
  }

  // Dev Util
  public static JSONArray arrayParser(String jsonString) throws ParseException {
    JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonString);

    log.debug("### arrayParser!!");

    for (int i = 0; i < jsonArray.size(); i++) {
      log.debug("### jsonObj : {}", jsonArray.get(i));
      log.debug("### jsonObj : {}", jsonArray.get(i).getClass());
      JSONObject jsonObj = (JSONObject) jsonArray.get(i);
      log.debug("### jsonObj.get(\"author\") : {}", jsonObj.get("author"));

      User user = gson.fromJson(jsonObj.get("author").toString(), User.class);
      log.debug("### User : {}", user.toString());

      Message message = gson.fromJson(jsonObj.toString(), Message.class);
      log.debug("### message : {}", message.toString());
    }

    return jsonArray;
  }

  public static List<Message> arrayToMessage(String jsonString) throws ParseException {
    JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonString);
    return (List<Message>) jsonArray.stream()
        .map(obj -> objectToMessage(obj.toString()))
        .collect(Collectors.toList());
  }

  public static Message objectToMessage(String jsonString) {
    return gson.fromJson(jsonString, Message.class);
  }
}
