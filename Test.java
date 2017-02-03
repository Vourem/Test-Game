import java.util.Scanner;
import java.util.Random;


public class Test {
public static void main(String[] args) {
        new Test();
    }

    public static void slowPrintln(String text) {
        slowPrintln(text, 40);
    }

    public static void slowPrintln(String text, int ms) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(ms);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }


		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		String [] enemies = {"Zombie", "Rat", "Skeleton", "Vampire"};
		int maxEnemyHealth = 75;
		int enemyAttack = 25;

		int pHealth = 100;
		int pAttack = 50;
		int numHealthPots = 3;
		int healthPotHealAmt = 30;
		int healthPotDropChance = 50;

		boolean running = true;
{
		slowPrintln("Welcome to the Dungeon!");

		GAME:
		while (running) {

			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			slowPrintln(enemy + " appeared!\n");

			while(enemyHealth > 0) {
				slowPrintln("Your HP: " + pHealth);
				slowPrintln("" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\nWhat do?");
				System.out.println("[A]ttack");
				System.out.println("[H]eal");
				System.out.println("[F]lee");

				String input = in.nextLine();

				if (input.equals("A")) {
					int damageDealt = rand.nextInt(pAttack);
					int damageTaken = rand.nextInt(enemyAttack);

					enemyHealth -= damageDealt;
					pHealth -= damageTaken;
					
					slowPrintln("You slap the " + enemy + " and deal " + damageDealt + " damage!");
					slowPrintln(enemy + " attacks you!");
					slowPrintln("You take " + damageTaken + " damage.");

					if (pHealth < 1) {
						slowPrintln("You are too weak to go on! You've been defeated...");
						break;
					}
				}
				else if (input.equals("H")) {
					if (numHealthPots > 0) {
						pHealth += healthPotHealAmt;
						numHealthPots--;
						slowPrintln("You drink one health potion and restore " + healthPotHealAmt + " HP.");
						slowPrintln("You have " + numHealthPots + " health potions left.");
					}
					else {
						slowPrintln("You have no more health potions!");
					}
				}
				else if (input.equals("F")) {
					slowPrintln("You flee from the " + enemy + "!");
					continue GAME;
				}
				else if (input.equals("Q")) {
					System.exit(0);
				}
				else {
					slowPrintln("Whatever you're trying to do, you can't do it!");
				}
			}
			if (pHealth < 1) {
				slowPrintln("You limp out of the dungeon, weak from battle.");
				break;
			}
			
			slowPrintln("\n" + enemy + " has been defeated!\n");
			slowPrintln("You have " + pHealth + " HP left.");
			if (rand.nextInt(100) > healthPotDropChance) {
				numHealthPots++;
				slowPrintln(enemy + " has dropped a health potion!");
				slowPrintln("You now have " + numHealthPots + " health potions.");
			System.out.println("\n----------------------------\n");
			}

		}
	}
}
