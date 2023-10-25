package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import StockExc.StockValidationException;
import StockTradingService.Stock;

public class StockUtils {
	public static HashMap<String, Stock> populateHashMap() {
		HashMap<String, Stock> EmptyMap = new HashMap<>();
		EmptyMap.put("Apple Inc.", new Stock("Apple", "Apple Inc.", 1234.56, LocalDate.parse("2014-05-03"), 50));
		EmptyMap.put("TATA MOTORS Ltd.",
				new Stock("TATA MOTORS", "TATA MOTORS Ltd.", 56.4321, LocalDate.parse("2016-11-09"), 70));
		EmptyMap.put("Hewlett Packard Ltd.",
				new Stock("Hewlett Packard", "Hewlett Packard Ltd.", 111.22, LocalDate.parse("2007-01-08"), 20));
		return EmptyMap;
	}

	public static Stock validateAllInputs(String stockId, String stockName, String companyName, double price,
			String unchecedClosingDate, int quantity, HashMap<String, Stock> stocks)
			throws StockValidationException, DateTimeParseException {
		// checkForDuplicates(stockId,stocks);
		LocalDate checkedDate = parseAndValidateDate(unchecedClosingDate);
		Stock checkedStock = new Stock(stockName, companyName, price, checkedDate, quantity);
		return checkedStock;

	}

	public static LocalDate parseAndValidateDate(String unchecedClosingDate)
			throws DateTimeParseException, StockValidationException {
		LocalDate checkedDate = LocalDate.parse(unchecedClosingDate);
		if (checkedDate.isBefore(LocalDate.now())) {
			throw new StockValidationException("Closing Date should be a future date");
		}
		return checkedDate;
	}

	/*
	 * public static void checkForDuplicates(String stockId,HashMap<String,Stock>
	 * stocks) throws StockValidationException { if(stocks.containsKey(stockId)) {
	 * throw new StockValidationException("Stock ID already Exists"); }
	 * System.out.println("No Duplicates found!"); }
	 */
	public static void searchByCompany(String compName, HashMap<String, Stock> stocks) throws StockValidationException {
		// stocks
		//System.out.println("Come");
		//Collection<Stock> allCompStocks = new ArrayList<Stock>();
		
		
		System.out.println(compName);
		//System.out.println(allCompStocks);
		//Collection<Stock> sameCompStocks = new ArrayList<Stock>();
		//System.out.println(sameCompStocks);
		//allCompStocks = stocks.values();
		//System.out.println(stocks.containsKey("Apple Inc."));
		List<Stock> stockList = new ArrayList<Stock>();
		Set<Map.Entry<String, Stock>>  stockEntrySet = stocks.entrySet();
	//	Iterator<Map.Entry<String, Stock>> iterator= stockEntrySet.iterator();
		//stockEntrySet.contains(compName);
		
		
			for(Entry<String, Stock> s : stockEntrySet) {
				System.out.println("1111");
				Stock value = s.getValue();
				
				if(value.getCompanyName().equals("TATA MOTORS Ltd.")) {
					System.out.println("2222");
					stockList.add(value);
				}
			}
			
			for(Stock ss : stockList) {
				System.out.println("333333");
				System.out.println(ss);
			}
			
			
		
		
		/*
		 * while(iterator.hasNext()) { Map.Entry<String, Stock> entry = iterator.next();
		 * Stock stock = entry.getValue(); if(stock.getCompanyName().equals(compName)) {
		 * stockList.add(stock); }
		 * 
		 * }
		 */
	
		
		
		/*
		 * if (stocks.containsKey(compName)) {
		 * 
		 * throw new StockValidationException("This Company doesn't have any Stocks");
		 * 
		 * } else { //ArrayList<Stock> sameCompStocks = new ArrayList<>();
		 * //Set<Entry<String, Stock>> sameCompStocks = stocks.entrySet();
		 * System.out.println("else"); for (Stock s : allCompStocks) {
		 * System.out.println(s.getCompanyName().equals(compName)); if (
		 * s.getCompanyName().equals(compName)) { System.out.println("allCompStocks");
		 * sameCompStocks.add(s); } } } for(Stock s : sameCompStocks) {
		 * System.out.println(s); }
		 */
		//return sameCompStocks;
	}
}
