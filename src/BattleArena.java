import java.util.List;
import java.util.Random;

public class BattleArena {
    private static final Random rand = new Random();
    private List<Hero> heroList;
    private List<Enemy> enemyList;

    public BattleArena(List<Hero> heroList, List<Enemy> enemyList ){
        this.heroList = heroList;
        this.enemyList = enemyList;
    }

    public Enemy chooseEnemy(){
        int randomIdx = rand.nextInt(enemyList.size());
        return enemyList.get(randomIdx);
    }

    public Hero chooseHero(){
        int randomIdx = rand.nextInt(heroList.size());
        return heroList.get(randomIdx);
    }


    public static void fight(Hero hero, Enemy enemy){
        // give weapon to hero
        // for each fight of hero:
        // which attack to choose.





        while (hero.isAlive() && enemy.isAlive() ){
            int damage = hero.attack();
            System.out.println(hero.getName() + " hits " + enemy.)
        }

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
