import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JsonHelper {
    JSONObject json;
    String str;
    public JsonHelper(String jsonString) {
        str = jsonString;
    }
    public Object getField(String[] pathArray) {
        //Change pathArray to a list
        List<String> pathList = new ArrayList<>(Arrays.asList(pathArray));

        if (pathList.isEmpty()) throw new RuntimeException("Invalid getField path of size 0");
        try {
            JSONObject object = new JSONObject(str);
            while (pathList.size() > 1) {
                object = object.getJSONObject(pathList.get(0));
                pathList.remove(0);
            }
            return object.get(pathList.get(0));
        } catch (JSONException ex) {
            return null;
        }
    }
    private static void outKeys(JSONObject obj) {
        for (Iterator<String> it = obj.keys(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

}
