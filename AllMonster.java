import java.util.ArrayList;
/**
 * ¥Ø¿ý¥\¯à¡G¦C¥X©Ò¦³©ÇÃ~
 * À³¥Î¡GÀH¾÷¹J©Ç
 * @author Yi
 *
 */

public class AllMonster {
	private ArrayList<Monster> List;
	Slime SlimeRed = new Slime("¬õ¦â¥vµÜ©i", 1);
	Slime SlimeGreen = new Slime("ºñ¦â³Âò­", 2);
	Slime SlimeBig = new Slime("¤Æ¾Ç¦â¯ÀªG­á", 3);
	Skull SkullFun = new Skull("Âø­A¾uÅ\", 5);
	Skull SkullKing = new Skull("¾uÅ\¤ý", 7);
	Skull SkullBoss = new Skull("À£¹ë¾uÅ\",8);
	Boss Boss1 = new Boss("¤ö«z¨cÀY",12);
	Boss Boss2 = new Boss("°ê¤ý", 15);
	public AllMonster(){
		List = new ArrayList<Monster>(10);
		SlimeRed.addSkill(new MeleeAttack("¼²À»",2));
		SlimeGreen.addSkill(new MeleeAttack("¼²À»",2));
		SlimeBig.addSkill(new MeleeAttack("¼²À»",2));
		SkullFun.addSkill(new MeleeAttack("¼²À»",2));
		SkullKing.addSkill(new MeleeAttack("¼²À»",2));
		SkullBoss.addSkill(new MeleeAttack("¼²À»",2));
		Boss1.addSkill(new MeleeAttack("¼²À»",2));
		Boss2.addSkill(new MeleeAttack("¼²À»",2));
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
