import java.util.ArrayList;


public class Creature {
	private String name;//�W��
	int hp;
	int mp;
	int level;
	private int meleeDmg;
	private int magicDmg;
	private int armor;
	private ArrayList<Skill> skill = new ArrayList<Skill>();
	
	public Creature(){
		name = null;
		hp = 0;
		mp = 0;
		level = 0;
	}
	public Creature(String name){
		this();
		this.name = name;
	}
	public Creature(String name, int level){
		this.name = name;
		this.level = level;
		hp = getMaxHp();
		mp = getMaxMp();
	}
	public Creature(Creature c){
		this.name = c.getName();
		this.level = c.getLevel();
		hp = getMaxHp();
		mp = getMaxMp();
	}
	/**
	 * Calculate max hp by level
	 * @param level
	 * @return max hp
	 */
	public int getMaxHp(){
		return 20+level*5;	
	}
	/**
	 * Calculate max mp by level
	 * @param level
	 * @return max mp
	 */
	public int getMaxMp(){
		return 20+level*5;	
	}
	/**
	 * @return the hp
	 */
	public int getHp(){
		return hp;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @return the mp
	 */
	public int getMp() {
		return mp;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		if(hp > 0){
			this.hp = hp;
		}else
			this.hp = 0;
	}
	/**
	 * @param mp the mp to set
	 */
	public void setMp(int mp) {
		if(mp > 0){
			this.mp = mp;
		}else
			this.mp = 0;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the meleeDmg
	 */
	public int getMeleeDmg() {
		return meleeDmg;
	}
	/**
	 * @return the magicDmg
	 */
	public int getMagicDmg() {
		return magicDmg;
	}
	/**
	 * @return the skill
	 */
	public ArrayList<Skill> getSkill() {
		return skill;
	}
	public String attack(Skill s,Creature enemy){
		//�P�_���S���o�ӧޯ઺�����ڭn�浹UI�h��
		Dice d1 = new Dice();
		int damage = 0;
		if(enemy!=null){
			if(s instanceof MagicAttack){
				mp -= ((MagicAttack) s).getMpConsume();
				damage = magicDmg*d1.dice()+s.getBasicDamage()-enemy.armor;//�p�⤽���W�H�K����(����)
			}else if(s instanceof MeleeAttack){
				damage = meleeDmg*d1.dice()+s.getBasicDamage()- enemy.armor;
			}else{
				damage = d1.dice()+s.getBasicDamage()-enemy.armor;
			}
			enemy.setHp(enemy.getHp()-damage);
			return (name+"�ϥX�F"+s.getName()+", "+enemy.getName()+"����F"+damage+"�I�ˮ`�I");
		}else
			return (name+"������a��M�Q�n�����Ů�A\n���n�A��M�o�{�o�O�@��������Ʊ��A\n�~�S���եծ��O��O�C");
	}
	/**
	 * @param meleeDmg the meleeDmg to set
	 */
	public void setMeleeDmg(int meleeDmg) {
		this.meleeDmg = meleeDmg;
	}
	/**
	 * @param magicDmg the magicDmg to set
	 */
	public void setMagicDmg(int magicDmg) {
		this.magicDmg = magicDmg;
	}
	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(ArrayList<Skill> skill) {
		this.skill = new ArrayList<Skill>(skill);
	}
	/**
	 * Add a skill to list
	 * @param s the skill to add
	 */
	public void addSkill(Skill s){
		skill.add(s);
	}
	public String toString(){
		return name+": \nLv.:"+level+"  Hp:"+hp+"  Mp:"+mp;
	}
	
}
