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
		createWindow = new Dialog(f,"�C���I��");
		createWindow.setLayout(null);
		info1 = new Label("���z�ꪺ����n�j�ߥ\�A���~�Ԫ��ϱo������͡C");
		info2 = new Label("�z�K�O�b�Զä��Q���z�j�D���i���j���t��C");
		info3 = new Label("�]���z�����O�A�p���z�b���z�q����U�������A");
		info4 = new Label("�����z�q������]�ߩȱz���O�q�A�N�z���i�j�c�C");
		info5 = new Label("�z��q�·t���j�c���X���ܡH");
		info1.setBounds(10,50,300,30);
		info2.setBounds(10,70,300,30);
		info3.setBounds(10,90,300,30);
		info4.setBounds(10,110,300,30);
		info5.setBounds(10,130,300,30);
		confirm = new Button("�}�l�C��");
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
