package signment;
import java.util.Scanner;
public class TesterMain {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of shapes:");
		BoundedShape[] shapes = new BoundedShape[scanner.nextInt()];
		/*
		 * for( BoundedShape s : shapes) { System.out.println(s); }
		 */
		shapes[0] = new Rectangle(1,5,10,20);
		
	}
}
