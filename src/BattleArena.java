import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleArena {
    private static final Random rand = new Random();
    private List<Hero> heroList;
    private List<Enemy> enemyList;
    private List<Weapon> weaponList;

    public BattleArena(List<Hero> heroList, List<Enemy> enemyList ){
        this.heroList = heroList;
        this.enemyList = enemyList;
    }

    public void printOutListWeapon() {
        weaponList.stream().map(w -> w.toString());
    }

    public Enemy chooseEnemy(){
        int randomIdx = rand.nextInt(enemyList.size());
        return enemyList.get(randomIdx);
    }

    public Hero chooseHero(){
        int randomIdx = rand.nextInt(heroList.size());
        return heroList.get(randomIdx);
    }


    public static void fight(Hero hero, Weapon weapon, Enemy enemy){
        // give weapon to hero
        // for each fight of hero:
        // which attack to choose.

        if (wantWeapon()) {
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
            int damage = hero.attack();
            System.out.println(hero.getName() + " hits " + enemy.)
        }

    }

    private static boolean wantWeapon() {
        //yes
        //ask
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want to use weapon? (y/n): ");
        String answer = myObj.nextLine();

        return answer.equals('y');
    }

    public Weapon chooseWeapon(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose weapon from these: ");
        printOutListWeapon();



    }

    public void isWinner() {
        if (heroList.size() == 0) {
            System.out.println("Team hero won");
        }
        else if (enemyList.size() == 0) {
            System.out.println("Team enemy won");
        }
    }
















}
