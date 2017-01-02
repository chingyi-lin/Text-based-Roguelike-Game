
import java.util.ArrayList;

public class Room {
	private boolean MonsterAppear;
	private String name;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Monster monster;
	private ArrayList<String> edge = new ArrayList<String>(4);
	/**
	 * Default Constructor
	 */
	public Room(){
		MonsterAppear = false;
		name = null;
		west = null;
		north = null;
		south = null;
		east = null;
		monster = null;
	}
	/**
	 * Create a new Room with name
	 * @param name
	 */
	public Room(String name){
		this.name = name;
		MonsterAppear = false;
		west = null;
		north = null;
		south = null;
		east = null;
		monster = null;
	}
	/**
	 * Set all connected Rooms
	 * @param N north room
	 * @param E east room
	 * @param W west room
	 * @param S south room
	 */
	public void setAll(Room N, Room E, Room W, Room S){
		west = W;
		north = N;
		south = S;
		east = E;
		
	}
	public void setAll(Room N, Room E, Room W, Room S, Monster M){
		west = W;
		north = N;
		south = S;
		east = E;
		monster = M;
	}
	/**
	 * Set east room
	 * @param eastRoom
	 */
	public void setEast(Room eastRoom){
		east = eastRoom;
	}
	/**
	 * Set west room
	 * @param westRoom
	 */
	public void setWest(Room westRoom){
		west = westRoom;
	}
	/**
	 * Set north room
	 * @param northRoom
	 */
	public void setNorth(Room northRoom){
		north = northRoom;
	}
	/**
	 * Set south room
	 * @param southRoom
	 */
	public void setSouth(Room southRoom){
		south = southRoom;
	}
	public void setMonster(Monster M){
		monster = M;
	}
	public String getName(){
		return name;
	}
	public Monster getMonster(){
		return monster;
	}
	/**
	 * Move to the next room and determine whether the monster appear.
	 * @param direction
	 * @return Next room
	 */
	public Room to(String direction) throws NoRoomException{
		if(direction.equals("N") && edge.contains("�_��")){
			MonsterDetermine();
			return north;
		}else if(direction.equals("E") && edge.contains("�F��")){
			MonsterDetermine();
			return east;
		}else if(direction.equals("W")  && edge.contains("����")){
			MonsterDetermine();
			return west;
		}else if(direction.equals("S") && edge.contains("�n��")){
			MonsterDetermine();
			return south;
		}else{
			throw new NoRoomException("�A����F�I�o�Ӥ�V�S���I");
		}
	}
	/**
	 * MonsterDetermine
	 * �P�w�Ǫ��O�_�X�{�C
	 * �����ܼơGMonsterAppear
	 */
	public void MonsterDetermine(){
		Dice d10 = new Dice(5);
		if(d10.dice()>=4){
			MonsterAppear = true;
		}
		else
			MonsterAppear = false;
	}
	/**
	 * Get MonsterAppear
	 */
	public boolean getMonsterAppear(){
		return MonsterAppear;
	}
	/**
	 * Give the description of this room
	 * @return
	 */
	public String description(){
		edge();
		String desc = "�A�b�c�� "+this.name+"�A�|�g�@���I�R�C \n���񦳷L�L�������A�ݨӤ��Ӧw���C \n���G�b ";
		if(edge.size()>1){
			for(int i=0;i<edge.size()-2;i++){
				desc += edge.get(i)+", ";
			}
			desc += edge.get(edge.size()-2)+" �� "+edge.get(edge.size()-1)+" ����.";
		}
		else{
			desc +=edge.get(0)+"����.";
		}
		return desc;
	}
	/**
	 * Build a new ArrayList containing all edges
	 */
	public void edge(){
		edge.clear();
		if(north != null){
			edge.add("�_��");
		}
		if(south != null){
			edge.add("�n��");
		}
		if(east != null){
			edge.add("�F��");
		}
		if(west != null){
			edge.add("����");
		}
	}
}