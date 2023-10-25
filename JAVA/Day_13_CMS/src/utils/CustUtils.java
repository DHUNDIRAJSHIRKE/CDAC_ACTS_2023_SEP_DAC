package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;

public class CustUtils {
	public static Map<String,Customer> populateCustomerList(){
		Map<String,Customer> customers = new HashMap<>();
		customers.put("1RajKumar@gmail.com",new Customer("Raj", "kumar", "1RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), ServicePlan.PLATINUM));
		customers.put("6RajKumar@gmail.com",new Customer("Ajay", "kumar", "6RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), ServicePlan.PLATINUM));
		customers.put("4RajKumar@gmail.com",new Customer("Raj", "kumar", "4RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), ServicePlan.PLATINUM));
		customers.put("5RajKumar@gmail.com",new Customer("Raj", "kumar", "5RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), ServicePlan.PLATINUM));
		customers.put("3RajKumar@gmail.com",new Customer("Raj", "kumar", "3RajKumar@gmail.com", "123", 10000, LocalDate.parse("1999-05-03"), ServicePlan.PLATINUM));
		return customers;
	}
}
