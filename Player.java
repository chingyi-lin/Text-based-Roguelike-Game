import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Creature {
	private int exp;
	private HashMap<Integer, Item> item;

	/**
	 * Default constructor
	 */
	public Player() {
		super();
		exp = 0;
		item = new HashMap<Integer, Item>();
		setSkill(new ArrayList<Skill>());
	}

	/**
	 * Create a new Player by name
	 * 
	 * @param name
	 */
	public Player(String name) {
		super(name, 0);
		item = new HashMap<Integer, Item>();
		setSkill(new ArrayList<Skill>());
	}

	public Player(String name, int level) {
		super(name, level);
		item = new HashMap<Integer, Item>();
		setSkill(new ArrayList<Skill>());
	}

	/**
	 * Return the value of exp
	 * 
	 * @return exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * Add new exp value to exp
	 * 
	 * @param exp
	 */
	public void addExp(int newExp) {
		exp += newExp;
	}

	/**
	 * @return the item
	 */
	public HashMap<Integer, Item> getItem() {
		return item;
	}
	public Monster FindMonster(){
		AllMonster m = new AllMonster();
		Dice d2 = new Dice(2); 
		if(level<3)
			return m.getList().get(d2.dice()-1);
		else if(level<5)
			return m.getList().get(d2.dice());
		else if(level<11)
			return m.getList().get(d2.dice()+2);
		else
			return m.getList().get(d2.dice()+3);
	}

	/**
	 * �o�쪫�~
	 * 
	 * @param I
	 */
	public void addItem(Item I) {
		if(I != null){
			if (item.containsKey(I.getNumber())) {
				Item temp = item.remove(I.getNumber());
				temp.setAmount(temp.getAmount() + 1);
				item.put(I.getNumber(), temp);
			} else
				item.put(I.getNumber(), I);
		}
	}

	/**
	 * �ϥΪ��~
	 * 
	 * @param I
	 */
	public String useRestoreItem(Item I) {
		Item temp;
		temp = item.remove(I.getNumber());
		if (temp.getAmount() - 1 > 0) {
			temp.setAmount(temp.getAmount() - 1);
			item.put(I.getNumber(), temp);
		}
		if (I.getNumber() < 3) {
			if (this.getHp() + I.getRestorValue() <= this.getMaxHp()) {
				super.hp += I.getRestorValue();
				return "�w�ϥΪ��~�C��_�ͩR" + I.getRestorValue() + "�I\n" + "�ثe�ͩR�ȡG"
						+ this.getHp();
			} else {
				int diff = this.getMaxHp() - this.getHp();
				super.hp = this.getMaxHp();
				return "�w�ϥΪ��~�C��_�ͩR" + diff + "�I\n" + "�ثe�ͩR�ȡG" + this.getHp();
			}
		} else if (I.getNumber() == 3) {
			int diff = this.getMaxHp() - this.getHp();
			super.hp = this.getMaxHp();
			return "�w�ϥΪ��~�C��_�ͩR" + diff + "�I\n" + "�ثe�ͩR�ȡG" + this.getHp();
		} else if (I.getNumber() < 6) {
			if (this.getMp() + I.getRestorValue() <= this.getMaxMp()) {
				super.mp += I.getRestorValue();
				return "�w�ϥΪ��~�C��_�]�O" + I.getRestorValue() + "�I\n" + "�ثe�]�O�ȡG"
						+ this.getMp();
			} else {
				int diff = this.getMaxMp() - this.getMp();
				super.mp = this.getMaxMp();
				return "�w�ϥΪ��~�C��_�]�O" + diff + "�I\n" + "�ثe�]�O�ȡG" + this.getMp();
			}
		} else if (I.getNumber() == 6) {
			int diff = this.getMaxMp() - this.getMp();
			super.mp = this.getMaxMp();
			return "�w�ϥΪ��~�C��_�ͩR" + diff + "�I\n" + "�ثe�]�O�ȡG" + this.getMp();
		} else if (I.getNumber() == 7) {
			super.mp = this.getMaxMp();
			super.hp = this.getMaxHp();
			return "�w�ϥΪ��~�C�w������_�ͩR���]�O�C\n�ثe�ͩR�ȡG" + this.getHp() + "\n�ثe�]�O�ȡG"
					+ this.getMp();
		} else
			return "There is somthing wrong when you're using item";

	}
	/**
	 * �˳ƪ��~
	 * @param weapon
	 * @return
	 */
	public String equipeWeapon(Item weapon){
		//���S���o�ӪZ���]�O�浹UI
		Weapon w = (Weapon)weapon;
		if(!w.isEquipped()){
			for(int i = 8; i < 14; i++){
				Weapon t;
				if(item.get(i) instanceof Weapon){
					t = (Weapon)item.get(i);
					t.unequipe();
				}
			}
			w.equipe();
			if(w.getNumber() <= 8 && w.getNumber() < 11){
				this.setMeleeDmg(this.getMeleeDmg()+w.getDamage());
				return "�˳�"+w.getName()+", ���z�ˮ` +" + w.getDamage();
			}
			else if(w.getNumber() <=11 && w.getNumber() < 14){
				this.setMagicDmg(this.getMagicDmg()+w.getDamage());
				return "�˳�"+w.getName()+", �]�k�ˮ` +" + w.getDamage();
			}else{
				return "�ǩǡA�o�O�@�ӵL�k�Q���Ѫ��Z���A�A�٬O�X����F�L�n�C";
			}
		}else{
			return w.getName()+"�w�g�Q�˳ƤF";
		}
	}

	/**
	 * �b�C�Ӱʧ@���������,�P�_���a�����p
	 */
	public void refresh() {
		if (hp == 0) {
			System.out.println("You died.TAT");
		} else if (exp >= (level + 1) * 10) {
			levelUp();
			System.out.println("Level up!");
		}
	}

	/**
	 * �ɯ�
	 */
	public void levelUp() {
		level += 1;
		hp = getMaxHp();
		mp = getMaxMp();
	}
	/**
	 * �����˳ƪ��~
	 * @param weapon
	 * @return
	 */
	public String unequipeWeapon(Item weapon){
		//���S���o�ӪZ���]�O�浹UI
		Weapon w = (Weapon)weapon;
		if(w.isEquipped()){
			w.unequipe();
			if(w.getNumber() >= 8 && w.getNumber() < 11){
				this.setMeleeDmg(this.getMeleeDmg()-w.getDamage());
				return "�����˳�"+w.getName()+", ���z�ˮ` -" + w.getDamage();
			}
			else if(w.getNumber() >=11 && w.getNumber() < 14){
				this.setMagicDmg(this.getMagicDmg()+w.getDamage());
				return "�����˳�"+w.getName()+", �]�k�ˮ` -" + w.getDamage();
			}else{
				return "�ǩǡA�o�O�@�ӵL�k�Q���Ѫ��Z���A�A�٬O�X����F�L�n�C";
			}
		}else{
			return w.getName()+"�S���Q�˳�";
		}
	}
	public String disposeItem(Item I){
		item.remove(I.getNumber());
		return "�A�N"+I.getName()+"���b�a�c���@���C\n�h�i����!\n�p�G���O�b�a�c�A���F���K�w�i�H����򤭡I";
	}
}
