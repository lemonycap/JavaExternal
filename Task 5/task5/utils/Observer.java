package task5.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface Observer {
    public void update (JSONObject main, JSONObject wind, long visibility);
}
