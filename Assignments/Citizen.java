package Assignments;

public class Citizen {
	public String name;
	public String nationality;
	public int age;
	
	public Citizen(String name,String nationality, int age) {
		this.name= name;
		this.nationality = nationality;
		this.age = age;
		
	}
	 
	public String isEligible(String name,String nationality,int age) {
		if(this.nationality.equalsIgnoreCase("nepali") && this.age>=18) {
			return this.name + " is eligible to  vote.";
		}
		else {
			return  this.name + " is not eligible to vote.";
		}
	}
}
