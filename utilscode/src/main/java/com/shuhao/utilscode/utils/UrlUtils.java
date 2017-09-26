package com.shuhao.utilscode.utils;

import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luke on 2017/9/25.
 */

public class UrlUtils {

    public static Map<String, String> urlToMap(String url) {
        Map<String, String> paramsMap = new HashMap<>();
        List<String> paramsList = Arrays.asList(url.split("[?]")[1].split("[&]"));
        for (String param : paramsList) {
            String[] params = param.split("[=]");
            paramsMap.put(params[0], params[1]);
            Log.e("key", params[0]);
            Log.e("value", params[1]);
        }
        return paramsMap;
    }
}
