package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

public class E_AboutEnumSet {
	
	// EnumSet - a modern replacement for bit fields
	static class Text {
		public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH };
		
		// Any Set could be passed in, but EnumSet is clearly best
		public static String applyStyles(Set<Style> styles) { 
			String result = "";
			for(Style s : styles)
				result += s;
			return result;
		}
	}

	@Test
	public void a_____use_enum_set_instead_of_bit_field() {
		assertEquals(___, Text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC)));
	}

}
