package com.tca;

import java.util.HashMap;
import java.util.Map;

public class Demo {

	public static void main(String[] args) 
	{
		Map<String,Integer> map = new HashMap<>();
	    map.put("aaa",1);
	    map.put("bbb",2);
	    map.put("ccc",3);
	    map.put("ddd",0);
	    
	    System.out.println(map);
	    
	    map.remove("ddd", 0);
	    System.out.println(map);
		
	}
	

}
