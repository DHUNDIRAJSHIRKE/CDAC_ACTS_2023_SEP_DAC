package exception_test;
import java.util.Scanner;
import exception_test.RoadRules;
public class Test {
	
	public static final String COURSE= "DAC";
	
	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("Enter your speed:"); int speed = scanner.nextInt();
		 */
		//CheckSpeed(speed);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Course: ");
		String courseInput = scanner.next();
		
		if(courseInput.equals(COURSE)) {
			System.out.println("EQUALS");			
		}else {
			System.out.println("NOT EQUALS");
		}
	}
}
