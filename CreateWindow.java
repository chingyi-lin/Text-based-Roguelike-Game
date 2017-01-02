import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateWindow{
	Dialog createWindow;
	TextField name;
	Label info1;
	Label info2;
	Label info3;
	Button confirm;
	Player player;
	public CreateWindow(Frame f){
		createWindow = new Dialog(f,"進入遊戲");
		name = new TextField();
		info1 = new Label("日安，旅行者。");
		info2 = new Label("在故事開始之前，請先告訴我你的名字。");
		createWindow.setLayout(null);
		confirm = new Button("確定");
		
		info1.setBounds(20,50,300,30);
		info2.setBounds(20,80,300,30);
		name.setBounds(20,120,100,25);
		name.setSize(100, 25);
		confirm.setBounds(130,150,50,25);
		confirm.setActionCommand(name.getText());
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!name.getText().equals("")){
					player = new Fighter(name.getText(),2);
					createWindow.dispose();
				}
			}
		});
		
		createWindow.add(info1);
		createWindow.add(info2);
		createWindow.add(name);
		createWindow.add(confirm);
		createWindow.setSize(300, 200);
		createWindow.setModal(true);
		createWindow.setVisible(true);		
	}
	public Player getPlayer(){
		return player;
	}
}
