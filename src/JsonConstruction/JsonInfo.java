package JsonConstruction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import static JsonConstruction.Utils.*;
import static JsonConstruction.Constants.*;


public class JsonInfo {

	static HashMap<String,Object> infoMap = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	static HashMap<String, Object> createInfoMap(ArrayList<String> paths, ArrayList<String> data) {

		Iterator<String> itPaths = paths.iterator();
		Iterator<String> itValues = data.iterator();

		while(itPaths.hasNext()) {

			// Local variables initialization
			String path = (String) itPaths.next();
			String datum = (String) itValues.next();
			List<String> tagList = (List<String>) getTagInfo(path);
			ListIterator<String> itTags = tagList.listIterator();
			int tagLength = tagList.size();
			HashSet<Tag> tagSet;
			Object value = null;
			String currTag= "";
			String key = "";
			String tag = "";
			String nextTag="";
			String tempTag="";

			while(itTags.hasNext()) {
				tag = itTags.next();
				// if it is leaf tag and is numeric then skip the loop. this is array element and handled already
				if(!(isLeafTagAndIsNumeric(itTags, tagLength))) {
					if(itTags.hasNext()) {
						// not a leaf tag. so either this tag has inner tags OR manifests as an array 
						nextTag = tagList.get(itTags.nextIndex());
						currTag = contructKey(currTag , tag);
						key = currTag;

						tempTag = getInfoMapKey(itTags , key);

						//if next element is leaf tag is numeric. Array elements 
						if(isNextItemLeafTagAndIsNumeric(itTags, tagLength , nextTag)) {
							value = updateValues(tempTag , datum);
						} else {
							//else treat is like a tag
							String tagName = key + INFOMAP_DELIMITER + nextTag;
							Tag newTag =new Tag(tagName , nextTag);
							value = updateValues(tempTag , newTag);
						}
					} else {
						key = contructKey(currTag , tag);
						value = updateValues(key , datum);
					}

					key = getInfoMapKey(itTags , key);
					infoMap.put(key,value);
				}
			}
		}

		printInfoMap();

		return infoMap;

	}
}