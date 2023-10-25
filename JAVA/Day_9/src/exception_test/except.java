package exception_test;

import java.util.Scanner;

import exception_test.SpeedOutOfBoundException;

public class except throws SpeedOutOfBoundException extends Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your speed: ");
		throw new SpeedOutOfBoundException(sc.nextInt());
	
}
