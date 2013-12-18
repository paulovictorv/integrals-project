package calculate;

public class Simpson {
	
	public static double simpsonIntegral(IntegrationFunction function, double lowerLimit, double upperLimit, Variable whereToIntegrate, double... constantValues){
		int n = 160;
		double h = (upperLimit - lowerLimit) / n;

		double firstSumFactor = 0.0; 

		double[] lowerLimitAsArray = {lowerLimit};

		if (whereToIntegrate == Variable.X){
			firstSumFactor = function.evaluate(Utils.concat(lowerLimitAsArray, constantValues));
		} else if (whereToIntegrate == Variable.Y){
			firstSumFactor = function.evaluate(Utils.middleIt(constantValues, lowerLimit));
		} else if (whereToIntegrate == Variable.Z){
			firstSumFactor = function.evaluate(Utils.concat(constantValues, lowerLimitAsArray));
		}
		
		double firstSummation = 0.0;
		for (int secondFactorCounter = 1 ; secondFactorCounter <= (n/2 - 1) ; secondFactorCounter++){
			double calculated = lowerLimit + 2 * secondFactorCounter * h;
			double[] calculateAsArray = {calculated};
			
			if (whereToIntegrate == Variable.X){
				firstSummation += function.evaluate(Utils.concat(calculateAsArray, constantValues));
			} else if (whereToIntegrate == Variable.Y){
				firstSummation +=  function.evaluate(Utils.middleIt(constantValues, calculated));
			} else if (whereToIntegrate == Variable.Z){
				firstSummation +=  function.evaluate(Utils.concat(constantValues, calculateAsArray));
			}
		}
		
		firstSummation *= 2;
		
		double secondSummation = 0.0;
		for (int thirdFactorCounter = 1 ; thirdFactorCounter <= (n/2) ; thirdFactorCounter++){
			double calculated = lowerLimit + (2 * thirdFactorCounter - 1) * h;
			double[] calculateAsArray = {calculated};
			
			if (whereToIntegrate == Variable.X){
				secondSummation += function.evaluate(Utils.concat(calculateAsArray, constantValues));
			} else if (whereToIntegrate == Variable.Y){
				secondSummation +=  function.evaluate(Utils.middleIt(constantValues, calculated));
			} else if (whereToIntegrate == Variable.Z){
				secondSummation +=  function.evaluate(Utils.concat(constantValues, calculateAsArray));
			}

		}
		secondSummation *= 4;
		
		double lastSumFactor = 0.0;
		double[] upperLimitAsArray = {upperLimit};
		if (whereToIntegrate == Variable.X){
			lastSumFactor = function.evaluate(Utils.concat(upperLimitAsArray, constantValues));
		} else if (whereToIntegrate == Variable.Y){
			lastSumFactor = function.evaluate(Utils.middleIt(constantValues, upperLimit));
		} else if (whereToIntegrate == Variable.Z){
			lastSumFactor = function.evaluate(Utils.concat(constantValues, upperLimitAsArray));
		}
		

		return h/3 * (firstSumFactor + firstSummation + secondSummation + lastSumFactor);
	}
}
