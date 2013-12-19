package expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculate.Integral;

public class IntegralBuilderTest {

	@Test
	public void testIntegralBuilder1() throws InvalidIntegralException{
		Integral integral = IntegralBuilder.asIntegral("intint2*x+ydydx", "2*x+2", "x", "2", "0");
		double result = integral.evaluate();
		assertEquals(29.33333333333334, result, 0.0001);
	}
	
	@Test
	public void testIntegralBuilder2() throws InvalidIntegralException {
		Integral integral = IntegralBuilder.asIntegral("intintintx*y*z^2dxdydz", "1", "0", "2", "-1", "3", "0");
		double result = integral.evaluate();
		assertEquals(6.75, result, 0.0001);
	}
	
	@Test
	public void testIntegralBuilderType1() throws InvalidIntegralException {
		Integral integral = IntegralBuilder.asIntegral("intintintzdzdydx", "1-x-y", "0", "1-x", "0", "1", "0");
		double result = integral.evaluate();
		assertEquals(1d/24d, result, 0.0001);
	}
	
	@Test
	public void testIntegralBuilderVolume() throws InvalidIntegralException {
		Integral integral = IntegralBuilder.asIntegral("intintint1dzdydx", "2-x-2*y", "0", "1-x/2", "x/2", "1", "0");
		double result = integral.evaluate();
		assertEquals(0.3333333333333333, result, 0.0001);
	}
	
	@Test
	public void testIntegralBuilderBizonha() throws InvalidIntegralException {
		Integral integral = IntegralBuilder.asIntegral("intintint1dzdydx", "2-x-2*y", "0", "1-x/2", "x/2", "1", "0");
		double result = integral.evaluate();
		assertEquals(0.3333333333333333, result, 0.0001);
	}
	
	@Test
	public void testIntegralBuilderBizonha2() throws InvalidIntegralException {
		Integral integral = IntegralBuilder.asIntegral("intintintx^2+y^2dzdydx", "2", "sqrt(x^2+y^2)", "sqrt(4-x^2)", "-sqrt(4-x^2)", "2", "-2");
		double result = integral.evaluate();
		assertEquals(10.05309649, result, 0.0001);
	}

	
}
