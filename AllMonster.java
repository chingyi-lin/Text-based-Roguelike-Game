import java.util.ArrayList;
/**
 * �ؿ��\��G�C�X�Ҧ����~
 * ���ΡG�H���J��
 * @author Yi
 *
 */

public class AllMonster {
	private ArrayList<Monster> List;
	Slime SlimeRed = new Slime("����v�ܩi", 1);
	Slime SlimeGreen = new Slime("�����", 2);
	Slime SlimeBig = new Slime("�ƾǦ���G��", 3);
	Skull SkullFun = new Skull("���A�u�\", 5);
	Skull SkullKing = new Skull("�u�\��", 7);
	Skull SkullBoss = new Skull("����u�\",8);
	Boss Boss1 = new Boss("���z�c�Y",12);
	Boss Boss2 = new Boss("���", 15);
	public AllMonster(){
		List = new ArrayList<Monster>(10);
		SlimeRed.addSkill(new MeleeAttack("����",2));
		SlimeGreen.addSkill(new MeleeAttack("����",2));
		SlimeBig.addSkill(new MeleeAttack("����",2));
		SkullFun.addSkill(new MeleeAttack("����",2));
		SkullKing.addSkill(new MeleeAttack("����",2));
		SkullBoss.addSkill(new MeleeAttack("����",2));
		Boss1.addSkill(new MeleeAttack("����",2));
		Boss2.addSkill(new MeleeAttack("����",2));
		List.add(SlimeRed);
		List.add(SlimeGreen);
		List.add(SlimeBig);
		List.add(SkullFun);
		List.add(SkullKing);
		List.add(SkullBoss);
		List.add(Boss1);
		List.add(Boss2);
	}
	public ArrayList<Monster> getList(){
		return List;
	}
}
