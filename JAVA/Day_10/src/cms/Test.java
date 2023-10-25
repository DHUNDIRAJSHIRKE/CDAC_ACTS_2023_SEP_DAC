package cms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDate janm = LocalDate.of(1995, 03, 12);
		ArrayList<Customer> people = new ArrayList<>(10);
		Customer c1 = new Customer("Abhay", "Kushwaha", "Abhay@cdac.in", "Password@123", 323.343, janm, Plan.GOLD);
		people.add(0, c1);
		Customer c2 = new Customer("Amit", "Kushwaha", "Abhay1@cdac.in", "Password@1234", 323.343, janm, Plan.GOLD);
		people.add(1, c2);
		// System.out.println(c1);

		for (Customer a : people) {
			System.out.println(a);
		}

		System.out.println("Enter E-mail Address:");
		Customer d = new Customer(sc.next());
		for (Customer e : people) {
			if (d.equals(e)) {
				// System.out.println("Email matched");
				System.out.println("Enter Password:");
				if (sc.next().equals(e.getPassword())) {
					System.out.println("Old password matched");
					System.out.print("Do you really wan't to UNSUBSCRIBE? Confirm(1/0): ");
					int unsub = sc.nextInt();
					if (unsub != 1 && unsub != 0) {
						System.out.println("Enter a valid input!!");
					} else {
						if (unsub == 1) {
							if (people.remove(e)) {

								System.out.println("Tata , bye bye!!");
							}
						} else {
							System.out.println("Subscription retained. You're still worthy! ");
						}
					}
				} else {
					System.out.println("Invalid Password!!");
				}
				break;
			}
		}
		for (Customer it : people) {
			System.out.println(it);
		}
		sc.close();
	}
}
