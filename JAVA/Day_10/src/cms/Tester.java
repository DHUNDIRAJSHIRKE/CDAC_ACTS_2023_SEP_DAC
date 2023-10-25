package cms;

import cms.CustomerValidRules;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import cms.custom.*;
import sorting.CustComparator;

import static cms.utils.CustUtils.populateCustomerList;;

public class Tester {
	public static void main(String[] args) {

		// CustomerValidRules cvr =new CustomerValidRules();
		List<Customer> custList = populateCustomerList();
		try (Scanner sc = new Scanner(System.in)) {
			// Plan plan1;
			boolean exit = false;
			LocalDate janm = LocalDate.of(1995, 03, 12);
			int custCount = 0;
			ArrayList<Customer> people = new ArrayList<>(10);
			Customer c1 = new Customer("Abhay", "Kushwaha", "Abhay1@cdac.in", "123", 323.343, janm, Plan.GOLD);
			people.add(custCount++, c1);
			Customer c2 = new Customer("Abhijit", "Kushwaha", "Abhay2@cdac.in", "123", 323.343, janm,
					Plan.SILVER);
			people.add(custCount++, c2);
			// System.out.println(c1);
			// System.out.println(c1.equals(c2));
			Customer c3 = new Customer("Vibha", "Kushwaha", "Abhay3@cdac.in", "123", 323.343, janm,
					Plan.SILVER);
			people.add(custCount++, c3);
			// System.out.println(c3);
			// System.out.println("Trying to iterate");
			/*
			 * for (Customer c : people) { System.out.print(c); //
			 * System.out.println(c.getCharges()); }
			 */

			System.out.println();
			while (true) {
				try {
					System.out.println(" ");
					System.out.println(
							"1. Sign up (customer registration) \n2. Sign in (login)\n3. Change password\n4. Un subscribe customer\n5. Display all customers \n0. Exit");
					switch (sc.nextInt()) {
					case 1:
						
						System.out.print("Enter Details :(FName,LName,Email,Password,RegAmnt,DoB(yyyy-MM-dd),Plan):");
						Customer newCustomer = CustomerValidRules.vaidateAllInputs(sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), sc.next(), sc.next(), people);
						// cvr.validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),people);
						people.add(custCount++, newCustomer);
						System.out.println("Customer registration successfull!!");
						System.out.println(newCustomer);
						break;
					case 2:

						System.out.print("Enter E-mail Address:");
						String emailcheck = sc.next();
						// CustomerValidRules.DuplicateCust(emailcheck,people);
						System.out.print("Enter password:");
						String passwordcheck = sc.next();
						CustomerValidRules.signInValid(emailcheck, passwordcheck, people);

						// Customer d = new Customer(sc.next());

						break;

					case 3:
						System.out.print("Enter E-mail Address:");
						emailcheck = sc.next();
						// CustomerValidRules.DuplicateCust(emailcheck,people);
						System.out.print("Enter OLD password:");
						String oldPassword = sc.next();
						System.out.print("Enter NEW password:");
						String newPassword = sc.next();
						CustomerValidRules.changePassword(emailcheck, oldPassword, newPassword, people);

						/*
						 * Customer w = new Customer(sc.next()); for (Customer e : people) { if
						 * (w.equals(e)) { // System.out.println("Email matched");
						 * System.out.print("Enter OLD Password: "); if
						 * (sc.next().equals(e.getPassword())) { //
						 * System.out.println("Old password matched");
						 * System.out.print("Now enter NEW password: "); String passNew = sc.next(); if
						 * (passNew.equals(e.getPassword())) {
						 * System.out.println("\t\tOLD password and new Password can't be the same!!");
						 * } else { e.setPassword(passNew); if (e.getPassword().equals(passNew)) {
						 * System.out.println("\t\tPassword set successfully!!"); } } } else {
						 * System.out.println("\t\tInvalid Password!!"); } break; } }
						 */
						break;
					case 4:
						System.out.print("Enter E-mail Address:");
						emailcheck = sc.next();
						// CustomerValidRules.DuplicateCust(emailcheck,people);
						System.out.print("Enter password:");
						passwordcheck = sc.next();
						CustomerValidRules.signInValid(emailcheck, passwordcheck, people);
						Customer e = new Customer(emailcheck);
						people.remove(e);
						System.out.println("Tata , bye bye!!");
						custCount--;
						/*
						 * System.out.print(5"Do you really wan't to UNSUBSCRIBE? Confirm(1/0): "); int
						 * unsub = sc.nextInt(); if (unsub != 1 && unsub != 0) {
						 * System.out.println("Enter a valid input!!"); } else {
						 */
						/*if (unsub == 1) {*/

							
							 /*else {
								System.out.println("Unsubscription aborted for some reason!!");
							}*/
						//}/* else {
							//System.out.println("Subscription retained. You're still worthy! ");
				//		}*/
						// }

						/*
						 * System.out.print("Enter E-mail Address:"); Customer k = new
						 * Customer(sc.next()); for (Customer e : people) { if (k.equals(e)) { //
						 * System.out.println("Email matched"); System.out.print("Enter Password:"); if
						 * (sc.next().equals(e.getPassword())) { //
						 * System.out.println("Old password matched");
						 * System.out.print("Do you really wan't to UNSUBSCRIBE? Confirm(1/0): "); int
						 * unsub = sc.nextInt(); if (unsub != 1 && unsub != 0) {
						 * System.out.println("Enter a valid input!!"); } else { if (unsub == 1) { if
						 * (people.remove(e)) {
						 * 
						 * System.out.println("Tata , bye bye!!"); } else {
						 * System.out.println("Unsubscription aborted for some reason!!"); } } else {
						 * System.out.println("Subscription retained. You're still worthy! "); } } }
						 * else { System.out.println("Invalid Password!!"); } break; } }
						 */
						break;
					case 5:
						for(Customer d: custList) {
							System.out.println(d);
						}
						int nOfCust = 0;
						System.out.println(" ");
						for (Customer q : people) {
							nOfCust++;
							System.out.println(q);
						}
						if (nOfCust == 0) {
							System.out.println("No Customers!!");
						}						
						break;
					case 6:
						Collections.sort(custList);
						for(Customer d : custList) {
							System.out.println(d);
						}
						break;
					case 7:
						Collections.sort(custList,new CustComparator());
						for(Customer d :custList) {
							System.out.println(d);
						}
					case 0:
						sc.close();
						System.exit(0);

					default:
						throw new CustomerVerificationException("Invalid Input!!");
					// System.out.println("Invalid Input!!");
					}
				} catch (DateTimeParseException s) {
					s.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("inside Catch-all");

				}

			}
		}
	// System.out.println("Main Over...");
}

}

/*
 * Tejas Dhikale T.Dhikale@gmail.com Asdf@1234 456.34
 */
