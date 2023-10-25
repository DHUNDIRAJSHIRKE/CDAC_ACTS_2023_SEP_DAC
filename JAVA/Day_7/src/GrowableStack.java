public class GrowableStack implements Stack {
	
	int STACK_SIZE = 5;
	int top = -1;
	GrowableStack(){
		
	}
	Customer[] gStack = new Customer[STACK_SIZE];
	@Override
	public void push(Customer grahak) {
		if(top<STACK_SIZE-1) {
			gStack[++top] = grahak;
		}else {
			STACK_SIZE*=2;
			Customer[] newGStack = new Customer[STACK_SIZE];
			for(int i = 0; i<STACK_SIZE;i++) {
				newGStack[i] =  gStack[i];
			}
			gStack = newGStack;
		}
	}
	 




	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if(top<0) {
			System.out.println("Empty Stack!!");
			
		}
		else {
			System.out.println(gStack[top]);
			gStack[top]=null;
			top--;
		}
		
	}
}
