package Character;

import java.util.Scanner;

import Map.ArmorStore;
import Map.PotionStore;

public class Hero extends Character {
	protected String weapon, armor;

	public Hero(String name) {
		super(name);
		this.armor = "없음";
	}

	public int getDamage() {
		if (this instanceof Warrior) {
			return ((Warrior) this).getDamage();
		} else if (this instanceof Magician) {
			return ((Magician) this).getDamage();
		}
		return this.power;
	}

	public String getWeapon() {
		return this.weapon;
	}

	public String getArmor() {
		return this.armor;
	}

	public int hunt(Monster monster) {
		System.out.printf("%s와 전투를 시작합니다.\n\n", monster.getName());
		int whose_turn = 0;
		while (monster.getHp() > 0 && this.hp > 0) {
			if (whose_turn == 0) {
				System.out.printf("%s의 공격입니다.\n", this.name);
				double amp = select_attack(monster);
				monster.hp -= (int) (amp * this.getDamage()) - monster.getDefense() > 0
						? (int) (amp * this.getDamage()) - monster.getDefense()
						: 0;
				System.out.printf("%d의 데미지를 입혔습니다.\n\n",
						(int) (amp * this.getDamage()) - monster.getDefense() > 0
								? (int) (amp * this.getDamage()) - monster.getDefense()
								: 0);
				if (monster.getHp() <= 0) {
					System.out.printf("%s가(이) 죽었습니다.\n", monster.name);
					this.money += monster.getMoney();
					this.experience += monster.getExp();
					return 2;
				}
			} else {
				this.hp -= monster.getPower() - this.defense > 0 ? monster.getPower() - this.defense : 0;
				System.out.printf("%s의 공격입니다. %d의 데미지를 입었습니다.\n\n", monster.getName(),
						monster.getPower() - this.defense > 0 ? monster.getPower() - this.defense : 0);
				if (this.hp <= 0) {
					System.out.printf("%s가(이) 죽었습니다.\n", this.name);
					return -1;
				}
			}
			whose_turn = 1 - whose_turn;
		}
		return -1;
	}

	public double select_attack(Monster monster) {
		if (this instanceof Warrior) {
			return ((Warrior) this).select_attack(monster);
		} else if (this instanceof Magician) {
			return ((Magician) this).select_attack(monster);
		}

		return 1;
	}

	public int potion_store(int potionNum) {
		PotionStore potionstore = new PotionStore();
		int cost = potionstore.getCost(potionNum);
		if (this.money < cost) {
			System.out.println("\n돈이 부족합니다.");
			return 4;
		}
		System.out.println("\n성공적으로 구입이 완료되었습니다.");
		switch (potionNum) {
		case 1:
			System.out.println("힘이 3 증가하였습니다.");
			this.power += 3;
			break;
		case 2:
			System.out.println("방어가 3 증가하였습니다.");
			this.defense += 3;
			break;
		case 3:
			System.out.println("경험치가 50 증가하였습니다.");
			this.experience += 50;
			break;
		case 4:
			System.out.println("HP가 10 증가하였습니다.");
			this.hp += 10;
			break;
		case 5:
			System.out.println("MP가 10 증가하였습니다.");
			this.mp += 10;
			break;
		}
		this.money -= cost;
		return 2;
	}

	public int weapon_store() {
		if (this instanceof Warrior) {
			return ((Warrior) this).weapon_store();
		} else if (this instanceof Magician) {
			return ((Magician) this).weapon_store();
		}
		return 2;
	}

	public int armor_store() {
		String[] armors = { "가죽 갑옷", "사슬 갑옷", "판금 갑옷" };
		int[] defs = { 10, 20, 40 };
		ArmorStore armorstore = new ArmorStore();
		for (int i = 0; i < armors.length; i++) {
			System.out.printf("%d. %s\t| %d원\t| 방어력 : %d\n", i + 1, armors[i], armorstore.getCost(i + 1), defs[i]);
		}
		System.out.print("원하시는 물건을 입력해주세요 : ");

		Scanner sc = new Scanner(System.in);
		int buyweapon = sc.nextInt();

		if (armorstore.getCost(buyweapon) > this.money) {
			System.out.println("\n돈이 부족합니다.");
			return 6;

		}

		if (buyweapon == 0) {
			return 2;
		} else if (buyweapon < 0 || buyweapon > armors.length) {
			System.out.println("\n구매할 수 없는 품목입니다.");
			return 6;
		} else {
			System.out.printf("\n%s를 구매했습니다.\n", armors[buyweapon - 1]);
			for (int i = 0; i < armors.length; i++) {
				if (this.armor.equals(armors[i])) {
					this.defense -= defs[i];
				}
			}
			this.armor = armors[buyweapon - 1];
			this.defense += defs[buyweapon - 1];
			this.money -= armorstore.getCost(buyweapon);
			return 2;
		}
	}

	public void add_exp(int exp) {
		this.experience += exp;
	}

	public void add_money(int money) {
		this.money += money;
	}

	public void LevelUp() {
		if (this.experience < 100)
			return;

		while (this.experience >= 100) {
			this.level += 1;
			this.experience -= 100;
			this.hp += 5;
			this.defense += 1;
			this.power += 1;
			System.out.printf("\n%s이(가) 더 강해졌습니다.\n레벨이 %d가 되었습니다.\n", this.name, this.level);
		}
	}
}
