
public class Boss extends Monster{
	public Boss() {
		super();
		addSkill(new MeleeAttack("­J¶Ã½Ä¼²",4));
		addSkill(new MagicAttack("BOSSªº«ÂÀ£(?)",4,4));
		addSkill(new MagicAttack("¸U¤V¥ú¨~",3,2));
	}
	public Boss(String name, int level) {
		super(name, level);
		addSkill(new MeleeAttack("­J¶Ã½Ä¼²",4));
		addSkill(new MagicAttack("BOSSªº«ÂÀ£(?)",4,4));
		addSkill(new MagicAttack("¸U¤V¥ú¨~",3,2));
	}
}
