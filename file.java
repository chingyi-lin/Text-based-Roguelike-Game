import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class file {

	public file(){
		
	}
	public void save(Player player){
		PrintWriter outputStream = null;
		try {
			outputStream=new PrintWriter(new FileOutputStream(player.getName()+".txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.println(player.getLevel());
		//等級
		outputStream.println(player.getHp());
		//hp
		outputStream.println(player.getMp());
		//mp
		outputStream.println(player.getExp());
		//經驗值
		outputStream.println(player.getSkill().size());
		for(int i =0;i<player.getSkill().size();i++){
			outputStream.println(player.getSkill().get(i).getName());
			outputStream.println(player.getSkill().get(i).getBasicDamage());

		}

		//技能
		for(int i =0;i<13;i++){
			if(player.getItem().get(i)!=null){
				outputStream.println(player.getItem().get(i).getName());
				outputStream.println(player.getItem().get(i).getAmount());
				outputStream.println(i);
			}
			}
		//物品
		/*
		我覺得可以在graph裡寫個getRecentRoom得到現在所在的房間<如果只有一關的話啦>
		 */
		outputStream.close();
	}
	public void read(Player player){
		Scanner inputStream = null;
		try {
			inputStream=new Scanner(new FileInputStream(player.getName()+".txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found.");
			e.printStackTrace();
		}
		player.setLevel(inputStream.nextInt());
		player.setHp(inputStream.nextInt());
		player.setMp(inputStream.nextInt());
		player.addExp(inputStream.nextInt());
		ArrayList<Skill> skill=new ArrayList<Skill>();
		int l=inputStream.nextInt();
		for(int i=0;i<l;i++){
			skill.add(new Skill(inputStream.next(),inputStream.nextInt()));
		}
		player.setSkill(skill);
		 for(int i=0;i<13;i++){
			 if(inputStream.hasNext())
			player.addItem(new Item(inputStream.next(),inputStream.nextInt(),inputStream.nextInt()));
		 }
	
	}
}
