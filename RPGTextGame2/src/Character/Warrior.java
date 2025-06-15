package Character;

import java.util.Scanner;

import Map.WeaponStore;

public class Warrior extends Hero {
	private Scanner sc = new Scanner(System.in);

	public Warrior(String name) {
		super(name);
		this.level = 1;
		this.power = 15;
		this.hp = 80;
		this.defense = 25;
		this.mp = 0;
		this.experience = 0;
		this.money = 0;
		this.weapon = "검";
	}

	public int getDamage() {
		if (this.weapon.equals("검")) {
			return this.power * 3;
		} else if (this.weapon.equals("대검")) {
			return this.power * 4;
		}
		return 0;
	}

	public int weapon_store() {
		String[] weapons = { "검", "대검" };
		WeaponStore weaponstore = new WeaponStore();
		for (int i = 0; i < weapons.length; i++) {
			System.out.printf("%d. %s\t| %d원\t| 피해량 : %d\n", i + 1, weapons[i], weaponstore.getCost(1, i + 1), i + 3);
		}
		System.out.print("원하시는 물건을 입력해주세요 : ");

		int buyweapon = sc.nextInt();

		if (weaponstore.getCost(1, buyweapon) > this.money) {
			System.out.println("\n돈이 부족합니다.");
			return 5;

		}

		if (buyweapon == 0) {
			return 2;
		} else if (buyweapon < 0 || buyweapon > weapons.length) {
			System.out.println("\n구매할 수 없는 품목입니다.");
			return 5;
		} else {
			System.out.printf("\n%s를 구매했습니다.\n", weapons[buyweapon - 1]);
			this.weapon = weapons[buyweapon - 1];
			this.money -= weaponstore.getCost(1, buyweapon);
			return 2;
		}
	}

	public double select_attack(Monster monster) {
		String[] attacks = { "베기", "찌르기", "내려치기" };
		for (int i = 1; i <= attacks.length; i++) {
			if (i >= 3 && !this.weapon.equals("대검"))
				continue;
			System.out.printf("%d. %s\n", i, attacks[i - 1]);
		}
		System.out.print("공격 유형을 선택하세요 : ");
		int numattack = sc.nextInt();

		if (numattack < 1 || numattack > (this.weapon.equals("대검") ? attacks.length : 2)) {
			System.out.println("공격에 실패했습니다. ");
			return 0;
		}
		System.out.printf("%s를 사용했습니다. ", attacks[numattack - 1]);
		if (numattack == 1) {
			if (monster.getName() == "너구리") {
				System.out.println("몬스터 특화 공격으로 1.5배의 피해를 가합니다.");
				return 1.5;
			}
			return 1;
		} else if (numattack == 2) {
			if (monster.getName() == "살쾡이") {
				System.out.println("몬스터 특화 공격으로 1.5배의 피해를 가합니다.");
				return 1.5;
			}
			return 1;
		} else if (numattack == 3) {
			if (monster.getName() == "들개") {
				System.out.println("몬스터 특화 공격으로 1.5배의 피해를 가합니다.");
				return 1.25 * 1.5;
			}
			return 1.25;
		}

		return 1;
	}
}
