package tester;
//import Point2D;
import java.util.Scanner;

class Graph {
	public static void main(String[] args) {
		boolean exit = false;
		int n = 3;
		int bigFlag = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array:");
		n= sc.nextInt();
		int[] flag = new int[n];
		Point2D[] points;
		points = new Point2D[n];
		while (!exit) {
			System.out.println(
					"Enter 1. to plot a point \t 2. to Display all points \t 3. to check 2 indices \t 0. EXIT");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter the index at which point is to be entered:");
				int index = sc.nextInt();
				if (index < 0 || index > n) {
					System.out.println("Invalid Index!");
					break;
				}
				if (flag[index] == 0) {
					System.out.print("Enter x & y co-ordinates : ");
					points[index] = new Point2D(sc.nextDouble(), sc.nextDouble());
					flag[index] = 1;
				} else {
					System.out.println("Point already Exists at this Index i.e. " + index);
				}
				break;
			case 2:
				for (int i = 0; i < points.length; i++) {
					if (flag[i] == 1) {
						System.out.println("Point[" + i + "] is :" + points[i].show());
					}
					if (flag[i] == 0) {
						bigFlag = 1;
					}
				}
				if (bigFlag == 1) {
					System.out.println("points not plotted at indices:");
					for (int i = 0; i < points.length; i++) {

						if (flag[i] == 0) {
							System.out.print(" " + i);
						}
					}
				}
				System.out.println();

				break;
			case 3:
				System.out.println("Enter two indices :");
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (a < 0 || a > n || b < 0 || b > n) {
					System.out.println("Invalid Index!");
					break;
				}
				if (flag[a] == 0 || flag[b] == 0) {
					if (flag[a] == 0) {
						System.out.println("point at index " + a + " is yet to be plotted!");
					} else {
						System.out.println("point at index " + b + " is yet to be plotted!");
					}

				}
				if (flag[a] == 1 && flag[b] == 1) {
					if (points[a].isEqual(points[b])) {
						System.out.println("points at indices " + a + " and " + b + " are same!");
					} else {
						System.out.println("Distance between point at index " + a + points[a].show() + " and at index  "
								+ b + "" + points[b].show() + " is " + points[b].calculateDistance(points[a])
								+ " units!");
					}
				}
				break;
			case 0:
				exit = true;
			}
		}

		System.out.println("Bye!");
		sc.close();
	}
}