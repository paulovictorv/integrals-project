package expression;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import calculate.ConstantFunction;
import calculate.DefiniteIntegral;
import calculate.FunctionParser;
import calculate.Integral;
import calculate.IntegrationFunction;
import calculate.Variable;
import calculate.VariableIntegral;

public class IntegralBuilder {

	public static Integral asIntegral(String textIntegral, String... limits) throws InvalidIntegralException {
		IntegralParser parser = new IntegralParser(textIntegral);
		
		List<Variable> variablesSorted = parser.getVariablesSorted();
		List<String> limitsList = Arrays.asList(limits);
		
		String integrandString = parser.getIntegrand();
		IntegrationFunction integrand = FunctionParser.parse(integrandString);
		
		Queue<Variable> variableQueue = new LinkedList<Variable>(variablesSorted);
		Queue<String> limitsQueue = new LinkedList<String>(limitsList);
		
		IntegralBuilder builder = new IntegralBuilder();
		
		if (variablesSorted.size() <= 3){
			Variable current = variableQueue.poll();
			String upperLimitString = limitsQueue.poll();
			String lowerLimitString = limitsQueue.poll();
			
			IntegrationFunction upperLimit = FunctionParser.parse(upperLimitString);
			IntegrationFunction lowerLimit = FunctionParser.parse(lowerLimitString);
			
			builder.addFirstIntegral(integrand, upperLimit, lowerLimit, current);
		
			while (!variableQueue.isEmpty()){
				current = variableQueue.poll();
				upperLimitString = limitsQueue.poll();
				lowerLimitString = limitsQueue.poll();
				
				upperLimit = FunctionParser.parse(upperLimitString);
				lowerLimit = FunctionParser.parse(lowerLimitString);
				builder.addIntegral(upperLimit, lowerLimit, current);
				
			}
			
			return builder.toIntegral();
		} else {
			throw new UnsupportedOperationException("Integrals with more than 3 dimensions are not supported.");
		}
		
		
	}


	private Integral currentIntegral;
	

	private void addFirstIntegral(IntegrationFunction integrand, IntegrationFunction upperLimit, IntegrationFunction lowerLimit,
			Variable var) {
		try {
			ConstantFunction upper = (ConstantFunction) upperLimit;
			ConstantFunction lower = (ConstantFunction) lowerLimit;
			currentIntegral = new DefiniteIntegral(integrand, upper.constant(), lower.constant(), var);
		} catch (ClassCastException e){
			currentIntegral = new VariableIntegral(integrand, upperLimit, lowerLimit, var);
		}
		
	}
	
	private void addIntegral(IntegrationFunction upperLimit, IntegrationFunction lowerLimit, Variable var) {
		try {
			ConstantFunction upper = (ConstantFunction) upperLimit;
			ConstantFunction lower = (ConstantFunction) lowerLimit;
			currentIntegral = new DefiniteIntegral(currentIntegral, upper.constant(), lower.constant(), var);
		} catch (ClassCastException e){
			currentIntegral = new VariableIntegral(currentIntegral, upperLimit, lowerLimit, var);
		}
	}
	
	private Integral toIntegral() {
		return currentIntegral;
	}
	

}
