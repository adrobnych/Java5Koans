package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

// Meditate: why enums can't be extended?

// Solution is implementation

// Emulated extensible enum using an interface
interface Operation {
	double apply(double x, double y);
}

enum BasicOperation implements Operation {
	PLUS("+") {
		public double apply(double x, double y) { return x + y; }
	},
	MINUS("-") {
		public double apply(double x, double y) { return x - y; }
	},
	TIMES("*") {
		public double apply(double x, double y) { return x * y; }
	},
	DIVIDE("/") {
		public double apply(double x, double y) { return x / y; }
	};

	private final String symbol;
	
	BasicOperation(String symbol) {
		this.symbol = symbol;
	}
	
	@Override public String toString() {
		return symbol;
	}
}

//Emulated extension enum
enum ExtendedOperation implements Operation {
	EXP("^") {
		public double apply(double x, double y) {
			return Math.pow(x, y);
		}
	},
	REMAINDER("%") {
		public double apply(double x, double y) {
			return x % y;
		}
	};
	
	private final String symbol;
	ExtendedOperation(String symbol) {
		this.symbol = symbol;
	}
	@Override public String toString() {
		return symbol;
	}
}

public class G_AboutExtendableEnum {

	@Test
	public void a_____extending_enum_using_interface() {
		
		double x = 2;
		double y = 3;
		Collection<Operation> opSet = new ArrayList<Operation>();
		opSet.addAll(Arrays.asList(ExtendedOperation.values()));
		opSet.addAll(Arrays.asList(BasicOperation.values()));
		
		assertEquals("actual output was:\n" + printAllOps(opSet, x, y), ___, printAllOps(opSet, x, y).length());
		
	}

	private String printAllOps(Collection<Operation> opSet, double x, double y) {
		String result = "";
		for (Operation op : opSet)
			result += String.format("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		return result;
	}

}
