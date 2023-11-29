package dependent;

import dependency.EmailNotification;
import dependency.HttpTransport;
import dependency.Transport;
import dependency.CustomerNotification;

public class ATMImpl implements ATM {
	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	private Transport myTransport;
	private double cash;
	private CustomerNotification notice;
	public CustomerNotification getNotice() {
		return notice;
	}

	public void setNotice(CustomerNotification notice) {
		this.notice = notice;
	}

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
		
	}
	
	public ATMImpl(double cash) {
		System.out.println("in cnstr of " + getClass().getName() );
		this.cash = cash;
		System.out.println(" in parameterized constructor of ATMImpl, cash set to "+ cash);
	}
	
	public ATMImpl(double cash,Transport t1234) {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
		this.cash = cash;
		
		System.out.println(" in parameterized constructor of ATMImpl, cash set to "+ cash);
	}

	@Override
	public void deposit(double amt) {
		cash += amt;
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling dependency's method to inform the bank
		service(amt, "credited");
	}

	@Override
	public void withdraw(double amt) {
		cash -= amt;
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
		service(amt, "debited");
	}
	// setter : setter Based D.I

	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter " + this.myTransport);
	}

	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}
	
	public void service(double cash, String action) {
		EmailNotification emNotify = new EmailNotification();
		String msg = cash+" "+action+" to your account!";
		emNotify.alertCustomer(msg);
	}

}
