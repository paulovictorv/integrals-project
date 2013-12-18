package calculate;

public class Utils {

	public static double[] concat(double[] first, double[] second) {
		int aLen = first.length;
		int bLen = second.length;
		double[] C = new double[aLen+bLen];
		System.arraycopy(first, 0, C, 0, aLen);
		System.arraycopy(second, 0, C, aLen, bLen);
		return C;
	}
	
	public static double[] middleIt(double[] original, double element){
		double[] calc = new double[original.length + 1];
		if (original.length == 1){
			calc[0] = original[0];
			calc[1] = element;
		} else if (original.length == 2){
			calc[0] = original[0];
			calc[1] = element;
			calc[2] = original[1];
		}
		
		return calc;
	}

}
