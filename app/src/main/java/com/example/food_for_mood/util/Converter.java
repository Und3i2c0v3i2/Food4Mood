package com.example.food_for_mood.util;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/*
for inserting array list of ingredients in database, and getting it out
 */
public class Converter {

    static Gson gson = new Gson();

    @TypeConverter
    public static List<String> stringToIngredientList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<String>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ingredientListToString(List<String> ingredients) {
        return gson.toJson(ingredients);
    }
}
