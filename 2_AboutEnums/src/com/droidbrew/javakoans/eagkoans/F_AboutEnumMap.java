package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

class Herb {
	public enum Type { ANNUAL, PERENNIAL, BIENNIAL }
	
	private final String name;
	private final Type type;
	
	Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public Type getType(){
		return type;
	}
	
	@Override public String toString() {
		return name;
	}
}

public class F_AboutEnumMap {

	@Test
	public void a_____using_an_EnumMap_to_associate_data_with_an_enum() {
		
		Herb[] garden = {	new Herb("brokkoli", Herb.Type.ANNUAL),
							new Herb("patato", Herb.Type.BIENNIAL), 
							new Herb("water mellon", Herb.Type.PERENNIAL)} ;

		Map<Herb.Type, Set<Herb>> herbsByType =
				new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);  // bounded type token (Item 29. Effective Java)
		
		for (Herb.Type t : Herb.Type.values())
			herbsByType.put(t, new HashSet<Herb>());
		
		for (Herb h : garden)
			herbsByType.get(h.getType()).add(h);
		
		System.out.println(herbsByType);
		
		assertEquals(___, herbsByType);
		
	}

}
