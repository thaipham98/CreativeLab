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

    private Enemy chooseEnemy(){
        int randomIdx = rand.nextInt(enemyList.size());
        return enemyList.get(randomIdx);
    }

    private Hero chooseHero(){
        int randomIdx = rand.nextInt(heroList.size());
        return heroList.get(randomIdx);
    }

    private boolean wantWeapon() {
        //yes
        //ask
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to use weapon? (y/n): ");
        String answer = myObj.nextLine();

        return answer.equals("y");
    }

    public void printOutListWeapon() {
//        weaponList.stream().map(w -> w.toString());
        for (int i = 0; i < weaponList.size(); i++) {
            System.out.println((i + 1) + ": " + weaponList.get(i).toString());
        }
        // 1: , 2:, 3: ...
    }


    private Weapon chooseWeapon(){
        System.out.println("Input an integer to choose weapon from these: ");
        printOutListWeapon();
        int weaponChoice = getUserIntegerInput(1, weaponList.size());
        return weaponList.get(weaponChoice-1);
    }


    public void fight(Hero hero, Enemy enemy){
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
        if (!this.isWinner()) {
            this.fight(chooseHero(), chooseEnemy());
        }
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


    private int getUserIntegerInput(int min, int max) throws IllegalArgumentException {
        int userInput = 0;

        try{
            userInput = sc.nextInt(); //aegeg
        } catch (Exception e) {
            // print(userInput) = 0
            System.out.println("Please choose a valid number from " + min + " to " + max);
        }

        while (!isValidInput(userInput, min, max)) {
            try{
                userInput = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please choose a valid number from " + min + " to " + max);
            }
        }

        if (userInput < min || userInput > max){
            throw new IllegalArgumentException("Please input a number between " + min + " and " + max);
        }
        return userInput;
    }

    private boolean isValidInput(int userInput, int min, int max) {
        return userInput >= min && userInput <= max;
    }


    public boolean isWinner() {
        if (heroList.size() == 0) {
            System.out.println("Team hero won");
            return true;
        }
        else if (enemyList.size() == 0) {
            System.out.println("Team enemy won");
            return true;
        }
        System.out.println("Go to next round: ");
        return false;
    }
















}
