package tester;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// launch SC
		try (ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("bean_config.xml");Scanner sc = new Scanner(System.in)) {
			System.out.println("SC up n running ....");
			//deposit funds
			//get rdy to use (ready for servicing) spring bean from SC
			ATMImpl ref1=ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(" Enter Amount to be withdrawn: ");
			ref1.withdraw(sc.nextDouble());
			ATMImpl ref2=ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(ref1==ref2);
			System.out.println(ref1.getCash());
		} //ctx.close() => shutting down SC --
		//searches for singleton beans --if it has custom destroy method --
		//invokes it --marks the bean for GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
