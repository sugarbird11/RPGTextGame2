package Map;

public class Missions {
	private boolean hunting_raccoon, hunting_lynx, hunting_dog, hunting_boar; // 사냥터 업적
	private boolean buy_potion; // 포션 관련 업적
	private boolean buy_weapon; // 무기 상점 업적
	private boolean buy_armor;
	private boolean reach_level_5, reach_level_10;

	public Missions() {
		this.hunting_raccoon = false;
		this.hunting_lynx = false;
		this.hunting_dog = false;
		this.hunting_boar = false;

		this.buy_potion = false;
		this.buy_potion = false;
	}

	public boolean get_hunting_raccoon() {
		return this.hunting_raccoon;
	}

	public boolean clear_hunting_raccoon() {
		if (this.hunting_raccoon == false) {
			System.out.println("'업적: 너구리 사냥'을 달성하였습니다! 10의 경험치를 획득했습니다.");
			this.hunting_raccoon = true;
			return true;
		}
		return false;
	}

	public boolean get_hunting_lynx() {
		return this.hunting_lynx;
	}

	public boolean clear_hunting_lynx() {
		if (this.hunting_lynx == false) {
			System.out.println("'업적: 살쾡이 사냥'을 달성하였습니다! 30의 경험치를 획득했습니다.");
			this.hunting_lynx = true;
			return true;
		}
		return false;
	}

	public boolean get_hunting_dog() {
		return this.hunting_dog;
	}

	public boolean clear_hunting_dog() {
		if (this.hunting_dog == false) {
			System.out.println("'업적: 들개 사냥'을 달성하였습니다! 50의 경험치를 획득했습니다.");
			this.hunting_dog = true;
			return true;
		}
		return false;
	}

	public boolean get_hunting_boar() {
		return this.hunting_boar;
	}

	public boolean clear_hunting_boar() {
		if (this.hunting_boar == false) {
			System.out.println("'업적: 멧돼지 사냥'을 달성하였습니다! 70의 경험치를 획득했습니다.");
			this.hunting_boar = true;
			return true;
		}
		return false;
	}

	public boolean get_buy_potion() {
		return this.buy_potion;
	}

	public boolean clear_buy_potion() {
		if (this.buy_potion == false) {
			System.out.println("'업적: 포션 구매'를 달성하였습니다! 30의 경험치를 획득했습니다.");
			this.buy_potion = true;
			return true;
		}
		return false;
	}

	public boolean get_buy_weapon() {
		return this.buy_weapon;
	}

	public boolean clear_buy_weapon() {
		if (this.buy_weapon == false) {
			System.out.println("'업적: 무기 구매'를 달성하였습니다! 70의 경험치를 획득했습니다.");
			this.buy_weapon = true;
			return true;
		}
		return false;
	}

	public boolean get_buy_armor() {
		return this.buy_armor;
	}

	public boolean clear_buy_armor() {
		if (this.buy_armor == false) {
			System.out.println("'업적 : 방어구 구매'를 달성하였습니다! 70의 경험치를 획득했습니다.");
			this.buy_armor = true;
			return true;
		}
		return false;
	}

	public boolean get_reach_level_5() {
		return this.reach_level_5;
	}

	public boolean clear_reach_level_5() {
		if (this.reach_level_5 == false) {
			System.out.println("'업적 : 레벨 5 달성'을 달성하였습니다! 30원을 획득했습니다.");
			this.reach_level_5 = true;
			return true;
		}
		return false;
	}

	public boolean get_reach_level_10() {
		return this.reach_level_10;
	}

	public boolean clear_reach_level_10() {
		if (this.reach_level_10 == false) {
			System.out.println("'업적 : 레벨 10 달성'을 달성하였습니다! 60원을 획득했습니다.");
			this.reach_level_10 = true;
			return true;
		}
		return false;
	}
}
