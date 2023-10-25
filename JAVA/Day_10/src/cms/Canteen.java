package cms;

import java.util.*;

class Canteen {
	public static void main(String[] args) throws InterruptedException {
		boolean exit = false;
		int num = 0, item, count = 0;
		int bill = 0;

		System.out.println("Enter a choice from below:");
		int i = 1;
		Scanner sc = new Scanner(System.in);
		for (menu nashta : menu.values()) {
			System.out.print(" " + (i++) + ". ");
			System.out.print(nashta);
			System.out.print(" ,");
		}
		System.out.println(i + ". bill ");
		menu Price = null;
		while (!exit) {
			item = sc.nextInt();
			if (item != 6) {
				System.out.print("How many of those:  ->");
				num = sc.nextInt();
			}
			switch (item) {
			case 1:
				Price = menu.valueOf("IDLI");
				bill = bill + num * Price.getPrice();
				System.out.println(" " + num + "  added!!");
				count = count + num;
				break;
			case 2:
				Price = menu.valueOf(("samosa").toUpperCase());
				bill = bill + num * Price.getPrice();
				System.out.println(" " + num + " samosa added!!");
				count = count + num;
				break;

			case 3:
				Price = menu.valueOf(("pohe").toUpperCase());
				bill = bill + num * Price.getPrice();
				System.out.println(" " + num + " pohe added!!");
				count = count + num;
				break;
			case 4:
				Price = menu.valueOf(("dosa").toUpperCase());
				bill = bill + num * Price.getPrice();
				System.out.println(" " + num + " dosa added!!");
				count = count + num;
				break;
			case 5:
				Price = menu.valueOf(("meduvada").toUpperCase());
				bill = bill + num * Price.getPrice();
				System.out.println(" " + num + " meduvada added!!");
				count = count + num;
				break;
			case 6:
				exit = true;
			}
			if (item != 6) {
				System.out.print("Anything else? or 6 to bill:");
			}

		}
		sc.close();
		System.out.println("\t\tYour bill for " + count + " item is :$" + bill);

	}
}
