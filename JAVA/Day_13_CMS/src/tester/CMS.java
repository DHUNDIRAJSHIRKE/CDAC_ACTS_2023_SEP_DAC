package tester;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exceptions.CustomerHandlingException;
import utils.CompareEmail;

import static utils.CustomerValidationRules.*;
import static utils.CustUtils.populateCustomerList;
public class CMS {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// D.S : exam tip : start with populated sample data
			Map<String, Customer> customers = populateCustomerList();
			while (!exit) {
				System.out.println("1. SignUP 2. Signin 3.Change Password 4.Un subscribe 0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // reg
						System.out.println(
								"Enter firstName,  lastName,  email,  password, regAmount,  dob(yr-mon-day),  plan");
						Customer customer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(customer.getEmail(), customer);
						System.out.println("customer signed up !");
						break;
					case 2: // sign in
						System.out.println("Enter email n pwd");
						customer=authenticateCustomer(sc.next(), sc.next(), customers);
						System.out.println("Login successful , your details " + customer);

						break;
					case 3:

						break;
					case 4:

						break;
					case 5:
						System.out.println("In 5");
						for(Customer d : customers.values()) {
							
							System.out.println(d);
						}
						break;
					case 6: 
						TreeMap<String , Customer> custTree = new TreeMap<>(customers);
						
						for(Customer d : custTree.values()) {
							System.out.println(d);
						}
						//Collections.sort(customers.values());
						break;
					case 7:
						TreeMap<String, Customer> custTree2 = new TreeMap<>(new CompareEmail());
						for(Customer d : customers.values()) {
							custTree2.put(d.getEmail(), d);
						}
					//	custTree2.put( "1RajKumar@gmail.com",new Customer("Raj", "kumar", "1RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), ServicePlan.PLATINUM));
						//custTree2.put("6RajKumar@gmail.com",new Customer("Ajay", "kumar", "6RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), ServicePlan.PLATINUM));
						for(Customer d : custTree2.values()) {
							//System.out.println("something");
							System.out.println(d);
						}
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}

		}

	}

}
