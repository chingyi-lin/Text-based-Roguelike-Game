
public class Monster extends Creature{
	private int expGain;//玩家可以得到的經驗值
	public Monster() {
		super();
		expGain = 0;
	}
	public Monster(String name,int level) {
		super(name,level);
		expGain = 10+(level-1)*3;//同樣隨便的公式
	}
	public Monster(Monster m){
		super(m);
		expGain = 10+(level-1)*3;
	}
	/**
	 * Check if the Monster is defeated. If true, add exp to the Player and drop items.
	 * @param enemy
	 * @return true if hp = 0, false otherwise.
	 */
	public void defeatedBy(Player enemy){
		if(hp == 0){
			enemy.addExp(expGain);
			enemy.addItem(this.DropItem());
			System.out.println(this.getName()+"被"+enemy.getName()+"擊敗了");
			System.out.println(enemy.getName()+"獲得"+expGain+"點經驗值");
		}else{
		}
	}
	/**
	 * 設定各物品掉落率
	 * @return
	 */
	public Item DropItem(){
		AllRestorePotion a = new AllRestorePotion();
		AllWeapon b = new AllWeapon();
		Dice IDice = new Dice(100);
		Dice d2 = new Dice(2);
		int IDiceValue = IDice.dice();
		if(level<5){
			if(IDiceValue>=89){//掉落率10%
				if(IDiceValue<92)
					return a.getList().get(d2.dice()-1);
				else if(IDiceValue<95)
					return a.getList().get(d2.dice()+2);
				else if(IDiceValue<98)
					return b.getList().get(d2.dice()-1);
				else
					return b.getList().get(d2.dice()+2);
			}
			else
				return null;
		}
		else if(level<10){
			if(IDiceValue>96){//掉落率10%
				if(IDiceValue==97)
					return a.getList().get(2);
				else if(IDiceValue==98)
					return a.getList().get(5);
				else if(IDiceValue==99)
					return b.getList().get(2);
				else
					return b.getList().get(5);
			}
			else
				return null;
		}
		else{
			if(IDiceValue> 98)//掉落率2%
				return a.getList().get(6);
			else
				return null;
		}
	}
}