import java.util.ArrayList;
/**
 * �ؿ��\��G�C�X�Ҧ���_�Ĥ��C
 * ���ΡG��@�üƱ������~�o��ơC
 * @author Yi
 */

public class AllRestorePotion {
	private ArrayList<Item> List;
	RestorePotion HPPotion1 = new RestorePotion("��_��(S)", 1, 1,30);
	RestorePotion HPPotion2 = new RestorePotion("��_��(M)", 2, 1,100);
	RestorePotion HPPotion3 = new RestorePotion("��_��(L)", 3, 1,0);
	RestorePotion MPPotion1 = new RestorePotion("������(S)", 4, 1,30);
	RestorePotion MPPotion2 = new RestorePotion("������(M)", 5, 1,100);
	RestorePotion MPPotion3 = new RestorePotion("������(L)", 6, 1,0);
	RestorePotion LifeFruit = new RestorePotion("�ͩR���G",7,1,0);
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
