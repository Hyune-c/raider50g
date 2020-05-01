package com.hyune.raider50g.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hyune.raider50g.model.User;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Slf4j
public class JsonUtil {

  public static JSONArray arrayParser(String jsonString) throws ParseException {
    JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonString);

    log.debug("### arrayParser!!");

    for (int i = 0; i < jsonArray.size(); i++) {
      log.debug("### jsonObj : {}", jsonArray.get(i));
      log.debug("### jsonObj : {}", jsonArray.get(i).getClass());
      JSONObject jsonObj = (JSONObject) jsonArray.get(i);
      log.debug("### jsonObj.get(\"author\") : {}", jsonObj.get("author"));

      Gson gson = new GsonBuilder().create();
      User user = gson.fromJson(jsonObj.get("author").toString(), User.class);

      log.debug("### User : {}", user.toString());
    }

    return jsonArray;
  }
}
