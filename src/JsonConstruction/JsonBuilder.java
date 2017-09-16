package JsonConstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import static JsonConstruction.Constants.*;

public class JsonBuilder {

	static JSONObject json = new JSONObject();
	static HashMap<String, Object> infoMap;

	static JSONObject buildJson(HashMap<String,Object> map) throws JSONException {

		infoMap = map;

		for (String name: infoMap.keySet()){

			String key =name.toString();

			if(key.contains(ROOT_TAG)) {

				Object obj =createJson(key);
				key = key.replace(ROOT_TAG, "");

				if (obj instanceof ArrayList) {
					ArrayList<String> values = (ArrayList<String>) obj;

					if(values.size() == 1) {
						json.put(key, values.get(0));
					} else {
						json.put(key, values);
					}
				} else {

					JSONObject partJson = (JSONObject) obj;
					json.put(key, partJson);	
				}

			}
		}

		return json;
	}

	static Object createJson(String tag) throws JSONException {

		JSONObject partJson = new JSONObject();

		Object value =  infoMap.get(tag);

		if (value instanceof  ArrayList) {
			return (ArrayList<String>) value;
		} else {

			HashSet<Tag>  tagSet = (HashSet<Tag>)value;

			Iterator<Tag> itSet = tagSet.iterator();

			while(itSet.hasNext()) {

				Tag tag2 = (Tag) itSet.next();

				String key = tag2.getName();
				String keyFull = tag2.getFullName();

				Object obj = createJson(keyFull);
				
				if (obj instanceof ArrayList) {
					ArrayList<String> values = (ArrayList<String>) obj;

					if(values.size() == 1) {
						partJson.put(key, values.get(0));
					} else {
						partJson.put(key, values);
					}
				} else {

					JSONObject partJson2 = (JSONObject) obj;
					partJson.put(key, partJson2);	
				}
			}

			return partJson;
		}
	}
}