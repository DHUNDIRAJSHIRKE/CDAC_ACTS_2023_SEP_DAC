package cms.utils;
import cms.Customer.*;
import cms.Plan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cms.custom.CustomerVerificationException;

import cms.Customer;
public class CustUtils {
	public static Customer FindByEmail(String em,ArrayList<Customer> people) throws CustomerVerificationException {
		Customer c = new Customer(em);
		int index = people.indexOf(c);
		if(index == -1 ) {
			return c;
		}
		else {
			throw new CustomerVerificationException("Email already in use!!");
			
		}
	}
	public static List<Customer> populateCustomerList(){
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Raj", "kumar", "1RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), Plan.PLATINUM));
		customers.add(new Customer("Ajay", "kumar", "6RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), Plan.PLATINUM));
		customers.add(new Customer("Raj", "kumar", "4RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), Plan.PLATINUM));
		customers.add(new Customer("Raj", "kumar", "5RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), Plan.PLATINUM));
		customers.add(new Customer("Raj", "kumar", "3RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), Plan.PLATINUM));
		return customers;
	}
}
