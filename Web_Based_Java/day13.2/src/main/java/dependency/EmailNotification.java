package dependency;

public class EmailNotification implements CustomerNotification {
	public EmailNotification() {
		System.out.println(" in default constructor of "+getClass());
	}
	@Override
	public void alertCustomer(String mesg) {
		// TODO Auto-generated method stub
		System.out.println(mesg+ " printed from Email!");

	}

}
