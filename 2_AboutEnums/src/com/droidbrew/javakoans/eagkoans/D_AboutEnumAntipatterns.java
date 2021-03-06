package com.droidbrew.javakoans.eagkoans;

import static org.junit.Assert.*;
import static com.droidbrew.javakoans.eagkoans.base.Koan.___;

import org.junit.Test;

public class D_AboutEnumAntipatterns {

	// Abuse of ordinal to derive an associated value - DON'T DO THIS
	public enum Ensemble {
		SOLO, DUET, TRIO, QUARTET, QUINTET,
		SEXTET, SEPTET, OCTET, NONET, DECTET, DOUBLE_QUARTET;
		public int numberOfMusicians() { return ordinal() + 1; }
	}

	@Test
	public void a_____dont_rely_on_ordinal() {
		assertEquals(___, Ensemble.DOUBLE_QUARTET.numberOfMusicians());
	}

}
