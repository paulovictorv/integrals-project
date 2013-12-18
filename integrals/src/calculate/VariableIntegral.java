package calculate;

public class VariableIntegral implements IntegrationFunction {
	
	private IntegrationFunction upperLimitFunction;
	private IntegrationFunction lowerLimitFunction;
	private IntegrationFunction	integrand;
	private Variable variable;
	
	public VariableIntegral(IntegrationFunction integrand, IntegrationFunction upperLimit, IntegrationFunction lowerLimit, Variable var) {
		super();
		this.integrand = integrand;
		this.upperLimitFunction = upperLimit;
		this.lowerLimitFunction = lowerLimit;
		this.variable = var;
	}
	
	public double evaluate(double... args){
		double upperLimit = upperLimitFunction.evaluate(args);
		double lowerLimit = lowerLimitFunction.evaluate(args);
		
		return Simpson.simpsonIntegral(integrand, lowerLimit, upperLimit, variable, args);
	}
	
}
