package com.cybertech.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class JsonObjectUtil {

	public static JSONObject getJSONObject(List list,long count){
		
		String dataStr = JSONArray.fromObject(list).toString();
		String backStr = "{\"code\":0,\"count\":"+count+",data:"+dataStr+",\"msg\":\"\"}";
		JSONObject obj = JSONObject.fromObject(backStr);
		return obj;
	}
}
