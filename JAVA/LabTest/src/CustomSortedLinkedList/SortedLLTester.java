package CustomSortedLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortedLLTester {

	public static void main() {

		SortedLL list = new SortedLL();
		Scanner sc = new Scanner(System.in);
		Boolean flag = false;
		while (!flag) {
			try {
				System.out.println("MENU : \n1.add(x) \n2.addAll(List of x)\n3.remove(index)\n4.toString \n5.exit");
				System.out.println("Enter your choice :  ");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter the element to be added in the list");
					list.addElement(sc.nextInt());
					break;
				case 2:
					List<Integer> anotherList = new ArrayList<Integer>();
					anotherList.addAll(List.of(10,20,40,30,15));
					list.addAllElementFromAnotherList(anotherList);
					break;
				case 3:
					System.out.println("Enter the index of element to be removed from list");
					list.removeElement(sc.nextInt());
					break;
				case 4:
					System.out.println("List elements are : ");
					System.out.println(list.toStringForList());
					break;
				case 5:
					flag = true;
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid choice....please try again");
					break;

				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
