
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
	 * �o��method�u���Z���ݪ��˳�,�ȥ��n�bplayer�ݤ]�g�˳ƪ�method
	 */
	public void equipe(){
		if(!isEquipped){
			isEquipped = true;
		}
	}
	/**
	 * �o��method�u���Z���ݪ������˳�,�ȥ��n�bplayer�ݤ]�g�����˳ƪ�method
	 */
	public void unequipe(){
		if(isEquipped){
			isEquipped = false;
		}
	}
	public String toString(){
		String equipped;
		if(isEquipped){
			equipped = "�˳Ƥ��C\n";
		}else{
			equipped = "\n";
		}
		if(getNumber() <= 8 && getNumber() < 11){
			return getName()+": ���q�Z���A�˳ƫ�i�H�W�[���z�ˮ`"+damage+"�I�C\n"+equipped;
		}
		else if(getNumber() >= 11 && getNumber() < 14){
			return getName()+": �]�k�Z���A�˳ƫ�i�H�W�[�]�k�ˮ`"+damage+"�I�C\n"+equipped;
		}else{
			return getName()+": �ǩǡA�o�O�@�ӵL�k�Q���Ѫ��Z���A�A�٬O�X����F�L�n�C\n"+equipped;
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
