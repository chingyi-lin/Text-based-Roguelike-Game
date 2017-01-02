import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StoryTeller {
	Dialog createWindow;
	Label info1;
	Label info2;
	Label info3;
	Label info4;
	Label info5;
	Button confirm;
	public StoryTeller(Frame f){
		createWindow = new Dialog(f,"遊戲背景");
		createWindow.setLayout(null);
		info1 = new Label("爪哇國的國王好大喜功，長年戰爭使得民不聊生。");
		info2 = new Label("您便是在戰亂中被爪哇大蛇撫養長大的孤兒。");
		info3 = new Label("因為您的仁慈，如今您在爪哇島受到萬民擁戴，");
		info4 = new Label("但爪哇島的國王因懼怕您的力量，將您關進大牢。");
		info5 = new Label("您能從黑暗的大牢找到出路嗎？");
		info1.setBounds(10,50,300,30);
		info2.setBounds(10,70,300,30);
		info3.setBounds(10,90,300,30);
		info4.setBounds(10,110,300,30);
		info5.setBounds(10,130,300,30);
		confirm = new Button("開始遊戲");
		confirm.setBounds(120,160,65,25);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				createWindow.dispose();
			}
		});
		createWindow.add(info1);
		createWindow.add(info2);
		createWindow.add(info3);
		createWindow.add(info4);
		createWindow.add(info5);
		createWindow.add(confirm);
		createWindow.setSize(300, 200);
		createWindow.setModal(true);
		createWindow.setVisible(true);
	}
}
