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
	 * 得到物品
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
	 * 使用物品
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
				return "已使用物品。恢復生命" + I.getRestorValue() + "點\n" + "目前生命值："
						+ this.getHp();
			} else {
				int diff = this.getMaxHp() - this.getHp();
				super.hp = this.getMaxHp();
				return "已使用物品。恢復生命" + diff + "點\n" + "目前生命值：" + this.getHp();
			}
		} else if (I.getNumber() == 3) {
			int diff = this.getMaxHp() - this.getHp();
			super.hp = this.getMaxHp();
			return "已使用物品。恢復生命" + diff + "點\n" + "目前生命值：" + this.getHp();
		} else if (I.getNumber() < 6) {
			if (this.getMp() + I.getRestorValue() <= this.getMaxMp()) {
				super.mp += I.getRestorValue();
				return "已使用物品。恢復魔力" + I.getRestorValue() + "點\n" + "目前魔力值："
						+ this.getMp();
			} else {
				int diff = this.getMaxMp() - this.getMp();
				super.mp = this.getMaxMp();
				return "已使用物品。恢復魔力" + diff + "點\n" + "目前魔力值：" + this.getMp();
			}
		} else if (I.getNumber() == 6) {
			int diff = this.getMaxMp() - this.getMp();
			super.mp = this.getMaxMp();
			return "已使用物品。恢復生命" + diff + "點\n" + "目前魔力值：" + this.getMp();
		} else if (I.getNumber() == 7) {
			super.mp = this.getMaxMp();
			super.hp = this.getMaxHp();
			return "已使用物品。已完全恢復生命及魔力。\n目前生命值：" + this.getHp() + "\n目前魔力值："
					+ this.getMp();
		} else
			return "There is somthing wrong when you're using item";

	}
	/**
	 * 裝備物品
	 * @param weapon
	 * @return
	 */
	public String equipeWeapon(Item weapon){
		//有沒有這個武器也是交給UI
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
				return "裝備"+w.getName()+", 物理傷害 +" + w.getDamage();
			}
			else if(w.getNumber() <=11 && w.getNumber() < 14){
				this.setMagicDmg(this.getMagicDmg()+w.getDamage());
				return "裝備"+w.getName()+", 魔法傷害 +" + w.getDamage();
			}else{
				return "怪怪，這是一個無法被辨識的武器，你還是趁早丟了他好。";
			}
		}else{
			return w.getName()+"已經被裝備了";
		}
	}

	/**
	 * 在每個動作結束後執行,判斷玩家的狀況
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
	 * 升級
	 */
	public void levelUp() {
		level += 1;
		hp = getMaxHp();
		mp = getMaxMp();
	}
	/**
	 * 取消裝備物品
	 * @param weapon
	 * @return
	 */
	public String unequipeWeapon(Item weapon){
		//有沒有這個武器也是交給UI
		Weapon w = (Weapon)weapon;
		if(w.isEquipped()){
			w.unequipe();
			if(w.getNumber() >= 8 && w.getNumber() < 11){
				this.setMeleeDmg(this.getMeleeDmg()-w.getDamage());
				return "取消裝備"+w.getName()+", 物理傷害 -" + w.getDamage();
			}
			else if(w.getNumber() >=11 && w.getNumber() < 14){
				this.setMagicDmg(this.getMagicDmg()+w.getDamage());
				return "取消裝備"+w.getName()+", 魔法傷害 -" + w.getDamage();
			}else{
				return "怪怪，這是一個無法被辨識的武器，你還是趁早丟了他好。";
			}
		}else{
			return w.getName()+"沒有被裝備";
		}
	}
	public String disposeItem(Item I){
		item.remove(I.getNumber());
		return "你將"+I.getName()+"丟棄在地牢的一角。\n多可惜啊!\n如果不是在地牢，那東西鐵定可以賣到兩毛五！";
	}
}
