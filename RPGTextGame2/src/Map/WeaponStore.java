package Map;

public class WeaponStore {
	private int sword = 10, great_sword = 200;
	private int wand = 10, shiny_wand = 200;

	public WeaponStore() {

	}

	public int getCost(int pf, int num) {
		if (pf == 1) {
			if (num == 1)
				return this.sword;
			else if (num == 2)
				return this.great_sword;
		}

		if (pf == 2) {
			if (num == 1)
				return this.wand;
			else if (num == 2)
				return this.shiny_wand;
		}

		return 0;
	}
}
