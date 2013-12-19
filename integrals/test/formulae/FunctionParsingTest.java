package formulae;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculate.FunctionParser;
import calculate.IntegrationFunction;
import expression.InvalidIntegralException;

public class FunctionParsingTest {

	@Test
	public void testParseFunctionNoVars() throws InvalidIntegralException  {
		IntegrationFunction parsedFunction = FunctionParser.parse("2");
		
		double actual = parsedFunction.evaluate(1, 4);
		double expected = 2.0;
		
		assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testParseFunctionOneVar() throws InvalidIntegralException  {
		IntegrationFunction parsedFunction = FunctionParser.parse("z");
		
		double actual = parsedFunction.evaluate(1, 4, 2);
		double expected = 2.0;
		
		assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testParseFunction() throws InvalidIntegralException  {
		IntegrationFunction parsedFunction = FunctionParser.parse("x*y-2");
		
		double actual = parsedFunction.evaluate(1, 4, 0);
		double expected = 2.0;
		
		assertEquals(expected, actual, 0.001);
	}
	

	@Test
	public void testParseFunction2() throws InvalidIntegralException  {
		IntegrationFunction parsedFunction = FunctionParser.parse("x^2 * sin(y)");
		
		double actual = parsedFunction.evaluate(1, 4, 0);
		double expected = Math.pow(1, 2) * Math.sin(4);
		
		assertEquals(expected, actual, 0.001);
	}
	
	@Test(expected = InvalidIntegralException.class)
	public void testParseFunction3() throws InvalidIntegralException {
		FunctionParser.parse("x^2 * sen(y)");
	}
	
	@Test
	public void testParseFunction3Variables() throws InvalidIntegralException {
		IntegrationFunction parse = FunctionParser.parse("x^2 + y^2 + z^2");
		
		double expected = Math.pow(2, 2) + Math.pow(2, 2) + Math.pow(2, 2);
		double actual = parse.evaluate(2, 2, 2);
		
		assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testParseFunction3Variables2() throws InvalidIntegralException {
		IntegrationFunction parse = FunctionParser.parse("x*y*z^2");
		
		double expected = 2 * 2 * Math.pow(2, 2);
		double actual = parse.evaluate(2, 2, 2);
		
		assertEquals(expected, actual, 0.001);
	}

}
