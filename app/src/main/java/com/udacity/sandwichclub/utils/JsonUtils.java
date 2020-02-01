package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichObject = new JSONObject(json);

            JSONObject nameJsonObject = sandwichObject.getJSONObject("name");
            String mainName = nameJsonObject.getString("mainName");
            List<String> alsoKnownAs = Collections.singletonList(nameJsonObject.getString("alsoKnownAs"));

            String placeOfOrigin = sandwichObject.getString("placeOfOrigin");
            String description = sandwichObject.getString("description");
            String image = sandwichObject.getString("image");
            List<String> ingredients = Collections.singletonList(sandwichObject.getString("ingredients"));

            Sandwich sandwichItem = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description,
                    image, ingredients);

            sandwich = sandwichItem;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
