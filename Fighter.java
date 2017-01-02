import java.util.HashMap;


public class Fighter extends Player {
	private static final Skill lv0 = new MeleeAttack("·iÀ»",5);
	private static final Skill lv3 = new MeleeAttack("´§¬å",7);
	private static final Skill lv5 = new MeleeAttack("",2);
	private static final Skill lv7 = new MeleeAttack("¼««ãªºÅK®±(?",8);
	private static final Skill lv10 = new MeleeAttack("",2);
	private static final Skill lv15 = new MagicAttack("¨g¾Ô¤h¤§«ã",5,10);
	private static final HashMap<Integer,Skill> talentSkills = new HashMap<Integer,Skill>();
	
	public Fighter(){
		super();
		addSkill(lv0);
		talentSkills.put(0, lv0);
		talentSkills.put(3, lv3);
		talentSkills.put(5, lv5);
		talentSkills.put(7, lv7);
		talentSkills.put(10, lv10);
		talentSkills.put(15, lv15);
	}
	public Fighter(String name){
		super(name);
		addSkill(lv0);
		talentSkills.put(0, lv0);
		talentSkills.put(3, lv3);
		talentSkills.put(5, lv5);
		talentSkills.put(7, lv7);
		talentSkills.put(10, lv10);
		talentSkills.put(15, lv15);
	}
	public Fighter(String name, int level){
		super(name,level);
		addSkill(lv0);
		talentSkills.put(0, lv0);
		talentSkills.put(3, lv3);
		talentSkills.put(5, lv5);
		talentSkills.put(7, lv7);
		talentSkills.put(10, lv10);
		talentSkills.put(15, lv15);
	}
	public void levelUp(){
		super.levelUp();
		setMeleeDmg(getMeleeDmg()+1);
		if(talentSkills.get(level)!= null){
			addSkill(talentSkills.get(level));
		}
	}
}
