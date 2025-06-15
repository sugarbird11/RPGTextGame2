package Main;

import java.util.Scanner;

import Character.Boar;
import Character.Dog;
import Character.Hero;
import Character.Lynx;
import Character.Magician;
import Character.Monster;
import Character.Raccoon;
import Character.Warrior;
import Map.Missions;

public class RPGTextGame {
	private static int game_situation = 0;
	private static Scanner sc = new Scanner(System.in);
	private static Hero myHero;
	private static Missions Missions = new Missions();
	private static int numPf;
	private static String[] professions = { "전사", "마법사" };
	private static String[] monsters = { "너구리", "살쾡이", "들개", "멧돼지" };
	private static String[] modes = { "0. 현재 상태", "1. 사냥터", "2. 포션 상점", "3. 무기 상점", "4. 방어구 상점", "5. 업적" };

	public static void main(String[] args) {

		System.out.println("*********************");
		while (game_situation != -1) {

			switch (game_situation) {

			case 0: // 게임 생성 단계
				for (int i = 0; i < professions.length; i++) {
					System.out.printf("%d. %s\n", i + 1, professions[i]);
				}
				System.out.print("직업의 번호를 선택하세요 : ");
				numPf = sc.nextInt();
				if (numPf < 1 || numPf > professions.length)
					break;
				System.out.printf("%s가 선택되었습니다.\n\n", professions[numPf - 1]);

				System.out.print("영웅의 이름을 입력하세요 : ");
				String hero_name = sc.next();
				System.out.print("이름이 입력되었습니다.\n게임에 입장하였습니다.\n");

				if (numPf == 1)
					myHero = new Warrior(hero_name);
				if (numPf == 2)
					myHero = new Magician(hero_name);
				game_situation = 1;
				break;

			case 1: // 스탯 표시 프로세스
				System.out.printf("현재 %s의 레벨 : %d\n", myHero.getName(), myHero.getLevel());
				System.out.printf("현재 %s의 힘 : %d\n", myHero.getName(), myHero.getPower());
				System.out.printf("현재 %s의 방어력 : %d\n", myHero.getName(), myHero.getDefense());
				System.out.printf("현재 %s의 HP : %d\n", myHero.getName(), myHero.getHp());
				System.out.printf("현재 %s의 MP : %d\n", myHero.getName(), myHero.getMp());
				System.out.printf("현재 %s의 경험치 : %d\n", myHero.getName(), myHero.getExp());
				System.out.printf("현재 %s의 돈 : %d원\n", myHero.getName(), myHero.getMoney());
				System.out.printf("현재 %s의 무기 : %s\n", myHero.getName(), myHero.getWeapon());
				System.out.printf("현재 %s의 방어구 : %s\n", myHero.getName(), myHero.getArmor());
				game_situation = 2;
				break;

			case 2: // 장소 선택 프로세스
				for (int i = 0; i < modes.length; i++) {
					System.out.println(modes[i]);
				}
				System.out.print("이동할 곳의 번호를 입력해주세요 : ");
				int numMod = sc.nextInt();
				if (numMod == 0)
					game_situation = 1;
				else if (numMod == 1)
					game_situation = 3;
				else if (numMod == 2)
					game_situation = 4;
				else if (numMod == 3)
					game_situation = 5;
				else if (numMod == 4)
					game_situation = 6;
				else if (numMod == 5)
					game_situation = 7;
				break;

			case 3: // 사냥터 프로세스
				System.out.println("사냥터에 입장하였습니다.");
				System.out.println("0. 나가기");
				for (int i = 0; i < monsters.length; i++) {
					System.out.printf("%d. %s\n", i + 1, monsters[i]);
				}
				System.out.print("전투할 상대를 입력해주세요 : ");
				int fight_with = sc.nextInt();
				if (fight_with < 0 || fight_with - 1 >= monsters.length) {
					System.out.print("\n상대할 수 없는 몬스터입니다!\n");
				} else if (fight_with == 0) {
					game_situation = 2;
				} else {
					if (fight_with == 1) {
						Monster monster = new Raccoon();
						game_situation = myHero.hunt(monster);
					} else if (fight_with == 2) {
						Monster monster = new Lynx();
						game_situation = myHero.hunt(monster);
					} else if (fight_with == 3) {
						Monster monster = new Dog();
						game_situation = myHero.hunt(monster);
					} else if (fight_with == 4) {
						Monster monster = new Boar();
						game_situation = myHero.hunt(monster);
					}

					if (game_situation == 2) {
						if (fight_with == 1) {
							if (Missions.clear_hunting_raccoon())
								myHero.add_exp(10);
						} else if (fight_with == 2) {
							if (Missions.clear_hunting_lynx())
								myHero.add_exp(30);
						} else if (fight_with == 3) {
							if (Missions.clear_hunting_dog())
								myHero.add_exp(50);
						} else if (fight_with == 4) {
							if (Missions.clear_hunting_boar())
								myHero.add_exp(70);
						}
					}
				}
				break;

			case 4: // 포션 상점 프로세스
				System.out.println("포션 상점에 입장하였습니다.");
				System.out.println("0. 나가기");
				System.out.println("1. 힘 증강 포션 (30원)");
				System.out.println("2. 방어력 증강 포션 (30원)");
				System.out.println("3. 경험치 증강 포션 (100원)");
				System.out.println("4. HP 증강 포션 (10원)");
				System.out.println("5. MP 증강 포션 (10원)");
				System.out.print("원하시는 물건을 입력하세요 : ");
				int buy = sc.nextInt();
				if (buy < 0 || buy > 5)
					System.out.print("\n구매할 수 없는 품목입니다.\n");
				else if (buy == 0)
					game_situation = 2;
				else {
					game_situation = myHero.potion_store(buy);
					if (game_situation == 2 && Missions.clear_buy_potion()) {
						myHero.add_exp(30);
					}
				}
				break;

			case 5: // 무기 상점
				System.out.println("무기 상점에 입장하였습니다.");
				System.out.printf("[%s 무기]", professions[numPf - 1]);
				System.out.println("\n0. 나가기");
				game_situation = myHero.weapon_store();
				if (game_situation == 2 && Missions.clear_buy_weapon()) {
					myHero.add_exp(70);
				}
				break;

			case 6: // 방어구 상점
				System.out.println("방어구 상점에 입장하였습니다.");
				System.out.println("[방어구]");
				System.out.println("0. 나가기");
				game_situation = myHero.armor_store();
				if (game_situation == 2 && Missions.clear_buy_armor()) {
					myHero.add_exp(70);
				}
				break;

			case 7: // 업적
				System.out.printf("[%s의 업적]\n", myHero.getName());
				String[] missions = { "너구리 사냥\t| 너구리를 1회 잡으세요.", "살쾡이 사냥\t| 살쾡이를 1회 잡으세요.", "들개 사냥\t| 들개를 1회 잡으세요.",
						"멧돼지 사냥\t| 멧돼지를 1회 잡으세요.", "포션 구매\t| 포션을 구매하세요.", "무기 구매\t| 무기를 구매하세요.",
						"방어구 구매\t| 방어구를 구매하세요.", "5레벨 달성\t| 5레벨을 달성하세요.", "10레벨 달성\t| 10레벨을 달성하세요." };
				boolean[] bool_missions = { Missions.get_hunting_raccoon(), Missions.get_hunting_lynx(),
						Missions.get_hunting_dog(), Missions.get_hunting_boar(), Missions.get_buy_potion(),
						Missions.get_buy_weapon(), Missions.get_buy_armor(), Missions.get_reach_level_5(),
						Missions.get_reach_level_10() };
				for (int i = 0; i < missions.length; i++) {
					System.out.printf("%s\t| %s\n", bool_missions[i] ? "[달성]" : "[미달성]", missions[i]);
				}
				game_situation = 2;

			}
			myHero.LevelUp();
			if (myHero.getLevel() == 5 && Missions.clear_reach_level_5()) {
				myHero.add_money(30);
			} else if (myHero.getLevel() == 10 && Missions.clear_reach_level_10()) {
				myHero.add_money(60);
			}
			System.out.println("*********************");
		}
	}
}
