
public class RestorePotion extends Item{
	private int restoreValue;
	public RestorePotion(){
		super();
	}
	public RestorePotion (String Name, int Number, int Amount, int ReValue){
		super(Name, Number, Amount);
		restoreValue = ReValue;
	}
	/**
	 * Return restoreValue to make player can restore.
	 * @return
	 */
	public int getRestorValue(){
		return restoreValue;	
	}
	public String toString(){
		if(this.getNumber()<3)
			return this.getName() + ": �i�H�^�_�ͩR" + this.getRestorValue() +"�I�C";
		else if(this.getNumber()==3)
			return this.getName() + ": �i�H�^�_�����ͩR";
		else if(this.getNumber()<6)
			return this.getName() + ": �i�H�^�_�]�O" + this.getRestorValue() +"�I�C";
		else if(this.getNumber()==6)
			return this.getName() + ": �i�H�^�_�����]�O";
		else if(this.getNumber()==7)
			return this.getName() + ": �i�H�^�_�����ͩR���]�O";
		else
			return "Oops, there is something wrong";
	}
}
