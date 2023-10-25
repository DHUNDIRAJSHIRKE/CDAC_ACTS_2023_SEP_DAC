package StockTradingService;

import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import StockExc.StockValidationException;
import utils.StockUtils;

import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//import static utils.StockUtils.searchByCompany;

import static utils.StockUtils.*;

public class Tester {
	public static void main(String[] args) {
		//boolean exit = false;
		StockUtils su = new StockUtils();
		HashMap<String, Stock> stockMap = new HashMap<>();
		stockMap = StockUtils.populateHashMap();
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				try {
					
					System.out.println("Enter 1.Create new stock 2.Print all stocks 3.Search by company 4. purchase stocks 5.sell stocks 6.exit ");
					
					switch (sc.nextInt()) {
					case 1:
						Stock newStock = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), sc.nextInt(), stockMap);
						stockMap.putIfAbsent(newStock.getCompanyName(), newStock);
						System.out.println(newStock);
						break;
					case 2:
						for(Stock s : stockMap.values()) {
							System.out.println(s);
						}
						/*
						 * Collections.(stockMap); list.forEach(c -> System.out.println(c));
						 */
						// System.out.println();
						break;
					case 3:
						//Set<Entry<String, Stock>> sameCompStocks = new Set<Entry<String , Stock>>();
						System.out.println("Enter name of company: ");
						searchByCompany(sc.nextLine(), stockMap);
						System.out.println("done");
						break;
					case 4:

						break;
					case 5:

						break;
					case 6:
						System.exit(0);
						break;
					default:
						System.out.println("Enter a valid input:");
						break;
					}
				} catch (StockValidationException SVE) {
					SVE.printStackTrace();
				} catch (DateTimeParseException DTPE) {
					// DTPE.printStackTrace();
					DTPE.getMessage();
				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}
		}
	}
}
