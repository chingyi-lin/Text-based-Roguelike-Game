
public class Boss extends Monster{
	public Boss() {
		super();
		addSkill(new MeleeAttack("�J�ýļ�",4));
		addSkill(new MagicAttack("BOSS������(?)",4,4));
		addSkill(new MagicAttack("�U�V���~",3,2));
	}
	public Boss(String name, int level) {
		super(name, level);
		addSkill(new MeleeAttack("�J�ýļ�",4));
		addSkill(new MagicAttack("BOSS������(?)",4,4));
		addSkill(new MagicAttack("�U�V���~",3,2));
	}
}
