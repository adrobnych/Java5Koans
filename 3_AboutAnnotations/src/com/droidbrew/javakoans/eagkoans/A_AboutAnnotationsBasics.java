package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.Test;


@A_AboutAnnotationsBasics.RedMagnet
public class A_AboutAnnotationsBasics {

	@Retention(RetentionPolicy.RUNTIME) // what happen on removing the line
	@interface RedMagnet{
	}
	
	@RedMagnet
	Object someData;
	
	@RedMagnet
	@Test
	@SuppressWarnings("unused")
	public void a_____in_the_very_basics_annotation_is_just_a_metadata_marker() {
		@RedMagnet Object otherData;
		assertEquals(___, RedMagnet.class.getSimpleName());
		assertEquals(___, this.getClass().getAnnotations().length);
	}

}
