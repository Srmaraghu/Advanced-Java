package Assignments;

public class Number {
	int dividend;
	public Number(int dividend)
	{
		this.dividend=dividend;
	}
	
	public String  isDivisible(int dividend) 
	{
		if(this.dividend % 3 == 0 &&  this.dividend % 5 ==0) {
			return "Integer " + this.dividend + " is divisible by both 3 and 5.";
			
		}
		else if(this.dividend % 5 == 0) {
			return "Integer " + this.dividend + " is divisible by 5.";
		}
		else if(this.dividend % 3 == 0) {
			return "Integer " + this.dividend + " is divisible by 3.";
		}
		else {
			return "Integer " + this.dividend + " is not divisible by neither 3 nor 5.";
		}
	
	}
}
