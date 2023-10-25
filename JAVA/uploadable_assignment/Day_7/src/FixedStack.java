
public class FixedStack implements Stack {
	FixedStack(){
		
	}
	static int size = 2;
	Customer[] fStack = new Customer[size];
	int top = -1;

	/*
	 * FixedStack(int id, String name, String address) { super(id, name, address); }
	 */
	/*
	 * public Customer[] push(Customer grahak[], int i, int size) { Customer[] temp
	 * = new Customer[size+1]; for (int j = 0; j < size; j++) { temp[j] = grahak[j];
	 * } int j=size; temp[j] = new Customer(sc.nextInt(),sc.next(),sc.next());
	 * return temp; }
	 */
	@Override
	public void pop() {
		if(top<0) {
			System.out.println("Stack Empty!!");
		}
		else {
			System.out.println(fStack[top]);
			fStack[top--]=null;
		}
	}

	@Override
	public void push(Customer grahak) {
		// TODO Auto-generated method stub
		if(top<size-1) {
			fStack[++top]=grahak;
			if(top==size) {
				System.out.println("Stack Full!!");
			}
		}
		else {
			System.out.println("Stack Full!!");
		}
		
	}
}
