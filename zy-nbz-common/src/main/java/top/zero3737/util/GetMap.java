package top.zero3737.util;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class GetMap {
	
	public Map<String, String> getSuccess(String msg) {
		
		Map<String, String> map = new HashedMap();
		
		map.put("code", "1");
		map.put("msg", msg);
		
		return map;
		
	}
	
	public Map<String, String> getFail(String msg) {
		
		Map<String, String> map = new HashedMap();
		
		map.put("code", "0");
		map.put("msg", msg);
		
		return map;
		
	}

}
