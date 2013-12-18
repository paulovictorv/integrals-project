package expression;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculate.Variable;

public class IntegralMatcher {
	
	private String textIntegral;
	private Matcher integral;
	
	public IntegralMatcher(String textIntegral) {
		String pattern = "int(i?n?t?(i?n?t?(.*?)?d?[x|y|z]?)?d?[x|y|z]?)d[x|y|z]";
		this.textIntegral = textIntegral;
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(textIntegral);
		matcher.find();
		this.integral = matcher;
	}
	
	public String getIntegrand(){
		return integral.group(3);
	}
	
	public int countVariables(){
		int counter = 1;
		if (textIntegral.contains("dy"))
			counter++;
		if (textIntegral.contains("dz"))
			counter++;
		
		return counter;
	}
	
	public Variable getFirstVariable(){
		int indexOfDx = textIntegral.indexOf("dx");
		int indexOfDy = textIntegral.indexOf("dy");
		int indexOfDz = textIntegral.indexOf("dz");
		
		int min = indexOfDx;
		if (indexOfDy < min)
			min = indexOfDy;
		if (indexOfDz < min)
			min = indexOfDz;
		
		if (min == indexOfDx){
			return Variable.X;
		} else if (min == indexOfDy){
			return Variable.Y;
		} else {
			return Variable.Z;
		}
	}
	
	public Variable getSecondVariable(){
		int indexOfDx = textIntegral.indexOf("dx");
		int indexOfDy = textIntegral.indexOf("dy");
		int indexOfDz = textIntegral.indexOf("dz");
		
		int[] indexes = {indexOfDx, indexOfDy, indexOfDz};
		Arrays.sort(indexes);
		
		if (indexes[1] == indexOfDx){
			return Variable.X;
		} else if (indexes[1] == indexOfDy){
			return Variable.Y;
		} else {
			return Variable.Z;
		}
	}
		
}
