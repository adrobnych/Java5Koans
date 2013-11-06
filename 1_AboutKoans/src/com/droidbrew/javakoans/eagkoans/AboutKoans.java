package com.droidbrew.javakoans.eagkoans;

import static org.junit.Assert.*;
import static com.droidbrew.javakoans.eagkoans.base.Koan.*;

import org.junit.Test;

public class AboutKoans {

	@Test
	public void a_____koan_is_simple_junit_test() {
		fail("remove this line");
	}
	
	@Test
	public void b_____koan_often_includes_assertion(){
		assertTrue(false);
	}

	@Test
	public void c_____koan_can_declare_problem(){
		assertTrue("how to fix assertTrue when 2nd argument is false", false);
	}
	
	@Test 
	public void d_____koan_asks_you_about_your_expectation_and_compare_it_with_the_system_you_are_studying(){
		int my_expectation = 3;
		assertEquals("fix code before this line", my_expectation, 1+1);
	}
	
	@Test
	public void e_____koan_can_ask_for_input_in_specific_location_inside_the_code(){
		assertEquals("Replace ___ with expected value", ___, "Hello World");
	}
	
	@Test
	public void g_____expected_input_can_be_not_only_string_but_primitive(){
		assertEquals("Replace ___ with expected value", ___, 123);
	}
	
	class Animal{
		public String name;
		public void eat(){}
		@Override
		public int hashCode() {
			return 1;
		}
		@Override
		public boolean equals(Object obj) {
			if (getClass() != obj.getClass())
				return false;
			else
				return true;
		}
	}
	
	@Test
	public void h_____expected_input_can_be_not_only_string_but_object(){
		
		assertEquals("Replace ___ with expected value", ___, new Animal());
	}
	
}
