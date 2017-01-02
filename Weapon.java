
public class Weapon extends Item {
	private boolean isEquipped;
	private int damage;
	public Weapon(){
		super();
	}
	public Weapon(String Name, int Number, int Amount, int Damage){
		super(Name, Number, Amount);
		damage = Damage;
	}
	/**
	 * 這個method只做武器端的裝備,務必要在player端也寫裝備的method
	 */
	public void equipe(){
		if(!isEquipped){
			isEquipped = true;
		}
	}
	/**
	 * 這個method只做武器端的取消裝備,務必要在player端也寫取消裝備的method
	 */
	public void unequipe(){
		if(isEquipped){
			isEquipped = false;
		}
	}
	public String toString(){
		String equipped;
		if(isEquipped){
			equipped = "裝備中。\n";
		}else{
			equipped = "\n";
		}
		if(getNumber() <= 8 && getNumber() < 11){
			return getName()+": 普通武器，裝備後可以增加物理傷害"+damage+"點。\n"+equipped;
		}
		else if(getNumber() >= 11 && getNumber() < 14){
			return getName()+": 魔法武器，裝備後可以增加魔法傷害"+damage+"點。\n"+equipped;
		}else{
			return getName()+": 怪怪，這是一個無法被辨識的武器，你還是趁早丟了他好。\n"+equipped;
		}
	}
	/**
	 * @return the isEquipped
	 */
	public boolean isEquipped() {
		return isEquipped;
	}
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	

}
