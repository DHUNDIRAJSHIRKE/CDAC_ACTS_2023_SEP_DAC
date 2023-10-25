package StockTradingService;
import java.time.LocalDate;
public class Stock {
	private static int stockIdCount=100;
	private int stockId;
	private String stockName;
	private String companyName;
	private double price;
	private LocalDate closingDate;
	private int quantity;
	
	public Stock( String stockName, String companyName, double price, LocalDate closingDate, int quantity) {
		this.stockId = ++stockIdCount;
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "[ StockID: "+stockId+" Stock Name: "+stockName+" Company Name: "+companyName+" Price: "+price+" Closing Date: "+closingDate+" Quantity: "+quantity+" ]";
	}
	public int getStockId() {
		return this.stockId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
