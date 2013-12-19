package calculate;

import java.util.ArrayList;
import java.util.List;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import expression.InvalidIntegralException;

public class FunctionParser {

	private static List<String> variablesNames;
	
	public static IntegrationFunction parse(String string) throws InvalidIntegralException {
		variablesNames = new ArrayList<String>();
		countVariables(string);
		try {
			if (variablesNames.size() == 0){
				return new ConstantFunction(Double.parseDouble(string));
			}

			ExpressionBuilder builder = new ExpressionBuilder(string);
			
			builder.withVariableNames("x", "y", "z");
			
			final Calculable calc = builder.build();
			
			IntegrationFunction function = new IntegrationFunction() {
				@Override
				public double evaluate(double... args) {
					if (args.length == 1){
						return calc.calculate(args[0], 0, 0);
					} else if (args.length == 2){
						return calc.calculate(args[0], args[1], 0);
					} else {
						return calc.calculate(args);
					}
				}
			};
			
			return function;
		} catch (UnknownFunctionException e) {
			throw new InvalidIntegralException(e);
		} catch (UnparsableExpressionException e) {
			throw new InvalidIntegralException(e);
		}
		
	}

	private static void countVariables(String string) {
		if (string.contains("x")){
			variablesNames.add("x");
		} 
		
		if (string.contains("y")){
			variablesNames.add("y");
		}
		
		if (string.contains("z")){
			variablesNames.add("z");
		}
	}

}
