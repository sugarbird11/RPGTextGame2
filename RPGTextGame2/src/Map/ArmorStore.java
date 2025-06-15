package Map;

public class ArmorStore {
	private int leather_armor, chain_armor, plate_armor;

	public ArmorStore() {
		this.leather_armor = 100;
		this.chain_armor = 200;
		this.plate_armor = 400;
	}

	public int getCost(int num) {
		if (num == 1) {
			return this.leather_armor;
		} else if (num == 2) {
			return this.chain_armor;
		} else if (num == 3) {
			return this.plate_armor;
		}
		return 0;
	}
}
