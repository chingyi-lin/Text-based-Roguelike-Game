import java.util.ArrayList;
import java.util.Scanner;


public class test {
	public static void main(String[] args){
		Fighter pikachu = new Fighter("皮卡丘",1);
		Monster Slime = new Monster("史萊姆",5);
		pikachu.addSkill(new MeleeAttack("電光一閃",2));
		pikachu.addSkill(new MagicAttack("電擊",2,3));
		pikachu.setMagicDmg(3);
		pikachu.setMeleeDmg(2);
		pikachu.setArmor(2);
		Slime.setArmor(1);
		Slime.setMagicDmg(0);
		Slime.setMeleeDmg(1);
		ArrayList<Skill> s2= new ArrayList<Skill>(2);
		s2.add(new MeleeAttack("衝撞",2));
		Slime.setSkill(s2);
		Scanner keyboard = new Scanner(System.in);
		pikachu.refresh();
		System.out.println(pikachu);
		System.out.println("野生的"+Slime.getName()+"出現了!");
		System.out.println(Slime);
		int choice = 0;
		do{ System.out.println("1. 攻擊 2. 逃跑");
			choice = keyboard.nextInt();
			if(choice == 2)
				System.out.println("「嘿嘿嘿，想跑？哪有這麼容易？」史萊姆奸笑著堵住了你的去路。");
		}while(choice == 2);
		while(pikachu.getHp()!=0 && Slime.getHp()!=0){
			for(int i =0; i < pikachu.getSkill().size(); i++){
				System.out.println((i+1)+". "+pikachu.getSkill().get(i).getName());
			}
			choice = keyboard.nextInt();
			pikachu.attack(pikachu.getSkill().get(choice-1), Slime);
			System.out.println(Slime);
			if(Slime.getHp()!=0){
				Slime.attack(Slime.getSkill().get(0), pikachu);
				pikachu.refresh();
				System.out.println(pikachu);
			}else{
				Slime.defeatedBy(pikachu);
				pikachu.refresh();
				System.out.println(pikachu);
			}
		}
	}

}
