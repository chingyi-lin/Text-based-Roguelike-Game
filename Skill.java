
public class Skill {
	private String name;
	private int basicDamage;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the basicDamage
	 */
	public int getBasicDamage() {
		return basicDamage;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param basicDamage the basicDamage to set
	 */
	public void setBasicDamage(int basicDamage) {
		this.basicDamage = basicDamage;
	}
	public Skill(String name, int basicDamage) {
		super();
		this.name = name;
		this.basicDamage = basicDamage;
	}
}
