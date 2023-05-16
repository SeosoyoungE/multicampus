package basic;

public class Calc {
	public int clac(int num1, String method,int num2) {
		int result=0;
		if(method.equals("+")) {
			result=num1+num2;
		} else if(method.equals("-")) {
			result=num1-num2;
		} else if(method.equals("*")) {
			result=num1*num2;
		} else if(method.equals("/")) {
			result=num1/num2;
		}
		return result;
	}
}
