package Map;

public class PotionStore {
	private int power = 30, def = 30, exp = 100, hp = 10, mp = 10;

	public PotionStore() {

	}

	public int getCost(int num) {
		switch (num) {
		case 1:
			return this.power;
		case 2:
			return this.def;
		case 3:
			return this.exp;
		case 4:
			return this.hp;
		case 5:
			return this.mp;
		}
		return 0;
	}
}
