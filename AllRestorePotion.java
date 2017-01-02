import java.util.ArrayList;
/**
 * 目錄功能：列出所有恢復藥水。
 * 應用：實作亂數掉落物品這件事。
 * @author Yi
 */

public class AllRestorePotion {
	private ArrayList<Item> List;
	RestorePotion HPPotion1 = new RestorePotion("恢復劑(S)", 1, 1,30);
	RestorePotion HPPotion2 = new RestorePotion("恢復劑(M)", 2, 1,100);
	RestorePotion HPPotion3 = new RestorePotion("恢復劑(L)", 3, 1,0);
	RestorePotion MPPotion1 = new RestorePotion("活絡散(S)", 4, 1,30);
	RestorePotion MPPotion2 = new RestorePotion("活絡散(M)", 5, 1,100);
	RestorePotion MPPotion3 = new RestorePotion("活絡散(L)", 6, 1,0);
	RestorePotion LifeFruit = new RestorePotion("生命之果",7,1,0);
	public AllRestorePotion(){
		List = new ArrayList<Item>(10);
		List.add(HPPotion1);
		List.add(HPPotion2);
		List.add(HPPotion3);
		List.add(MPPotion1);
		List.add(MPPotion2);
		List.add(MPPotion3);
		List.add(LifeFruit);
	}
	public ArrayList<Item> getList(){
		return List;
	}
}
