package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class B_AboutAnnotationsForCompiler {

	@Test
	public void a_____about_suppress_warnings() {
		final Object someData = null;

		// Java uses a "stupid null"; any method call raises NPE 
		// We have to narrow suppressing to method level or deeper using "lambdas" 
		new Object(){
			@SuppressWarnings(value="null")
			void test(){
				assertEquals(___, someData.getClass().isPrimitive());
			}
		}.test();
	}
	
	@Test
	@SuppressWarnings({"null", "unused", "rawtypes", "unchecked"})
	public void b_____we_can_use_several_flags_in_suppress_warnings(){
		int x;
		Object y = null;
		y.hashCode();
		Collection<? extends Number> collection = new ArrayList();
		assertTrue("Do you catched why we need suppress 'unchecked'?", false);
	}

	class Pokemon{
		//@Override
		public String toStrinq(){
			return "Howdy I'm stuppid pokemon";
		}
	}
	
	@Test
	public void c_____override_is_secured(){
		assertEquals("Do you catched why @Override is useful?",
				"Howdy I'm stuppid pokemon", new Pokemon().toString());
	}
	
	@SuppressWarnings("rawtypes")
	static class APIModel{
		/**
		 * Does some thing in old style.
		 * @deprecated use {@link consolidateNewWay(List<? extends Number> l)} instead.  
		 */
		@Deprecated
		public static String consolidateOldWay(List l){
			return "consolidated";
		}
		public static String consolidateNewWay(List<? extends Number> l){
			return "consolidated";
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void d_____allows_painless_migrations(){
		List oldList = new ArrayList();
		oldList.add(12); oldList.add(123);
		
		List<Integer> newList = new LinkedList<>();
		newList.add(34); newList.add(1234);
		
		assertEquals("It's still working for legacy client code",
				___, APIModel.consolidateOldWay(oldList));
		assertEquals(".. and for modern client code",
				___, APIModel.consolidateNewWay(newList));
	}
	
}
