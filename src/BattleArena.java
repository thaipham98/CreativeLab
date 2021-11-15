import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleArena {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();
    private List<Hero> heroList;
    private List<Enemy> enemyList;
    private List<Weapon> weaponList;

    public BattleArena(List<Hero> heroList, List<Enemy> enemyList, List<Weapon> weaponList ){
        this.heroList = heroList;
        this.enemyList = enemyList;
        this.weaponList = weaponList;
    }

    public void fight(Hero hero, Enemy enemy){

        if (hero == null || enemy == null) {
            System.out.println("Game is ended!");
            return;
        }
        // give weapon to hero
        // for each fight of hero:
        // which attack to choose.

        if (wantWeapon()) {
            Weapon weapon = chooseWeapon();
            hero.setWeapon(weapon);
        }

        while (hero.isAlive() && enemy.isAlive() ){
            // for hero
            // print list of attacks to choose ( one of 3 attacks)
            // get use input on which attack: scanner getInt 1, 2, 3
            // switch case on use choice:

            // 1 = regular attack,
            // call regular attack
            // 2 = attack with weapon,
            // call attack with weapon
            // 3 = spec attack with weapon
            // call special attack with weapoon
            AttackType typeAttack = chooseAttack();
            int heroDamage = 0;
            if (typeAttack == AttackType.REGULAR_ATTACK) {
                heroDamage = hero.attack();
            } else if (typeAttack == AttackType.ATTACK_WITH_WEAPON) {
                heroDamage = hero.attackWithWeapon();
            } else if (typeAttack == AttackType.SPECIAL_SKILL) {
                heroDamage = hero.specAttackWithWeapon();
            }

            enemy.takeDamage(heroDamage);
            int enemyDamage = enemy.attack();
            hero.takeDamage(enemyDamage);
            System.out.println(hero.getName() + " hits " + enemy.getName());
        }

        // remove the dead character
        if (! hero.isAlive()){
            heroList.remove(hero);
        } else if (! enemy.isAlive()){
            enemyList.remove(enemy);
        }

        // check is there is any winner yet.
        if (!this.isThereWinner()) {
            this.fight(chooseHero(), chooseEnemy());
        }
    }

    private Enemy chooseEnemy(){
        if (enemyList.isEmpty()) {
            return null;
        }
        int randomIdx = rand.nextInt(enemyList.size());
        return enemyList.get(randomIdx);
    }

    private Hero chooseHero(){
        if (heroList.isEmpty()) {
            return null;
        }
        int randomIdx = rand.nextInt(heroList.size());
        return heroList.get(randomIdx);
    }

    private boolean wantWeapon() {
        System.out.println("Do you want to use weapon? (y/n): ");
        String answer = sc.nextLine();
        return answer.equals("y");
    }

    private void printOutListWeapon() {
        for (int i = 0; i < weaponList.size(); i++) {
            System.out.println((i + 1) + ": " + weaponList.get(i).toString());
        }
    }

    private Weapon chooseWeapon(){
        System.out.println("Input an integer to choose weapon from these: ");
        printOutListWeapon();
        int weaponChoice = getUserIntegerInput(1, weaponList.size());
        return weaponList.get(weaponChoice-1);
    }

    private AttackType chooseAttack() {
        int attackChoice;

        System.out.println("Choose attack type for hero: ");
        System.out.println("1: Regular attack");
        System.out.println("2: Attack with weapon");
        System.out.println("3: Special attack with weapon");

        attackChoice = getUserIntegerInput(1, 3);
        return AttackType.valueOf(attackChoice);
    }

    private int getUserIntegerInput(int min, int max) {
        int userInput = tryCatch(min, max);

        while (!isValidInput(userInput, min, max)) {
            userInput = tryCatch(min, max);
        }

        return userInput;
    }

    private int tryCatch(int min, int max) {
        int userInput = 0;
        try {
            userInput = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Please choose a valid number from " + min + " to " + max);
        }
        return userInput;
    }

    private boolean isValidInput(int userInput, int min, int max) {
        return userInput >= min && userInput <= max;
    }

    private boolean isThereWinner() {
        if (heroList.size() == 0) {
            System.out.println("Team hero won");
            return true;
        }

        if (enemyList.size() == 0) {
            System.out.println("Team enemy won");
            return true;
        }

        System.out.println("Go to next round: ");
        return false;
    }
}
