package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

class Compositor{
	// Generic method
	public static <E> Set<E> unite(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
}

public class B_AboutGenericMethods {
	@Test
	public void a_____no_casts_needed_for_generic_method(){
		Set<String> developers = new HashSet<String>(
				Arrays.asList("Tom", "Dick", "Harry"));
		Set<String> qa = new HashSet<String>(
				Arrays.asList("Larry", "Moe", "Curly"));
		Set<String> team = Compositor.unite(developers, qa);
		assertEquals(___, team);
	}
}
