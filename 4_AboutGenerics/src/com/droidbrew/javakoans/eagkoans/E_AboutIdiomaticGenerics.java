package com.droidbrew.javakoans.eagkoans;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.droidbrew.javakoans.eagkoans.base.Koan.*;

public class E_AboutIdiomaticGenerics {
	
	// Fake Implementation of old library
	class ServletRequest{
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Map getParameterMap() {
			Map data = new HashMap();
			data.put("car_brands", new String[]{"audi", "volvo"});
			return data;
		}
		
	}
	
	static class NoWarn {
		public static Map<String, String[]> getParameterMap(ServletRequest r) 
		{
			// look how to get minimal code affection by @SuppressWarnings on declaration command
			@SuppressWarnings("unchecked") Map<String, String[]> result = r.getParameterMap();
			return result;
		}
	}
	
	@Test
	public void a_____prefer_generics_in_new_code_and_reduce_suppressing(){
		assertEquals(___, NoWarn.getParameterMap(new ServletRequest()).get("car_brands")[0]);
	}
}
