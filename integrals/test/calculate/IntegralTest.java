package calculate;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegralTest {

	@Test
	public void testDoubleIntegral(){

		final IntegrationFunction functionToIntegrateOver = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double y = args[1];
				return 2*x + y;
			}
		};
		
		final IntegrationFunction secondIntegralUpperLimit = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				return 2*x + 2;
			}
		};

		final IntegrationFunction secondIntegralLowerLimit = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				return x;
			}
		};
		
		final VariableIntegral innerIntegral = new VariableIntegral(functionToIntegrateOver, secondIntegralUpperLimit, secondIntegralLowerLimit, Variable.Y);
		
		final DefiniteIntegral doubleIntegral = new DefiniteIntegral(innerIntegral, 2, 0, Variable.X);
		
		double result = doubleIntegral.evaluate();
		
		assertEquals(29.333333333333332, result, 0.0001);
	}
	
	@Test
	public void testTripleIntegralSimple(){
		final IntegrationFunction integrand = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double y = args[1];
				double z = args[2];
				
				return x * y * Math.pow(z, 2);
			}
		};
		
		final DefiniteIntegral innerIntegral = new DefiniteIntegral(integrand, 1, 0, Variable.X);
		final DefiniteIntegral secondIntegral = new DefiniteIntegral(innerIntegral, 2, -1, Variable.Y);
		final DefiniteIntegral thirdIntegral = new DefiniteIntegral(secondIntegral, 3, 0, Variable.Z);
		
		double result = thirdIntegral.evaluate();

		assertEquals(6.75, result, 0.0001);
	}
	
	@Test
	public void testTripleIntegralType1(){
		
		final IntegrationFunction integrand = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double z = args[2];
				return z;
			}
		};
		
		final IntegrationFunction innerIntegralUpper = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double y = args[1];
				return 1-x-y;
			}
		};
		
		final IntegrationFunction ZERO_FUNCTION = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				return 0;
			}
		};
		
		final IntegrationFunction secondIntegralUpper = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				return 1 - x;
			}
		};
		
		final VariableIntegral innerIntegral = new VariableIntegral(integrand, innerIntegralUpper, ZERO_FUNCTION, Variable.Z);
		final VariableIntegral secondIntegral = new VariableIntegral(innerIntegral, secondIntegralUpper, ZERO_FUNCTION, Variable.Y);
		final DefiniteIntegral thirdIntegral = new DefiniteIntegral(secondIntegral, 1, 0, Variable.X);

		double evaluate = thirdIntegral.evaluate();
		
		assertEquals(1d/24d, evaluate, 0.0001);
	}
	
	@Test
	public void testVolumeTripleIntegral(){
		
		final IntegrationFunction integrand = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				return 1;
			}
		};
		
		final IntegrationFunction innerIntegralUpper = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double y = args[1];
				return 2-x-2*y;
			}
		};
		
		final IntegrationFunction ZERO_FUNCTION = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				return 0;
			}
		};
		
		final IntegrationFunction secondIntegralUpper = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				return 1 - x/2;
			}
		};
		
		final IntegrationFunction secondIntegralLower = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				return x/2;
			}
		};
		
		final VariableIntegral innerIntegral = new VariableIntegral(integrand, innerIntegralUpper, ZERO_FUNCTION, Variable.Z);
		final VariableIntegral secondIntegral = new VariableIntegral(innerIntegral, secondIntegralUpper, secondIntegralLower, Variable.Y);
		final DefiniteIntegral thirdIntegral = new DefiniteIntegral(secondIntegral, 1, 0, Variable.X);
		
		double result = thirdIntegral.evaluate();
		
		assertEquals(0.3333333333333333, result, 0.0001);
	}
	
	@Test
	public void testIntegralBizonha(){
		final IntegrationFunction integrand = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double y = args[1];
				return Math.pow(x, 2) + Math.pow(y, 2);
			}
		};
		
		final IntegrationFunction innerIntegralUpper = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				return 2;
			}
		};
		
		final IntegrationFunction innerIntegralLower = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double y = args[1];
				double xySquared = Math.pow(x, 2) + Math.pow(y, 2);
				return Math.sqrt(xySquared);
			}
		};
		
		final IntegrationFunction secondIntegralUpper = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double xySquared = 4 - Math.pow(x, 2);
				return Math.sqrt(xySquared);
			}
		};
		
		final IntegrationFunction secondIntegralLower = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double xySquared = 4 - Math.pow(x, 2);
				return -Math.sqrt(xySquared);
			}
		};
		
		final VariableIntegral innerIntegral = new VariableIntegral(integrand, innerIntegralUpper, innerIntegralLower, Variable.Z);
		final VariableIntegral secondIntegral = new VariableIntegral(innerIntegral, secondIntegralUpper, secondIntegralLower, Variable.Y);
		final DefiniteIntegral thirdIntegral = new DefiniteIntegral(secondIntegral, 2, -2, Variable.X);
		
		assertEquals(10.05309649, thirdIntegral.evaluate(), 0.0001);
	}
	
	@Test
	public void testIntegralBizonha2(){
		final IntegrationFunction integrand = new IntegrationFunction() {
			@Override
			public double evaluate(double... args) {
				double x = args[0];
				double y = args[1];
				return Math.pow(x, 2) * Math.sin(y);
			}
		};
		
		final DefiniteIntegral innerIntegral = new DefiniteIntegral(integrand, 3, 0, Variable.X);
		final DefiniteIntegral secondIntegral = new DefiniteIntegral(innerIntegral, Math.PI/2, 0, Variable.Y);
		final DefiniteIntegral thirdIntegral = new DefiniteIntegral(secondIntegral, Math.PI/6, 0, Variable.Z);
		
		assertEquals(1.894021233, thirdIntegral.evaluate(), 0.001);
	}
}
