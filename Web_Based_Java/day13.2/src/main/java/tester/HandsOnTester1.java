package tester;

import dependency.SoapTransport;
import dependent.ATMImpl;

public class HandsOnTester1 {

	public static void main(String[] args) {
		ATMImpl atm = new ATMImpl(10000.00);
		atm.setMyTransport(new SoapTransport());
		atm.deposit(5000.5);
	}

}
