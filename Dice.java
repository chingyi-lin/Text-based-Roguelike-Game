
public class Dice {
	int side;
	/**
	 * Default constructor creates 6-sided dice
	 */
	public Dice(){
		side = 6;
	}
	/**
	 * ¦h­±»ë
	 * @param side
	 */
	public Dice(int side){
		this.side = side;
	}
	public int dice(){
		return (int)Math.ceil(Math.random()*side);
	} 
	public static void main(String[] args){
		Dice d1 = new Dice();
		for(int i = 0;i<10;i++){
			System.out.println(d1.dice());
		}
	}
	
}
