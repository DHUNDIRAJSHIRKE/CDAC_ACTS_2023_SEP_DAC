package cms;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import cms.custom.CustomerVerificationException;

public class CustomerValidRules {
	public static void DuplicateCust(String em, ArrayList<Customer> people) throws CustomerVerificationException {
		// Customer cust = new Customer(em);
		// if (people.contains(cust)) {
		for (Customer e : people) {
			if (e.getEmail().equals(em)) {
				throw new CustomerVerificationException("Try another E-mail.");
			}
		}
		// System.out.println("No duplicates found!");
	}

	public static void signInValid(String email, String password, ArrayList<Customer> people)
			throws CustomerVerificationException {
		// DuplicateCust(email, people);
		boolean flag = true;
		Customer d = new Customer(email);
		for (Customer e : people) {
			// if (d.equals(e.getEmail()))
			if (email.equals(e.getEmail())) {
				// System.out.println("Email matched");
				// System.out.println("Enter Password:");
				if (password.equals(e.getPassword())) {
					// throw new CustomerVerificationException("Sign in Successfull!!");
					System.out.println("Sign in Successfull!!");
					flag = false;
					break;
				} else {
					throw new CustomerVerificationException("Invalid Password!!");
					// System.out.println("Invalid Password!!");
					// break;
				}
			}
		}
		if (flag) {
			throw new CustomerVerificationException("Invalid Email!!");
		}

	}

	public static void changePassword(String email, String oldPassword, String newPassword, ArrayList<Customer> people)
			throws CustomerVerificationException {
		boolean flag = true;
		Customer d = new Customer(email);
		for (Customer e : people) {
			if (d.equals(e)) {
				// System.out.println("Email matched");
				// System.out.println("Enter Password:");
				if (oldPassword.equals(e.getPassword())) {
					e.setPassword(newPassword);
					System.out.println("Pasword reset Successfull!!");
					flag = false;
					break;
				} else {
					// System.out.println("Invalid Password!!");
					throw new CustomerVerificationException(" this is Invalid Password!!");
				}
			}
		}
		if (flag) {
			throw new CustomerVerificationException("Invalid Email!!");
		}
	}

	public static LocalDate parseAndValidateDate(String uncheckedDob) throws DateTimeParseException {
		LocalDate date = LocalDate.parse(uncheckedDob);
		return date;
	}

	public static Plan parseAndValidatePlan(String preCheckColor, double amount) throws CustomerVerificationException {
		Plan plan = Plan.valueOf(preCheckColor.toUpperCase());
		if (plan.getCharges() >= amount) {
			if (plan.getCharges() > amount) {
				throw new CustomerVerificationException("Amount less than Plan's required amount");
			} else {
				return Plan.valueOf(preCheckColor.toUpperCase());
			}
		}
		if (plan.getCharges() <= amount) {
			if (plan.getCharges() < amount) {
				throw new CustomerVerificationException("Amount more than Plan's required amount");
			}

		} else {
			return Plan.valueOf(preCheckColor.toUpperCase());
		}
		return Plan.valueOf(preCheckColor.toUpperCase());
	}

	public static Customer vaidateAllInputs(String fName, String lName, String em, String password, double regAmount,
			String dob, String plan, ArrayList<Customer> people)
			throws CustomerVerificationException, DateTimeParseException, IllegalArgumentException {

		DuplicateCust(em, people);
		LocalDate formDob = parseAndValidateDate(dob);
		Plan checkedplan = parseAndValidatePlan(plan, regAmount);
		Customer c = new Customer(fName, lName, em, password, regAmount, formDob, checkedplan);
		return c;
	}
}

//String fName, String lName, String eMail, String password, double regAmount, LocalDate dob,Plan plan