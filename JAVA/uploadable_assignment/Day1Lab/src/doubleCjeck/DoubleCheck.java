package doubleCjeck;

import java.util.Scanner;

public class DoubleCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number");
		double d1,d2; 
		
		if( sc.hasNextDouble()&&sc.hasNextDouble())
		{
			d1 = sc.nextDouble();
			d2 = sc.nextDouble();
			System.out.println("Entered number is a double value :"+d1);
			System.out.println("Entered number is double value :"+d2);
			System.out.println("Average of two doubles is :"+((double)(d1+d2)/2));
		}
		else
		{
			System.out.println("Entered number is not a double");
		}
		
		sc.close();
	}

}
