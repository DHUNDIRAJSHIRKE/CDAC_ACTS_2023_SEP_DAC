package sorting;

import java.util.Comparator;

import cms.Customer;

public class CustComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o2.getEmail().compareTo(o1.getEmail());
		
	}
	
}
