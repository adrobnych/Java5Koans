/**
 * 
 */
package com.droidbrew.javakoans.eagkoans;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Laptop{
	@BasicSpec
	@ExtendedSpec
	String CPUBrand; // think how ugly naming pattern will look here: basic_extended_spec_CPU_brand
	
	@BasicSpec
	@ExtendedSpec
	String CPUModel;
	
	@ExtendedSpec
	float weight;
	
	@Variation
	String color;
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface BasicSpec {}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface ExtendedSpec {}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Variation {}

class ProductPrinter{
	public static String printBasicSpecs(Class<?> product){
		String result = "";
		for(Field field : product.getDeclaredFields())
			if(field.isAnnotationPresent(BasicSpec.class))
				result += field.getName() + ",";
		return result;
	}
}

public class D_AboutIdiomaticNames {

	@Test
	public void a____annotation_can_add_cross_aspects_to_names() {
		assertEquals(___, ProductPrinter.printBasicSpecs(Laptop.class));
	}

}
