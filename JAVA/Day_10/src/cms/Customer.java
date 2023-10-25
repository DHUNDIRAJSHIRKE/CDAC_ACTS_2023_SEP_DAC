package cms;

import java.time.LocalDate;
//import Plan;
public class Customer implements Comparable<Customer> {
	private static int custIdCount = 1001;
	private int custId;
	private String fName;
	private String lName;
	private String eMail;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private Plan plan;

	public Customer(String fName, String lName, String eMail, String password, double regAmount, LocalDate dob,Plan plan) {
		this.custId = custIdCount++;
		this.fName = fName;
		this.lName = lName;
		this.eMail = eMail;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}
	public Customer(String eMail) {
		this.eMail = eMail;
	}
	public Customer(String fName2, String lName2, String eMail2, String password2, int regAmount2, String string,
			String string2) {
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return this.password;
	}
	/*public Customer(int custId) {
		this.custId = custId;
	}*/
	//Price = menu.valueOf(("samosa").toUpperCase());
	@Override
	public String toString() {
		return "[ ID: " + custId + ", FirstName: " + fName + ", LastName: " + lName + ", E-Mail: " + eMail
				+ ", Registration Amount: " + regAmount + ", DOB: " + dob+", Plan : "+plan.name()+" Charges : "+ plan.getCharges()+" ]";
	}
	public String getEmail() {
		return this.eMail;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Customer) {
			Customer c = (Customer)obj;
			if(c.getEmail().equals(this.eMail)) {
				System.out.println(c);
				return true;
			}	
		}
		return false;
	}
	@Override
	public int compareTo(Customer o) {
		return this.getEmail().compareTo(o.getEmail());
		// TODO Auto-generated method stub
//		return 0;
	}
}
//"+plan.toString().getCharges()+"