
/**
* Battle Arena
* Goals: Demonstrate how class can be within one file; 
* explore toString() overrides; show last ICE's solution; 
* further discuss the concept of objects
* Demonstrate the TODO tag
* To generate the to do list go to : Window -> Show View -> Tasks
*
* Author : Dr. G
* Date : 5/13/21
* Edited by: Thuytien Bui, NUID 001529311
* Edited on: Sep 30, 2021
*/

import java.util.Random;

//Game driver
//Notice it's the only class declared as public.
public class GameBattleDriver {
	public static void main(String[] args) {

		Character hero = new Character("Sparhawk", 40, 10);
		// System.out.println(Character.numChars);

		Character badguy = new Character("Gwerg", 100, 3);
		// System.out.println(Character.numChars);

		Character hero2 = new Character("Sparhawk", 40, 10);
		// System.out.println(Character.numChars);

		// BattleArena b1 = new BattleArena(hero, badguy);
		// b1.fight();

		

		// System.out.println(hero.attack());
		// System.out.println(hero.attack(45));

		// System.out.println(hero);
		// System.out.println(hero.toString());

		/* Create a weapon and "give it" to the hero to use */
		/* Add some print statements to print the weapon that was given to the hero */

		Weapon w1 = new Weapon("gun", 100, 12);
		hero.setWeapon(w1);
		System.out.println("Hero Weapon: ");
		System.out.println(hero.getWeapon().toString());
		
		// creative element Amour
		Amour a1 = new Amour("color amour", 20, 5);
		badguy.setAmour(a1);
		
		BattleArena.fight(hero, badguy);

	}
}

/**
 * Character class Generic RPG Character
 */
class Character {
	private String name;
	private int hitPoints;
	private int strength;
	private boolean alive;
	private Weapon w1;
	private Amour a1;

	public static int numChars = 0;

	/**
	 * Construct a character object initializing all variables other than alive and
	 * set alive to be true
	 * 
	 * @param name      - characters name
	 * @param hitPoints - initial set of hitPoints for our character
	 * @param strength  - initial strength of our character.
	 */
	public Character(String name, int hitPoints, int strength) {
		numChars++;
		alive = true;
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;

	}

	public void setWeapon(Weapon w1) {
		this.w1 = w1;
	}

	public Weapon getWeapon() {
		return this.w1;
	}
	
	public void setAmour(Amour a1) {
		this.a1 = a1;
	}

	public Amour getAmour() {
		return this.a1;
	}

	// These two attack methods are an example of method overloading....
	public int attack() {

		/* update this function to add the weapon attack */
		/* make sure weapon doesn't equal null before adding it */
		if (this.w1 == null) {
			return this.attack(this.strength);
		}
		return this.w1.attack();

	}

	public int attack(int strength) {
		Random r1 = new Random();

		return r1.nextInt(strength);
	}

	public void takeDamage(int damage) {
		if(this.a1 == null) {
			setHitPoints(hitPoints - damage);
		} else {
			setHitPoints(hitPoints - damage + this.a1.defend());
		}
		
	}

	/**
	 * Basic setter for hitPoints Assigns new value to character hitPoints
	 * 
	 * @param hitPoints
	 */
	public void setHitPoints(int hitPoints) {
		if (hitPoints <= 0) {
			this.hitPoints = 0;
			alive = false;
		} else {
			this.hitPoints = hitPoints;
		}
	}

	// The minimum getters needed for this to work skipping documentation for this.
	public String getName() {
		return name;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	/**
	 * Return the value of the alive status variable Allows outside objects to
	 * determine if current character is alive
	 * 
	 * @return value of alive status variable
	 */
	public boolean isAlive() {
		return alive;
	}

	/* Add a toString overload for character and test */
	@Override
	public String toString() {
		return "Character [name=" + name + ", hitPoints=" + hitPoints + ", strength=" + strength + ", alive=" + alive
				+ ", Weapon =" + w1.toString() + ", Amour =" + a1.toString() + " ]";
	}

}

/**
 * Battle Arena class object Facilitates an epic battle between two character
 * class objects
 */
class BattleArena {
	private Character c1;
	private Character c2;

	public BattleArena(Character c1, Character c2) {
		this.c1 = c1;
		this.c2 = c2;

		/*
		 * TODO Make the call to this manual instead of having it run by the constructor
		 */
		// fight();
	}

	/**
	 * Epic battle between two characters Method internal to class object
	 */
	public static void fight(Character c1, Character c2) {
		int damage = 0;
		// Random r1 = new Random();

		// Main game loop
		while (c1.isAlive() && c2.isAlive()) {

			// damage = r1.nextInt(c1.getStrength());

			damage = c1.attack();
			System.out.println(c1.getName() + " hits " + c2.getName() + " for " + damage);
			// c2.setHitPoints(c2.getHitPoints()-damage);
			c2.takeDamage(damage);
			System.out.println("Player2 hit point: " + c2.getHitPoints());

			// Pause for 2 seconds to add some suspense
			// This is an example of a checked exception. It won't work without it...
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Don't do damage if 2nd combatant was killed
			if (c2.isAlive()) {
				// damage = r1.nextInt(c2.getStrength());
				damage = c2.attack();
				System.out.println(c2.getName() + " hits " + c1.getName() + " for " + damage);
				// c1.setHitPoints(c1.getHitPoints() - damage);
				c1.takeDamage(damage);
				System.out.println("Player1 hit point" + c1.getHitPoints());
			}
		}

		System.out.print("Our winner is : ");

		// Report the winner
		if (c1.isAlive())
			System.out.println(c1.getName());
		else if (c2.isAlive())
			System.out.println(c2.getName());
	}

}

class Weapon {

	private String name;
	private int strength;
	private int durability;

	// add no argument constructor constructor*/
	public Weapon() {

	}

	// add three argument constructor*/
	public Weapon(String name, int strength, int durability) {
		this.name = name;
		this.strength = strength;
		this.durability = durability;
	}

	// create an attack method that returns a random value from 1 to weapon's
	// strength and deducts 1 from durability*/
	/* in the attack method if durability is 0 return 0 */
	public int attack() {
		if (this.durability == 0) {
			return 0;
		}

		Random rand = new Random();
		int att = rand.nextInt(strength);
		this.durability -= 1;
		return att;
	}

	/* create a toString override */
	@Override
	public String toString() {
		return "Weapon [name=" + name + ", strength=" + strength + ", durability=" + durability + "]";
	}
}

/* TODO Add one creative element all your own */
class Amour {
	private String name;
	private int strength;
	private int durability;

	// add no argument constructor constructor*/
	public Amour() {

	}

	// add three argument constructor*/
	public Amour(String name, int strength, int durability) {
		this.name = name;
		this.strength = strength;
		this.durability = durability;
	}

	// create an defend method that returns a random value from 1 to amour's
	// strength and deducts 1 from durability*/
	/* in the attack method if durability is 0 return 0 */
	public int defend() {
		if (this.durability == 0) {
			return 0;
		}

		Random rand = new Random();
		this.durability -= 1;
		return rand.nextInt(strength);
	}

	/* create a toString override */
	@Override
	public String toString() {
		return "Weapon [name=" + name + ", strength=" + strength + ", durability=" + durability + "]";
	}
}