package calculate;

public class ConstantFunction implements IntegrationFunction {

	private double constant;
	
	public ConstantFunction(double value) {
		constant = value;
	}
	
	public double constant(){
		return constant;
	}
	
	@Override
	public double evaluate(double... args) {
		return constant;
	}

}
