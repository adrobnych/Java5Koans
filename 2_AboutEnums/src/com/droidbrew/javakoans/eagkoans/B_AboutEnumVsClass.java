package com.droidbrew.javakoans.eagkoans;

import static org.junit.Assert.*;
import static com.droidbrew.javakoans.eagkoans.base.Koan.*;

import org.junit.Test;

// Why I should define this class outside AboutIdiomaticEnums?
// Try to define it as an inner class, play a little with test "a".
final class EnumModel{

	public static final EnumModel White = new EnumModel("#FFFFFF");
	public static final EnumModel Black = new EnumModel("#000000");
	
	// What is the name of OOD pattern built on top of private constructor?
	private EnumModel(String _stringColorRepresentation) {
		stringColorRepresentation = _stringColorRepresentation;
	}
	
	private String stringColorRepresentation;
	
	public String toString(){
		return stringColorRepresentation;
	}
	
}

public class B_AboutEnumVsClass {
	
	
	@Test
	public void a_____internaly_Enums_use_public_static_final_fields_and_private_constructor() {
		// uncomment and fix the next line. Why it was commented?
		// assertEquals("#FFFFFF", (new EnumModel("#FFFFFF")).toString());
		assertEquals(___, EnumModel.White.toString());
		assertEquals(___, EnumModel.Black.toString());
		// why EnumModel is simplified model of Enum?
	}
	
	enum BestDetectivesEver{
		SherlockHolms, DoctorVatson
	}
	
	@Test
	public void b_____you_can_use_enum_as_effective_singleton_or_pool(){
		// Fix the test not touching assertion line
		// BestDetectivesEver MissisHatson = new BestDetectivesEver();
		// assertEquals(BestDetectivesEver.MissisHatson, BestDetectivesEver.values()[2]);
	}
	
	@Test
	public void c_____enum_is_similar_to_class(){
		assertEquals(___, BestDetectivesEver.class.getSimpleName());
		assertEquals(___, BestDetectivesEver.class.getSuperclass());
		assertEquals(___, BestDetectivesEver.class.getSuperclass().getSuperclass());
	}
	
	@Test
	public void d_____but_enum_is_not_a_Class_this_is_language_enhancement_rather(){
		// uncoment and investigate
		// class ImpossibleThing extends BestDetectivesEver{}
		// enum ImpossibleThing2 extends BestDetectivesEver{} 
	}
	
	@Test 
	public void e_____how_to_get_original_string_representation(){
		assertEquals(___, BestDetectivesEver.SherlockHolms.name());
	}

}
