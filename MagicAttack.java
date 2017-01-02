
public class MagicAttack extends Skill {
	int mpConsume;
	public MagicAttack(String name, int basicDamage, int mpConsume) {
		super(name, basicDamage);
		this.mpConsume = mpConsume;
	}
	/**
	 * @return the mpConsume
	 */
	public int getMpConsume() {
		return mpConsume;
	}
	/**
	 * @param mpConsume the mpConsume to set
	 */
	public void setMpConsume(int mpConsume) {
		this.mpConsume = mpConsume;
	}
	

}
