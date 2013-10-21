package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AboutIdiomaticUseEnumsInsteadOfIntConstants {

	// Self-overriding: Enum type with constant-specific method implementations
	enum Operation {
		PLUS { double apply(double x, double y){return x + y;} },
		MINUS { double apply(double x, double y){return x - y;} },
		TIMES { double apply(double x, double y){return x * y;} },
		DIVIDE { double apply(double x, double y){return x / y;} };
		
		abstract double apply(double x, double y);
	}
	
	@Test
	public void a_____self_overriding() {
		assertEquals(___, Operation.PLUS.apply(2, 3));
		assertEquals(___, Operation.TIMES.apply(2, 3));
	}
	
	// Self-overriding: Enum type with constant-specific class bodies and data
	enum ExtendedOperation {
		PLUS("+") {
			double apply(double x, double y) { return x + y; }
		},
		MINUS("-") {
			double apply(double x, double y) { return x - y; }
		},
		TIMES("*") {
			double apply(double x, double y) { return x * y; }
		},
		DIVIDE("/") {
			double apply(double x, double y) { return x / y; }
		};
		
		private final String symbol;
		
		ExtendedOperation(String symbol) { this.symbol = symbol; }
		
		@Override public String toString() { return symbol; }
		
		abstract double apply(double x, double y);
	}
	
	@Test
	public void b_____custom_behavior_and_data() {
		double x = 2;
		double y = 4;
		String result = "";
		for (ExtendedOperation op : ExtendedOperation.values())
			result += String.format("%f %s %f = %f%n",
					x, op, y, op.apply(x, y));
		assertEquals("resulting string is: \n" + result, ___, result.length());
	}
	
	@Test
	public void c_____Enum_types_have_an_automatically_generated_valueOf_String_method() {
		Operation op = Operation.valueOf("PLUS");
		assertEquals(___, op);
	}
	
	enum AvtoPromBrand{
		ZAZ('z'), VAZ('v'), GAZ('g'), PAZ('p'), LAZ('l');
		
		private final char firstLetter;
		
		AvtoPromBrand(char fl){
			firstLetter = fl;
		}
		
		// custom toString
		@Override
		public String toString(){
			return "" + firstLetter + "az das auto!";
		}
		
		// so you need to implement a custom fromString method on an enum type also
		private static final Map<String, AvtoPromBrand> stringToEnum
			= new HashMap<String, AvtoPromBrand>();
		
		static { 
			// Initialize map from constant name to enum constant
			for (AvtoPromBrand brand : values())
				stringToEnum.put(brand.toString(), brand);
		}
		
		// Returns Operation for string, or null if string is invalid
		public static AvtoPromBrand fromString(String symbol) {
			return stringToEnum.get(symbol);
		}
	}

	@Test
	public void d_____custom_fromString() {
		assertEquals(___, AvtoPromBrand.VAZ);
		assertEquals(___, AvtoPromBrand.valueOf("vaz das auto!"));
		assertEquals(___, AvtoPromBrand.fromString("vaz das auto!"));
	}
}
