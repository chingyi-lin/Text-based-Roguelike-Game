
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
			return this.getName() + ": 可以回復生命" + this.getRestorValue() +"點。";
		else if(this.getNumber()==3)
			return this.getName() + ": 可以回復全部生命";
		else if(this.getNumber()<6)
			return this.getName() + ": 可以回復魔力" + this.getRestorValue() +"點。";
		else if(this.getNumber()==6)
			return this.getName() + ": 可以回復全部魔力";
		else if(this.getNumber()==7)
			return this.getName() + ": 可以回復全部生命及魔力";
		else
			return "Oops, there is something wrong";
	}
}
