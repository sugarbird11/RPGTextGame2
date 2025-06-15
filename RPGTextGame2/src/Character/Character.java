package Character;

public class Character {
	protected String name;
	protected int level, power, hp, defense, mp, experience, money;

	public Character(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getPower() {
		return power;
	}

	public int getHp() {
		return hp;
	}

	public int getDefense() {
		return defense;
	}

	public int getMp() {
		return mp;
	}

	public int getExp() {
		return experience;
	}

	public int getMoney() {
		return money;
	}
}