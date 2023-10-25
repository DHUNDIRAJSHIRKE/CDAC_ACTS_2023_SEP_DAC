import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		int pointer = 0;
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		Customer[] log = new Customer[1];
		int i = 0;
		int size = 0;
		/*
		 * for (i = 0; i < size; i++) { log[i] = new Customer(0, null, null); }
		 */
		/*
		 * for (int i = 0; i < size; i++) {
		 * System.out.print("Enter customer details: (id,name,address)"); log[i] = new
		 * Customer(scanner.nextInt(), scanner.next(), scanner.next()); } for (Customer
		 * c : log) { System.out.println(c); }
		 */
		while (!exit) {
			System.out.println("Enter choice: 1.Fixed Stack 2.Growable Stack");
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("enter size of fixed stack:");
				size = scanner.nextInt();
				log = new Customer[size];
				for (i = 0; i < size; i++) {
					log[i] = new Customer(0, null, null);

//					System.out.print(i+" ");
				}
				System.out.println("Fixed Stack of size " + size + " has been created!");
				exit = true;
				break;
			case 2:
				log = new Customer[100];
				for (i = 0; i < size; i++) {
					log[i] = new Customer(0, null, null);
				}
				System.out.println("Growable Stack has been created!");
				exit = true;
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		}
		exit = false;
		i = 0;
		while (!exit) {
			System.out.print("Enter 1.PUSH 2.POP 3.Exit  ");
			switch (scanner.nextInt()) {
			case 1:
				if (i >= size) {
					System.out.println("Maxxx!!");
				} else {
					
					log = FixedStack.push(log,i,size);
		
					System.out.print("Enter customer details: (id,name,address)");
					log[i] = new Customer(scanner.nextInt(), scanner.next(), scanner.next());
					i++;
				
				
				}
				break;
			case 2:
				if (i < 1) {
					System.out.println("nill!!");
				} else {
					System.out.println(log[i - 1]);
					i--;
					System.out.println("popped");
				}
				break;
			case 3:
				exit = true;
			}
		}

		scanner.close();
	}
}

/*
 * 1 Dhundiraj Kolgaon 2 Abhay Gwalher
 */