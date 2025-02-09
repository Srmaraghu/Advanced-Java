package Assignments;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //User
//		System.out.println("Enter your user name:");
//		String userName = scan.next();//takes user input
//		System.out.println("Enter your password:");
//		String password = scan.next();//takes user input
//		User u1 = new User("www","123");
//		System.out.println(u1.authenticate(userName,password));
//		scan.close();
//		
        //citizen
        // System.out.println("Enter your name:");
        // String name = scan.next();//takes user input
        // System.out.println("Enter your nationality:");
        // String nationality = scan.next();//takes user input
        // System.out.println("Enter your age:");
        // int age = scan.nextInt();//takes user input
        // Citizen c1 = new Citizen(name,nationality,age);
        // System.out.println(c1.isEligible(name,nationality,age));
        // scan.close();

        //Number
//		System.out.println("Enter any positive Integer:");
//		int num = scan.nextInt();//takes user input
//		Number n1 = new Number(num);
//		System.out.println(n1.isDivisible(num));
//		scan.close();
        //fibonacci
//		Fibonacci fib = new Fibonacci();
//		fib.display(15);
        //sequence
//		Sequence seq = new Sequence();
//		seq.result();


		//Armstrong 
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        scan.close();

		Armstrong arm = new Armstrong();

        if (arm.isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }


		//Palindrome
		// System.out.print("Enter a number: ");
        // int number = scan.nextInt();
        // scan.close();

		// Palindrome p = new Palindrome();
		// p.isPalindrome(number);
		

		//Indiviudal Dgits
		// System.out.print("Enter a number: ");
        // String  number = scan.nextLine();
        // scan.close();
		// IndividualDigits d= new IndividualDigits();
		// d.printDigits(number);


    }

}
