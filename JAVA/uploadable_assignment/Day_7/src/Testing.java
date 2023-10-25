import java.util.Scanner;

public class Testing {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack[] arr = new Stack[1];
		boolean flag = false;
		boolean exit = false;
		boolean chosen = false;
		while (!exit) {
			System.out.println("Enter choice: 1.Fixed Stack 2.Growable Stack 3.PUSH 4.POP 5.Exit :");
			switch (scanner.nextInt()) {
			case 1:
				if (!flag) {
					chosen = true;
					System.out.println("Fixed Stack has been created!");
					arr[0] = new FixedStack();
					flag = true;
				} else {
					System.out.println("Invalid Choice!!!");
				}
				break;
			case 2:
				if (!flag) {
					chosen = true;
					arr[0] = new GrowableStack();
					System.out.println("Growable Stack has been created!");
					flag = true;
				} else {
					System.out.println("Invalid Choice!!!");
				}
				break;
			case 3:
				if (!chosen) {
					System.out.println("Select one of the stacks first!");
				} else {
					if (arr[0] instanceof FixedStack) {
						System.out.println("in FixedStack's push");
						System.out.println("Enter details of Customer:");
						Customer f = new Customer(scanner.nextInt(), scanner.next(), scanner.next());
						((FixedStack) arr[0]).push(f);
					} else {
						System.out.println("in GrowableStack's push");
						System.out.println("Enter details of Customer:");
						Customer f = new Customer(scanner.nextInt(), scanner.next(), scanner.next());
						((GrowableStack) arr[0]).push(f);
					}
				}
				break;
			case 4:
				if (!chosen) {
					System.out.println("Select one of the stacks first!");
				} else {
					if (arr[0] instanceof GrowableStack) {
						System.out.println("in GrowableStack's pop");
						((GrowableStack) arr[0]).pop();
					} else {
						System.out.println("in FixedStack's pop");
						((FixedStack) arr[0]).pop();
					}
				}
				break;
			case 5:
				exit = true;
				System.out.println("Khatam,Tata ,bye, bye!!");
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		}
		scanner.close();
	}
}

// 1 sf sf 
// 2 sdf lkj 
// 3 df sf 
// 4 sf kjl
// 5 k io
