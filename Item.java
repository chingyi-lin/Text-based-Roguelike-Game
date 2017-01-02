
public class Item {
	private String name;
	private int number;
	private int amount;
	//在hash map 中的起始編號
	public static final int RESTOREPOTION = 7;
	public static final int WEAPON = 13;
	
	public Item(){
		name = null;
		number = 0;
		amount = 0;
	}
	public Item(String Name, int Number, int Amount){
		name = Name;
		number = Number;
		amount = Amount;
	}
	public int getNumber(){
		return number;
	}
	public int getAmount(){
		return amount;
	}
	public String getName(){
		return name;
	}
	public void setAmount(int Amount){
		amount = Amount;
	}
	public int getRestorValue(){
		return 0;	
	}
}
