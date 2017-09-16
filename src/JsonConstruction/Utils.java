package JsonConstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang3.StringUtils;
import static JsonConstruction.JsonInfo.*;
import static JsonConstruction.Constants.*;

public class Utils {

	public static String contructKey(String currTag, String tag) {
		String key = (currTag == "") ? tag :  currTag + INFOMAP_DELIMITER + tag;
		return key;
	}

	public static String getInfoMapKey(ListIterator<String> itTags, String key) {
		return isRootKey(itTags) ? ROOT_TAG + key : key;		
	}

	public static List<String> getTagInfo(String path) {
	
		return (List<String>) Arrays.asList(path.split(CSV_DELIMITER));
	
	}

	public static boolean isLeafTagAndIsNumeric(ListIterator<String> itTags, int tagLength) {
	
		if(((itTags.nextIndex()) == tagLength) && (StringUtils.isNumeric(itTags.toString()))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNextItemLeafTagAndIsNumeric(ListIterator<String> itTags, int tagLength , String nextTag) {
		if(((itTags.nextIndex()+1) == tagLength) && (StringUtils.isNumeric(nextTag))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isRootKey(ListIterator<String> itTags) {
		return (itTags.previousIndex() == 0);
	}

	public static void printInfoMap() {
	
		System.out.println("\n------ INFO MAP START --------------------------\n");
	
		for (String name: infoMap.keySet()){
	
			String key =name.toString();
			String value = infoMap.get(name).toString();  
			System.out.println(key + " --> " + value);  
		}
	
		System.out.println("\n------ INFO MAP END -----------------------------\n");
	}

	@SuppressWarnings("unchecked")
	public static Object updateValues(String tempTag , Object obj) {
	
		@SuppressWarnings("rawtypes")
		Collection values= null;
	
		if(obj instanceof Tag) {
			values = (infoMap.containsKey(tempTag)) ? (HashSet<Tag>)infoMap.get(tempTag): new HashSet<Tag>();
		} else {
			values = (infoMap.containsKey(tempTag)) ? (ArrayList<String>)infoMap.get(tempTag): new ArrayList<String>();
		}
	
		values.add(obj);
	
		return values;
	
	}
}