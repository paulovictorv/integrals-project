package expression;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import calculate.Variable;

public class IntegralParserTest {
	@Test
	public void testParserDoubleIntegral() throws InvalidIntegralException{
		IntegralParser integral = new IntegralParser("intintx^2+y^2dxdy");
		
		List<Variable> got = integral.getVariablesSorted();
		List<Variable> expected = new ArrayList<Variable>();
			expected.add(Variable.X);
			expected.add(Variable.Y);
		
		assertEquals(expected, got);
		assertEquals("x^2+y^2", integral.getIntegrand());
		
	}
	
	@Test
	public void testParserTripleIntegral() throws InvalidIntegralException{
		IntegralParser integral = new IntegralParser("intintintx^2+y^2dxdydz");
		
		List<Variable> got = integral.getVariablesSorted();
		List<Variable> expected = new ArrayList<Variable>();
			expected.add(Variable.X);
			expected.add(Variable.Y);
			expected.add(Variable.Z);
		
		assertEquals(expected, got);
		assertEquals("x^2+y^2", integral.getIntegrand());
		
	}
	
	@Test
	public void testParserDoubleIntegral2() throws InvalidIntegralException{
		IntegralParser integral = new IntegralParser("intintx^2+y^2dydx");
		
		List<Variable> got = integral.getVariablesSorted();
		List<Variable> expected = new ArrayList<Variable>();
			expected.add(Variable.Y);
			expected.add(Variable.X);
		
		assertEquals(expected, got);
		assertEquals("x^2+y^2", integral.getIntegrand());
		
	}
	
	@Test
	public void testParserTripleIntegral2() throws InvalidIntegralException{
		IntegralParser integral = new IntegralParser("intintintx^2+y^2dzdxdy");
		
		List<Variable> got = integral.getVariablesSorted();
		List<Variable> expected = new ArrayList<Variable>();
			expected.add(Variable.Z);
			expected.add(Variable.X);
			expected.add(Variable.Y);
		
		assertEquals(expected, got);
		assertEquals("x^2+y^2", integral.getIntegrand());
	}
	
	@Test
	public void testParserTripleIntegral3() throws InvalidIntegralException{
		IntegralParser integral = new IntegralParser("intintintx^2+y^2dydxdz");
		
		List<Variable> got = integral.getVariablesSorted();
		List<Variable> expected = new ArrayList<Variable>();
			expected.add(Variable.Y);
			expected.add(Variable.X);
			expected.add(Variable.Z);
		
		assertEquals(expected, got);
		assertEquals("x^2+y^2", integral.getIntegrand());
	}
	
	@Test
	public void testParserTripleIntegral4() throws InvalidIntegralException{
		IntegralParser integral = new IntegralParser("intintintx^2+y^2dzdydx");
		
		List<Variable> got = integral.getVariablesSorted();
		List<Variable> expected = new ArrayList<Variable>();
			expected.add(Variable.Z);
			expected.add(Variable.Y);
			expected.add(Variable.X);
		
		assertEquals(expected, got);
		assertEquals("x^2+y^2", integral.getIntegrand());
	}
	
	@Test(expected = InvalidIntegralException.class)
	public void testParserTripleIntegralShouldFail() throws InvalidIntegralException{
		IntegralParser integral = new IntegralParser("intintintx^2+y^2");
		
		List<Variable> got = integral.getVariablesSorted();
		List<Variable> expected = new ArrayList<Variable>();
			expected.add(Variable.Z);
			expected.add(Variable.Y);
			expected.add(Variable.X);
		
		assertEquals(expected, got);
		assertEquals("x^2+y^2", integral.getIntegrand());
	}
	
}
