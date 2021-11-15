import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

//Game driver
//Notice it's the only class declared as public.
public class GameBattleDriver {
	public static void main(String[] args) {

		Hero h1 = new Hero("Dawnbreaker", 100, 20,4  ); // Earthshaker, Kunkka, Mars
		Hero h2 = new Hero("Earthshaker", 80, 30, 5 );
		Hero h3 = new Hero("Kunkka", 150, 15, 6 );
		Hero h4 = new Hero("Mars", 70, 40, 7 );

		Enemy e1 = new Enemy("Pudge", 100, 30);
		Enemy e2 = new Enemy("Tusk", 120, 35);
		Enemy e3 = new Enemy("Underlord", 110, 40);
		Enemy e4 = new Enemy("Undying", 90, 35);

		//falcon blade, dagon, scythe of vyse, eternal shroud, Meteor Hammer, Ethereal blade, Abyssal Blade, Eye of Skadi
		Weapon p1 = new MagicWeapon("Falcon Blade", 40, 2, 2);
		Weapon p2 = new MagicWeapon("Dagon", 100, 2, 4);
		Weapon p3 = new MeleeWeapon("Scythe of Vyse", 150, 10);
		Weapon p4 = new RangedWeapon("Machine Gun", 40, 10);


		List<Hero> heroList = new ArrayList<>(
				List.of(h1, h2, h3, h4)
		);

		List<Weapon> weaponList = new ArrayList<>(
				List.of(p1, p2, p3, p4)
		);

		List<Enemy> enemyList = new ArrayList<>(
				List.of(e1, e2, e3, e4)
		);

		BattleArena arena = new BattleArena(heroList, enemyList, weaponList);



		arena.fight();

	}
}







