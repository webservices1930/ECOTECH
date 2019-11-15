package com.javeriana.ecotech.controller;

import com.google.gson.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.reflect.Type;

@Controller
@CrossOrigin(origins = { "*" })
public class GsonController {

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .registerTypeAdapter(ObjectId.class, new JsonSerializer<ObjectId>() {
                @Override
                public JsonElement serialize(ObjectId src, Type typeOfSrc, JsonSerializationContext context) {

                    System.out.println(src);
                    JsonObject ret = new JsonObject();
                    ret.addProperty("$oid", src.toHexString());
                    return ret;
                }
            })
            .registerTypeAdapter(ObjectId.class, new JsonDeserializer<ObjectId>() {
                @Override
                public ObjectId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    if( !json.isJsonObject() )
                        return new ObjectId(json.getAsString());
                    return new ObjectId(json.getAsJsonObject().get("$oid").getAsString());
                }
            }).create();

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
