package top.zero3737.util;

import java.util.UUID;

public class GetUUID {
	
	public String get() {
		
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
		
	}

}
