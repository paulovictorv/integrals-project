package expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculate.Variable;


public class IntegralParser {
	
	private Matcher integral;
	
	public IntegralParser(String textIntegral) {
		String pattern = "(int)+(.*?)(d[x|y|z])(d[x|y|z])?(d[x|y|z])?";
		
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(textIntegral);
		
		matcher.find();
		
		this.integral = matcher;
	}
	
	public String getIntegrand(){
		return integral.group(2);
	}
	
	public int countIntegratingVariables(){
		int counter = 1;
		if (!integral.group(5).isEmpty())
			counter++;
		if (!integral.group(6).isEmpty())
			counter++;
		
		return counter;
	}
	
	public List<Variable> getVariablesSorted() throws InvalidIntegralException{
		try {
			List<Variable> list = new ArrayList<Variable>();
	
			String firstVar = integral.group(3);
			String secondVar = integral.group(4);
			String thirdVar = integral.group(5);
			
			if (firstVar != null){
				list.add(toVariable(firstVar));
			} else {
				throw new InvalidIntegralException("");
			}
			
			if (secondVar != null){
				list.add(toVariable(secondVar));
			}
			
			if (thirdVar != null){
				list.add(toVariable(thirdVar));
			}
			return list;
		} catch (IllegalStateException e){
			throw new InvalidIntegralException("");
		}
			
	}

	private Variable toVariable(String var) {
		if (var.equals("dx"))
			return Variable.X;
		else if (var.equals("dy"))
			return Variable.Y;
		else 
			return Variable.Z;
	}
	
	
		
}
