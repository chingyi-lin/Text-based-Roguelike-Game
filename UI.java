import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class UI implements ActionListener{
	private Frame window;
	private Button right, left, forward, backward;//��V��
	private Button attack, item, move, save, read;
	private Panel top, med, down;
	private TextArea msg;
	private graph map;//�a��
	private static Player player;
	private Monster monster/* = new Monster("��e���Ǫ�",1)*/;
	private static Player player1 = new Player("Hero",1);//���ե�player
	private static int Holditem;//���item�s��
	private boolean OnFightFlag = false;
	//Menu
	private Panel menu;
	private Button end;
	private Button restart;
	//Item panel
	private Panel itemPanel;
	//Attack panel
	private Panel attackPanel;
	//Move panel
	private Panel movePanel;
	//Item Choice panel
	private Panel itemchoicePanel;
	//Weapon Choice panel
	private Panel WeaponChoicePanel;
	private CardLayout cardlayout = new CardLayout();
	//Weapon listener
	private ActionListener WeaponListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if(command.equals("�P��")){
					Holditem = 8;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("�j�M")){
					Holditem = 9;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("���̤��C")){
					Holditem = 10;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("���q����K")){
					Holditem = 11;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("�j�������")){
					Holditem = 12;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("���F�k��")){
					Holditem = 13;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("�˳�")){
					msg.setText(player.equipeWeapon(player.getItem().get(Holditem)));
					cardlayout.show(down,"item");
				}else if(command.equals("�����˳�")){
					msg.setText(player.unequipeWeapon(player.getItem().get(Holditem)));
					cardlayout.show(down,"item");
				}else if(command.equals("���")){
					msg.setText(player.disposeItem(player.getItem().get(Holditem)));
					launchItemPanel();
					down.add("item", itemPanel);
					cardlayout.show(down,"item");
				}
			}
		};
	ActionListener RestorePotionLinstener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String button = e.getActionCommand();
			if(button.equals("��_��(S)")){
				Holditem = 1;
				msg.setText(player.getItem().get(1).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("��_��(S)")){
				Holditem = 1;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("��_��(M)")){
				Holditem = 2;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("��_��(L)")){
				Holditem = 3;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("������(S)")){
				Holditem = 4;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("������(M)")){
				Holditem = 5;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("������(L)")){
				Holditem = 6;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("�ͩR���G")){
				Holditem = 7;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("�ϥΪ��~")){
				msg.setText(player.useRestoreItem(player.getItem().get(Holditem)));
				launchItemPanel();
				down.add("item", itemPanel);
				if(OnFightFlag){
					cardlayout.show(down, "attack");
					fight();
				}else{
					cardlayout.show(down, "item");
				}
			}
			else if(button.equals("��ܨ�L���~")){
				cardlayout.show(down, "item");
			}
		}
	};
	
	public UI(){
		window = new Frame("Maze");
		right = new Button("East");
		left = new Button("West");
		forward = new Button("North");
		backward = new Button("South");
		attack = new Button("Attack");
		item = new Button("Item");
		save = new Button("Save");
		read = new Button("Read");
		move = new Button("Move");
		msg = new TextArea();
		top = new Panel();
		med = new Panel();
		down = new Panel();
	}
	
	public void launchFrame(){
		map = new graph();
		
		window.setLayout(null);
		CreatePlayer();
		
		msg.setText(map.now.description());
		
		top.setLayout(new BorderLayout());
		top.add(msg, BorderLayout.NORTH);
		top.setBounds(8, 30, 300, 150);
		
		med.setLayout(new FlowLayout());
		med.add(attack);
		attack.addActionListener(this);
		med.add(item);
		item.addActionListener(RestorePotionLinstener);
		med.add(move);
		move.addActionListener(this);
		med.add(save);
		save.addActionListener(this);
		med.add(read);
		read.addActionListener(this);
		med.setBounds(8,180,300,30);
		
		
		down.setLayout(cardlayout);
		launchMovePanel();
		launchMenu();
		launchAttackPanel();
		launchItemPanel();
		down.add("move",movePanel);
		down.add("attack", attackPanel);
		down.add("item", itemPanel);
		down.add("menu",menu);
		down.setBounds(8,210,300,190);
		
		window.add(top);
		window.add(med);
		window.add(down);
		window.setSize(300,400);
		window.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		try{
			//���U��V��ɲ��ʨ�t�@�өж�
			if(button.equals("North")){
				map.now = map.now.to("N");
				if(map.now.getMonsterAppear()){
					monster = new Monster(player.FindMonster());
					msg.setText(monster.getName()+"�X�{�A���h�n�N�a�צ�F�h���C");
					OnFightFlag = true;
					cardlayout.show(down, "attack");
					//while (fight()) {};
				}
				else
					msg.setText(map.now.description());
			}else if(button.equals("South")){
				map.now = map.now.to("S");
				if(map.now.getMonsterAppear()){
					monster = new Monster(player.FindMonster());
					msg.setText(monster.getName()+"�X�{�A���h�n�N�a�צ�F�h���C");
					OnFightFlag = true;
					cardlayout.show(down, "attack");
					//while (fight()) {};
				}
				else
					msg.setText(map.now.description());
			}else if(button.equals("East")){
				map.now = map.now.to("E");
				if(map.now.getMonsterAppear()){
					monster = new Monster(player.FindMonster());
					msg.setText(monster.getName()+"�X�{�A���h�n�N�a�צ�F�h���C");
					OnFightFlag = true;
					cardlayout.show(down, "attack");
					//while (fight()) {};
				}
				else
					msg.setText(map.now.description());
			}else if(button.equals("West")){
				map.now = map.now.to("W");
				if(map.now.getMonsterAppear()){
					monster = new Monster(player.FindMonster());
					msg.setText(monster.getName()+"�X�{�A���h�n�N�a�צ�F�h���C");
					OnFightFlag = true;
					cardlayout.show(down, "attack");
					//while (fight()) {};
				}
				else
					msg.setText(map.now.description());
			}
			//���Uend�����C��,��������
			else if(button.equals("End")){
				System.exit(0);
			}
			else if(button.equals("Restart")){
				map = new graph();
				msg.setText(map.now.description());
				cardlayout.show(down, "move");
			}
			//Move�^�첾�ʵe��
			else if(button.equals("Move")){
				if(OnFightFlag){
					//���ŦA�Ӽg�k�����Y��
					msg.setText(monster.getName()+"���G��ı�F�A���N�ϡA���G�O���i��k��F�C");
				}else{
					msg.setText(map.now.description());
					cardlayout.show(down,"move");
				}
			}
			//Item�}�Ҫ��~��
			else if(button.equals("Item")){
				launchItemPanel();
				down.add("item",itemPanel);
				cardlayout.show(down,"item");
			}
			//Attack�}�ҧޯ���
			else if(button.equals("Attack")){
				launchAttackPanel();
				down.add("attack",attackPanel);
				cardlayout.show(down,"attack");
			}
			//�s��
			else if(button.equals("Save")){
				msg.setText("saved");
				file f=new file();
				f.save(player);
				cardlayout.show(down,"save");
			}
			//Ū��
			else if(button.equals("Read")){
				file f=new file();
				f.read(player);
			}
			else
				System.err.println("Unexpected error.");
		}catch(NoRoomException exc){
			msg.append("\n"+exc.getMessage());
		}
	}
	public void launchItemPanel(){
		itemPanel = new Panel();
		itemPanel.setLayout(new FlowLayout());
		if(player.getItem().size()>0){
			for(int i = 1; i<=Item.RESTOREPOTION; i++){
				if (player.getItem().containsKey(i)){
					Button A = new Button(player.getItem().get(i).getName());
					A.addActionListener(RestorePotionLinstener);
					itemPanel.add(A);
				}
			}
			for(int i = Item.RESTOREPOTION+1; i<=Item.WEAPON; i++){
				if (player.getItem().containsKey(i)){
					Button A = new Button(player.getItem().get(i).getName());
					A.addActionListener(WeaponListener);
					itemPanel.add(A);
				}
			}
		}
		else{
			Label l1 = new Label("�S�����󪫫~:(");
			itemPanel.add(l1);
		}
		//itemPanel.add(new Button("��^"));
	}
	public void launchAttackPanel(){
		attackPanel = new Panel();
		Label magicAttackL = new Label("Magic Attack");
		Label meleeAttackL = new Label("Phsical Attack");
		Panel attackPanelLeft = new Panel();
		Panel attackPanelRight = new Panel();
		ArrayList<Button> skillList = new ArrayList<Button>(10);
		ActionListener AttackListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				//System.out.println(command);
				for(int i = 0; i<player.getSkill().size(); i++){
					if(command.equals(""+i)){
						msg.setText(player.attack(player.getSkill().get(i), monster));
						if(OnFightFlag){
							fight();
						}
					}
				}
			}
		};
		
		attackPanelLeft.add(meleeAttackL);
		attackPanelRight.add(magicAttackL);
		attackPanelLeft.setLayout(new GridLayout(7,1));
		attackPanelRight.setLayout(new GridLayout(7,1));
		attackPanel.setLayout(new GridLayout(1,2));
		attackPanel.add(attackPanelLeft);
		attackPanel.add(attackPanelRight);
		attackPanelLeft.setBounds(0,0,150,190);
		attackPanelRight.setBounds(150,0,150,190);
		
		if(player.getSkill().size() == 0){
			Label l1 = new Label("Oops! �A�S������ޯ�,�o�����ӵo�ͪ�:(");
			attackPanel.add(l1);
		}else{
			for(int i = 0; i<player.getSkill().size(); i++){
				Skill pivot = player.getSkill().get(i);
				skillList.add(i, new Button(pivot.getName()));
				skillList.get(i).setActionCommand(""+i);
				skillList.get(i).setSize(50,25);
				skillList.get(i).addActionListener(AttackListener);
				if(pivot instanceof MagicAttack){
					attackPanelRight.add(skillList.get(i));
				}else if(pivot instanceof MeleeAttack){
					attackPanelLeft.add(skillList.get(i));
				}else{
					System.err.println("Some error happened in AttackPanel.");
				}
			}
		}
	}
	public void launchMovePanel(){
		movePanel = new Panel();
		movePanel.setLayout(null);
		forward.addActionListener(this);
		forward.setBounds(120, 40, 50, 20);
		left.addActionListener(this);
		left.setBounds(60, 80, 50, 20);
		right.addActionListener(this);
		right.setBounds(180, 80, 50, 20);
		backward.addActionListener(this);
		backward.setBounds(115, 120, 60, 20);
		item.addActionListener(this);
		item.setBounds(60, 80, 50, 20);
		movePanel.add(forward);
		movePanel.add(left);
		movePanel.add(right);
		movePanel.add(backward);
	}
	public void launchMenu(){
		menu = new Panel();
		end = new Button("End");
		restart = new Button("Restart");

		menu.setLayout(null);
		menu.add(end);
		menu.add(restart);
		end.setBounds(95,80,50,20);
		end.addActionListener(this);
		restart.setBounds(145,80,50,20);
		restart.addActionListener(this);
	}
	public void launchItemChoicePanel(){
		itemchoicePanel = new Panel();
		Button A = new Button("�ϥΪ��~");
		Button B = new Button("��ܨ�L���~");
		A.addActionListener(RestorePotionLinstener);
		B.addActionListener(RestorePotionLinstener);
		itemchoicePanel.add(A);
		itemchoicePanel.add(B);
	}
	public void launchWeaponChoicePanel(){
		WeaponChoicePanel = new Panel();
		Button A = new Button("�˳�");
		Button B = new Button("�����˳�");
		Button C = new Button("���");
		Weapon pivot = (Weapon)player.getItem().get(Holditem);
		
		A.addActionListener(WeaponListener);
		B.addActionListener(WeaponListener);
		C.addActionListener(WeaponListener);
		if(!pivot.isEquipped()){
			WeaponChoicePanel.add(A);
		}else{
			WeaponChoicePanel.add(B);
		}
		WeaponChoicePanel.add(C);
	}
	public void CreatePlayer(){
		CreateWindow c = new CreateWindow(window);
		player = c.player;
		new StoryTeller(window);
	}
	
	public static void main(String[] args) {
		UI ui = new UI();
		ui.launchFrame();
		RestorePotion HPPotion1 = new RestorePotion("��_��(S)", 1, 1,30);//���եΫ�_��
		RestorePotion HPPotion2 = new RestorePotion("��_��(M)", 2, 1,100);//���եΫ�_��
		RestorePotion HPPotion3 = new RestorePotion("��_��(L)", 3, 1,0);//���եΫ�_��
		RestorePotion MPPotion1 = new RestorePotion("������(S)", 4, 1,30);//���եά�����
		RestorePotion MPPotion2 = new RestorePotion("������(M)", 5, 1,100);//���եά�����
		RestorePotion MPPotion3 = new RestorePotion("������(L)", 6, 1,0);//���եά�����
		player.addItem(HPPotion1);//���եΡG���ľ��̩�J�D����
		/*ui.player.addItem(HPPotion2);
		ui.player.addItem(HPPotion3);
		ui.player.addItem(MPPotion1);
		ui.player.addItem(MPPotion2);
		ui.player.addItem(MPPotion3);
		ui.player.addItem(new Weapon("�P��",8,1,1));
		*/

		while(!ui.map.now.getName().equals("L")){
			
		}
		ui.monster = new Boss("���", 15);
		ui.msg.setText(ui.monster.getName()+"�X�{�A�A�r����A�ǳƬ����z�q�ĤO�@�աC");
		ui.cardlayout.show(ui.down,"attack");
		ui.setOnFightFlag(true);
		if(ui.monster == null){
			ui.msg.setText("You escaped the maze!");
			ui.endGame();
		}
	}
	public void fight(){
		//
//		monster = new Monster("�Z��",2);
//		monster.addSkill(new MagicAttack("�߯��ܨ�",2,2));
//		monster.addSkill(new MeleeAttack("�ļ�",2));
//		monster.setArmor(0);
//		String s = "�@���i���R����"+monster.getName()+"�q���v���ĤF�X�ӡC\n�A�a�ۤj�D�Ǳµ��A���ӱ�����~�j�j���L�o�@���C\n�ǳƦn�A���ݰ_�ӤS�ֽĹL�ӤF�C";
//		msg.setText(s);
		//
		Dice d = new Dice(monster.getSkill().size());
		if (player.getHp() != 0){
			//System.out.println("action made.");
			msg.append("\n------------\n"+player.toString()+"\n"+monster.toString());
			if(monster.getHp() != 0){
				int k = d.dice()-1;
				System.out.println(k);
				msg.append("\n"+monster.attack(monster.getSkill().get(k), player));
				msg.append("\n------------\n"+player.toString()+"\n"+monster.toString());
				msg.append(player.refresh());
				if (player.getHp() == 0){
					OnFightFlag = false;
					cardlayout.show(down, "menu");
				}
			}else{
				msg.append(monster.defeatedBy(player));
				msg.append(player.refresh());
				msg.append(map.now.description());
				monster = null;
				OnFightFlag = false;
				cardlayout.show(down, "move");
			}
		}else{
			OnFightFlag = false;
			cardlayout.show(down, "menu");
		}
}
	public  void setOnFightFlag(boolean Flag){
		OnFightFlag = Flag;
	}
	private void endGame() {//�s�Xend���s
		med.removeAll();
		cardlayout.show(down,"menu");
	}
	
}
