import java.util.ArrayList;
/**
 * �ؿ��\��G�C�X�Ҧ��Z���C
 * ���ΡG��@�üƱ������~�o��ơC
 * @author Anne Chao
 */
public class AllWeapon {
	private ArrayList<Item> List;
	Weapon Dagger = new Weapon("�P��", 8, 1, 1);
	Weapon Sword = new Weapon("�j�M", 9, 1, 3);
	Weapon Excalibur = new Weapon("���̤��C", 10, 1, 5);
	Weapon Wand1 = new Weapon("���q����K", 11, 1, 1);
	Weapon Wand2 = new Weapon("�j�������", 12, 1, 3);
	Weapon Wand3 = new Weapon("���F�k��", 13, 1, 5);
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
