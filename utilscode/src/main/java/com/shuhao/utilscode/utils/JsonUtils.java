package com.shuhao.utilscode.utils;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by luke on 2017/9/25.
 */

public final class JsonUtils {

    //jsonToMap
    public static Map<String, String> jsonToMap(String json) {
        HashMap<String, String> jsonMap = new HashMap<String, String>();
        JSONTokener jsonTokener = new JSONTokener(json);
        try {
            JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
            Iterator iterator = jsonObject.keys();
            String key;
            String value;
            while (iterator.hasNext()) {
                key = String.valueOf(iterator.next());
                value = "" + jsonObject.get(key);
                jsonMap.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonMap;
    }

    public static List<String> jsonToList() {
        List<String> list = new ArrayList<>();
        //JSONArray jsonArray = JSONArray-
        return list;
    }
    /*public static String mapToJson(Map<String, String> map) {
        String result = new Gson().toJson(map);
        Log.e(TAG, "mapToJson: " + result);
        return result;
    }*/
    //Json格式化
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr))
            return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        boolean isInQuotationMarks = false;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '"':
                    if (last != '\\') {
                        isInQuotationMarks = !isInQuotationMarks;
                    }
                    sb.append(current);
                    break;
                case '{':
                case '[':
                    sb.append(current);
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent++;
                        addIndentBlank(sb, indent);
                    }
                    break;
                case '}':
                case ']':
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent--;
                        addIndentBlank(sb, indent);
                    }
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\' && !isInQuotationMarks) {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

}
