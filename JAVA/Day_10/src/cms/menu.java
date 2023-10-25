package cms;

public enum menu {
	IDLI(30),SAMOSA(15),POHE(20),DOSA(50),MEDUVADA(40);
	private int price;
	private menu(int price) {
		this.price= price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override 
	public String toString() {
		return name()+" :"+price+" rs";
	}
	
}
