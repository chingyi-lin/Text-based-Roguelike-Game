import java.util.ArrayList;
/**
 * 目錄功能：列出所有武器。
 * 應用：實作亂數掉落物品這件事。
 * @author Anne Chao
 */
public class AllWeapon {
	private ArrayList<Item> List;
	Weapon Dagger = new Weapon("匕首", 8, 1, 1);
	Weapon Sword = new Weapon("大刀", 9, 1, 3);
	Weapon Excalibur = new Weapon("王者之劍", 10, 1, 5);
	Weapon Wand1 = new Weapon("普通的樹枝", 11, 1, 1);
	Weapon Wand2 = new Weapon("強韌的木杖", 12, 1, 3);
	Weapon Wand3 = new Weapon("火靈法杖", 13, 1, 5);
	public AllWeapon(){
		List = new ArrayList<Item>(10);
		List.add(Dagger);
		List.add(Sword);
		List.add(Excalibur);
		List.add(Wand1);
		List.add(Wand2);
		List.add(Wand3);
	}
	public ArrayList<Item> getList(){
		return List;
	}
	
}
