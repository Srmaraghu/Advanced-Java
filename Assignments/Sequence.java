package Assignments;

public class Sequence {
	int num;
	public Sequence()
	{
		num=7;
	}
	public void result() {
		System.out.println("Sequence of numbers up to 15th terms are: ");
		
		for(int i=1;i<=15;i++)
		{
			System.out.println(num + " ");
			if(num%2==0) {
				num/=2;
			}
			else {
				num=(num*3)+1;
			}
		}
	}

}
