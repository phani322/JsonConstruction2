package JsonConstruction;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

import static JsonConstruction.JsonInfo.*;
import static JsonConstruction.JsonBuilder.*;

public class Main {
	
	public static void main(String[] args) throws JSONException {
		
		ArrayList<String>  paths = new ArrayList<String>();
		ArrayList<String>  data = new ArrayList<String>();

		paths.add("level_1/level_2/Level_3/level_4/5/Level_6;/level_7/8/9/0");
		data.add("data_10_1");

		paths.add("level_1/level_2/Level_3/level_4/5/Level_6;/level_7/8/9/1");
		data.add("data_10_2");

		paths.add("level_1/level_2/Level_3/level_4/5/Level_6_2;/level_7/8/9/1");
		data.add("data_10_2_2");
		
		paths.add("level_1/level_2/Level_3/level_4/6/Level_6_2;/level_7/8/9/1");
		data.add("data_10_2_2");
		
		paths.add("level_1/level_2/Level_3_1/level_4/6/Level_6_2;/level_7/8/9/1");
		data.add("data_10_2_2");
		
		
		paths.add("CCID");
		data.add("241");

		paths.add("CHANNEL_NAME");
		data.add("TVOne");

		paths.add("SOURCE/0/TYPE/1");
		data.add("TypeX_1");
		
		paths.add("SOURCE/0/TYPE/2");
		data.add("TypeX_2");

		paths.add("PROCESSING/TYPE");
		data.add("TypeY");
		
		paths.add("GROUPS/1");
		data.add("Nature");

		paths.add("GROUPS/2");
		data.add("HD");

		// ------------
		
		paths.add("Processing/ingress/primary/ingress_cl_name");
		data.add("MSSN17p");

		paths.add("Processing/ingress/primary/ingress_cl_source");
		data.add("MSSN");

		paths.add("Processing/ingress/primary/multicast_source_ip");
		data.add("10.10.10.10");

		paths.add("Processing/ingress/primary/multicast_group_ip");
		data.add("239.10.10.10");

		paths.add("Processing/ingress/primary/multicast_port");
		data.add("2000");
		
		
		// ------------
		
		paths.add("Processing/ingress/backup/ingress_cl_name");
		data.add("MSSN17p");

		paths.add("Processing/ingress/backup/ingress_cl_source");
		data.add("MSSN");

		paths.add("Processing/ingress/backup/multicast_source_ip");
		data.add("10.10.10.10");

		paths.add("Processing/ingress/backup/multicast_group_ip");
		data.add("239.10.10.10");

		paths.add("Processing/ingress/backup/multicast_port");
		data.add("2000");
		

		// ------------
		
		paths.add("Processing/tv/backup/ingress_cl_name");
		data.add("MSSN17p");

		paths.add("Processing/tv/backup/ingress_cl_source");
		data.add("MSSN");

		paths.add("Processing/tv/backup/multicast_source_ip");
		data.add("10.10.10.10");

		paths.add("Processing/tv/backup/multicast_group_ip");
		data.add("239.10.10.10");

		paths.add("Processing/tv/backup/multicast_port");
		data.add("2000");

		
		HashMap<String,Object> infoMap = createInfoMap(paths, data);

		JSONObject json = buildJson(infoMap);
		
		System.out.println("\n\nFINAL JSON : "  + json.toString(2) );

	}
}