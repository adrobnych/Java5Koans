package com.droidbrew.javakoans.eagkoans;

import java.lang.annotation.*;
import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

interface Engine{
	public String start();
}

class GasEngine implements Engine{
	@Override
	public String start() {
		return "sound of engine";
	}
	
	public GasEngine(){
	}
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Auto {
	int numberOfWheels() default 4;
	String slangName() default "Can";
	String[] visualPartsNames() default {"hood", "cabin", "trunk"};
	Class<? extends Engine> engine() default Engine.class;
}

class Car{
	int numberOfWheels;
	Engine engine;

	public Car() {
		Auto autoAnnotation = this.getClass().getAnnotation(Auto.class);
		if(autoAnnotation != null){
			this.numberOfWheels = autoAnnotation.numberOfWheels();
			if(autoAnnotation.engine() != Engine.class)
				try {
					this.engine = autoAnnotation.engine().newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
		}
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	
	public String letsRock(){
		return engine.start();
	}
	
}

public class C_AboutCustomAnnotations {
	
	@Auto               // try to remove this annotation and explain what was happen
	class Vaz2101 extends Car{
	}

	@Test
	public void a_____annotation_can_be_applied_by_reflection() {
		Vaz2101 krasniyZhigul = new Vaz2101();
		assertEquals(___, krasniyZhigul.getNumberOfWheels());
	}
	
	@Auto(numberOfWheels = 8)           
	class BTR extends Car{
	}

	@Test
	public void b_____annotation_can_get_parameters() {
		BTR btr16 = new BTR();
		assertEquals(___, btr16.getNumberOfWheels());
	}
	
	@Auto                  // how about parameter engine = GasEngine.class ?       
	class HotRoad extends Car{
	}
	
	@Test
	public void c_____annotation_can_inject_dependencies() {
		HotRoad viper = new HotRoad();
		assertEquals("sound of engine", viper.letsRock());
	}
	
	// Mediate on question: we just injected a class actually. How to inject an object

}
