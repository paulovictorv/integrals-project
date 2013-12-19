package calculate;

public class DefiniteIntegral implements IntegrationFunction {

	private double upperLimit;
	private double lowerLimit;
	private IntegrationFunction	integrand;
	private Variable variable;
	
	public DefiniteIntegral(Integral integrand, double upperLimit, double lowerLimit, Variable var) {
		super();
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.integrand = (IntegrationFunction) integrand;
		this.variable = var;
	}

	@Override
	public double evaluate(double... args) {
		return Simpson.simpsonIntegral(integrand, lowerLimit, upperLimit, variable, args);
	}
}
