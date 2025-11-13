package com.SushiAPI.SushiAPI.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class utils {
    public static List<Object> ArrayToList(JSONArray array) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            list.add(array.get(i));
        }

        return list;
    }
    public static List<String> ArrayToStringList(JSONArray array) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            list.add(array.getString(i));
        }

        return list;
    }

    public static List<Map<String, Object>> ArrayToMapList(JSONArray array) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            list.add(obj.toMap());
        }
        return list;
    }
}
