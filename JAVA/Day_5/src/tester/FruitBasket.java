package tester;

import com.app.fruits.*;
import java.util.Scanner;

import com.app.fruits.Apple;
import com.app.fruits.Fruit;
import com.app.fruits.Mango;
import com.app.fruits.Orange;
import java.util.Scanner;

public class FruitBasket {
	public static void main(String[] args) {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter capacity of Fruit-Basket: ");
		int size = sc.nextInt();
		Fruit[] basket = new Fruit[size];
		/*
		 * for (Fruit fal : basket) { System.out.println(fal); }
		 */
		int count = 0;
		int index = 0;
		/*
		 * for(int i= 0;i<basket.length;i++) { basket[i].toString(); }
		 */
		/*
		 * basket[0] = new Apple("Macintosh", "red", 50, true); basket[1] = new
		 * Mango("Alphonso", "Yellow", 60, true); basket[2] = new Orange("Nagpuri",
		 * "Orange", 30, false); System.out.println(basket[0].toString());
		 * System.out.println(basket[0].taste()); System.out.println();
		 * ((Apple)basket[0]).jam(); ((Mango)basket[1]).pulp();
		 * ((Orange)basket[2]).juice();
		 */
		while (!exit) {
			System.out.print("Enter choice among follows: ");
			System.out.print(
					"\n1.Add Mango   2.Add Orange   3.Add Apple   4.Display All   5.Display Fresh Fruits   6.Mark Stale   7.Mark sour as Stale   8.Eat   9.Exit\t");
			// System.out.println(sc.nextInt());
			switch (sc.nextInt()) {
			case 1: // Mango();
				if (count >= size) {
					System.out.println("Basket is FULL!!");
				}
				if (count < size) {
					System.out.print("Enter Details of Mango (name,color,weight): ");
					basket[count++] = new Mango(sc.next(), sc.next(), sc.nextDouble());
				}

				break;
			case 2:
				// Orange();
				if (count < size) {
					System.out.print("Enter Details of Orange (name,color,weight): ");
					basket[count++] = new Orange(sc.next(), sc.next(), sc.nextDouble());
				}
				if (count >= size) {
					System.out.println("Basket is FULL!!");
				}
				break;
			case 3:// Apple();
				if (count < size) {
					System.out.print("Enter Details of Apple (name,color,weight): ");
					basket[count++] = new Apple(sc.next(), sc.next(), sc.nextDouble());
				}
				if (count >= size) {
					System.out.println("Basket is FULL!!");
				}

				break;
			case 4://show all
				for (int i = 0; i < count; i++) {
					if (basket[i] instanceof Mango) {
						System.out.print(i + ". Mango ");
					}
					if (basket[i] instanceof Orange) {
						System.out.print(i + ". Orange ");
					}
					if (basket[i] instanceof Apple) {
						System.out.print(i + ". Apple ");
					}
					System.out.println(basket[i].getName());
				}
				break;
			case 5: //show fresh fruits
				int flag = 0;
				for (int i = 0; i < count; i++) {
					if (basket[i].getFresh() == true) {
						System.out.println(i + ". " + basket[i].toString() + " Taste: " + basket[i].taste());
						flag = flag + 1;
					}
				}
				if (flag == 0) {
					System.out.println("\t\tNo fresh fruits!!");
				}
				break;
			case 6: //mark stale by index
				System.out.print("Enter Index of the fruit to mark it stale: ");
				index = sc.nextInt();
				if (index >= count) {
					System.out.println("Fruit isn't present at this Index!!");
					break;
				}
				if (index < 0 || index > size) {
					System.out.println("Invalid Index!!");
					break;
				}
				if (index < count) {
					basket[index].setFresh(false);
					System.out.println("Fruit at the index " + index + " is set Stale!");
				}
				break;
			case 7: //set sour stale
				for (int i = 0; i < count; i++) {
					if (basket[i].getFresh() == true) {
						if (basket[i].taste().equals("sour") || basket[i].taste().equals("sweet n sour")) {
							basket[i].setFresh(false);
							System.out.println("Fruit at the index " + i + " is set Stale!");
						}
					}
				}
				break;
			case 8: //eat
				System.out.print("Enter Index of the fruit to eat it : ");
				index = sc.nextInt();
				if (index >= count) {
					System.out.println("Fruit isn't present at this Index!!");
					break;
				}
				if (index < 0) {
					System.out.println("Invalid Index!!");
					break;
				}
				if (index < count) {
					if (basket[index] instanceof Mango) {
						((Mango) basket[index]).pulp();
					}
					if (basket[index] instanceof Orange) {
						((Orange) basket[index]).juice();
					}
					if (basket[index] instanceof Apple) {
						((Apple) basket[index]).jam();
					}
				}

				break;
			case 9:
				exit = true;
				break;
			}
		}

	}
}

/*
 * hapus yellow 34.5 nagpuri orange 30.3 green_apple green 85.7 Totapuri Pivla
 * 56.3 Kashmiri Red 45.6
 */
