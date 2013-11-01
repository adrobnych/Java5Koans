package com.droidbrew.javakoans.eagkoans;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.Test;

@Retention(RetentionPolicy.RUNTIME)
@interface MarkerAnnotation{}

@MarkerAnnotation
@SuppressWarnings("serial")
class SomeClass implements Serializable{
}

public class E_AboutAnnotationIsNotAnInterface {

	@Test
	@SuppressWarnings("unused")
	public void a_____marker_annotation_and_marker_nteface_are_not_the_same() {
		// MarkerAnnotation baseRef1 = new SomeClass();
		Serializable baseRef2 = new SomeClass();
		assertTrue("Now I see that annotation and marker interface are not the same", false);
	}

}
