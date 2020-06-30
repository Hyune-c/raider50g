package com.hyune.raider50g.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDate;

public class JsonUtil {

  private static final Gson gson;

  static {
    gson = new GsonBuilder()
        .registerTypeAdapter(LocalDate.class, new TypeAdapter<LocalDate>() {
          @Override
          public void write(final JsonWriter jsonWriter, final LocalDate localDate)
              throws IOException {
            jsonWriter.value(localDate.toString());
          }

          @Override
          public LocalDate read(final JsonReader jsonReader) throws IOException {
            return LocalDate.parse(jsonReader.nextString());
          }
        }.nullSafe()).create();
  }

  public static Gson getGson() {
    return gson;
  }
}
