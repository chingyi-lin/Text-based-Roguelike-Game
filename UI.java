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
	private Button right, left, forward, backward;//方向鍵
	private Button attack, item, move, save, read;
	private Panel top, med, down;
	private TextArea msg;
	private graph map;//地圖
	private static Player player;
	private Monster monster/* = new Monster("當前的怪物",1)*/;
	private static Player player1 = new Player("Hero",1);//測試用player
	private static int Holditem;//抓住item編號
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
				if(command.equals("匕首")){
					Holditem = 8;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("大刀")){
					Holditem = 9;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("王者之劍")){
					Holditem = 10;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("普通的樹枝")){
					Holditem = 11;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("強韌的木杖")){
					Holditem = 12;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("火靈法杖")){
					Holditem = 13;
					launchWeaponChoicePanel();
					down.add("weapon",WeaponChoicePanel);
					cardlayout.show(down,"weapon");
					msg.setText(player.getItem().get(Holditem).toString());
				}else if(command.equals("裝備")){
					msg.setText(player.equipeWeapon(player.getItem().get(Holditem)));
					cardlayout.show(down,"item");
				}else if(command.equals("取消裝備")){
					msg.setText(player.unequipeWeapon(player.getItem().get(Holditem)));
					cardlayout.show(down,"item");
				}else if(command.equals("丟棄")){
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
			if(button.equals("恢復劑(S)")){
				Holditem = 1;
				msg.setText(player.getItem().get(1).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("恢復劑(S)")){
				Holditem = 1;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("恢復劑(M)")){
				Holditem = 2;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("恢復劑(L)")){
				Holditem = 3;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("活絡散(S)")){
				Holditem = 4;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("活絡散(M)")){
				Holditem = 5;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("活絡散(L)")){
				Holditem = 6;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("生命之果")){
				Holditem = 7;
				msg.setText(player.getItem().get(Holditem).toString());
				launchItemChoicePanel();
				down.add("choice", itemchoicePanel);
				cardlayout.show(down, "choice");
			}
			else if(button.equals("使用物品")){
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
			else if(button.equals("選擇其他物品")){
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
			//按下方向鍵時移動到另一個房間
			if(button.equals("North")){
				map.now = map.now.to("N");
				if(map.now.getMonsterAppear()){
					monster = new Monster(player.FindMonster());
					msg.setText(monster.getName()+"出現，不懷好意地擋住了去路。");
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
					msg.setText(monster.getName()+"出現，不懷好意地擋住了去路。");
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
					msg.setText(monster.getName()+"出現，不懷好意地擋住了去路。");
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
					msg.setText(monster.getName()+"出現，不懷好意地擋住了去路。");
					OnFightFlag = true;
					cardlayout.show(down, "attack");
					//while (fight()) {};
				}
				else
					msg.setText(map.now.description());
			}
			//按下end結束遊戲,關閉視窗
			else if(button.equals("End")){
				System.exit(0);
			}
			else if(button.equals("Restart")){
				map = new graph();
				msg.setText(map.now.description());
				cardlayout.show(down, "move");
			}
			//Move回到移動畫面
			else if(button.equals("Move")){
				if(OnFightFlag){
					//有空再來寫逃走的擲骰
					msg.setText(monster.getName()+"似乎察覺了你的意圖，似乎是不可能逃脫了。");
				}else{
					msg.setText(map.now.description());
					cardlayout.show(down,"move");
				}
			}
			//Item開啟物品欄
			else if(button.equals("Item")){
				launchItemPanel();
				down.add("item",itemPanel);
				cardlayout.show(down,"item");
			}
			//Attack開啟技能欄
			else if(button.equals("Attack")){
				launchAttackPanel();
				down.add("attack",attackPanel);
				cardlayout.show(down,"attack");
			}
			//存檔
			else if(button.equals("Save")){
				msg.setText("saved");
				file f=new file();
				f.save(player);
				cardlayout.show(down,"save");
			}
			//讀檔
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
			Label l1 = new Label("沒有任何物品:(");
			itemPanel.add(l1);
		}
		//itemPanel.add(new Button("返回"));
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
			Label l1 = new Label("Oops! 你沒有任何技能,這不應該發生的:(");
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
		Button A = new Button("使用物品");
		Button B = new Button("選擇其他物品");
		A.addActionListener(RestorePotionLinstener);
		B.addActionListener(RestorePotionLinstener);
		itemchoicePanel.add(A);
		itemchoicePanel.add(B);
	}
	public void launchWeaponChoicePanel(){
		WeaponChoicePanel = new Panel();
		Button A = new Button("裝備");
		Button B = new Button("取消裝備");
		Button C = new Button("丟棄");
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
		RestorePotion HPPotion1 = new RestorePotion("恢復劑(S)", 1, 1,30);//測試用恢復劑
		RestorePotion HPPotion2 = new RestorePotion("恢復劑(M)", 2, 1,100);//測試用恢復劑
		RestorePotion HPPotion3 = new RestorePotion("恢復劑(L)", 3, 1,0);//測試用恢復劑
		RestorePotion MPPotion1 = new RestorePotion("活絡散(S)", 4, 1,30);//測試用活絡散
		RestorePotion MPPotion2 = new RestorePotion("活絡散(M)", 5, 1,100);//測試用活絡散
		RestorePotion MPPotion3 = new RestorePotion("活絡散(L)", 6, 1,0);//測試用活絡散
		player.addItem(HPPotion1);//測試用：把藥劑們放入道具欄
		/*ui.player.addItem(HPPotion2);
		ui.player.addItem(HPPotion3);
		ui.player.addItem(MPPotion1);
		ui.player.addItem(MPPotion2);
		ui.player.addItem(MPPotion3);
		ui.player.addItem(new Weapon("匕首",8,1,1));
		*/

		while(!ui.map.now.getName().equals("L")){
			
		}
		ui.monster = new Boss("國王", 15);
		ui.msg.setText(ui.monster.getName()+"出現，你咬緊牙，準備為爪哇島奮力一博。");
		ui.cardlayout.show(ui.down,"attack");
		ui.setOnFightFlag(true);
		if(ui.monster == null){
			ui.msg.setText("You escaped the maze!");
			ui.endGame();
		}
	}
	public void fight(){
		//
//		monster = new Monster("鎧蟲",2);
//		monster.addSkill(new MagicAttack("心神奪取",2,2));
//		monster.addSkill(new MeleeAttack("衝撞",2));
//		monster.setArmor(0);
//		String s = "一隻張牙舞爪的"+monster.getName()+"從陰影中衝了出來。\n你靠著大蛇傳授給你的敏捷身手才勉強躲過這一擊。\n準備好，它看起來又快衝過來了。";
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
	private void endGame() {//叫出end按鈕
		med.removeAll();
		cardlayout.show(down,"menu");
	}
	
}
