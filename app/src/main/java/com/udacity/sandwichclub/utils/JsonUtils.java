package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;




public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)  {

        List<String> alsoKnownAsl = new ArrayList<>();
        List<String> ingredientsl = new ArrayList<>();
        String main_name  ="main_name";
        String Description ="main_name";
        String PlaceOfOrigin ="main_name";
        String image ="main_name";

        try {

            JSONObject jObject = new JSONObject(json);
            JSONObject Name = jObject.getJSONObject("name");

             main_name     = Name.getString("mainName");
            Description   = jObject.getString("description");
             PlaceOfOrigin = jObject.getString("placeOfOrigin");
               image         = jObject.getString("image");


            JSONArray alsoKnownAs =Name.getJSONArray("alsoKnownAs");


                for (int i = 0; i < alsoKnownAs.length(); i++) {
                    String a = alsoKnownAs.getString(i);
                    alsoKnownAsl.add(a);

                }


            JSONArray ingredients =jObject.getJSONArray("ingredients");

                for(int i=0;i<ingredients.length();i++)
                {
                    String b = ingredients.getString(i);
                    ingredientsl.add(b);
                }



            Sandwich san=   new Sandwich(main_name,alsoKnownAsl, PlaceOfOrigin,
                    Description,image,ingredientsl);

            return san;

        }

        catch (JSONException e) {
            e.printStackTrace();
            return  null;
    }

    }
}
