import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    public void fight() throws InterruptedException {


        Hero hero = chooseHero();
        Enemy enemy = chooseEnemy();

        if (hero == null || enemy == null) {
            System.out.println("Game is ended!");
            return;
        }
        // give weapon to hero
        // for each fight of hero:
        // which attack to choose.
        System.out.println("Fight between " + hero.getName() + " and " + enemy.getName());
        //sc.nextLine();
        boolean takeWeapon = wantWeapon();
        if (takeWeapon) {
            Weapon weapon = chooseWeapon();
            hero.setWeapon(weapon);
            System.out.println("Got weapon" + weapon);
            System.out.println("Hero takes" + hero.getWeapon());
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
            System.out.println(hero);
            System.out.println(enemy);
            AttackType typeAttack;
            if(takeWeapon){
                typeAttack = chooseAttack();
            } else{
                typeAttack = AttackType.REGULAR_ATTACK ;
            }


            int heroDamage = 0;
            if (typeAttack == AttackType.REGULAR_ATTACK) {
                heroDamage = hero.attack();
            } else if (typeAttack == AttackType.ATTACK_WITH_WEAPON) {
                heroDamage = hero.attackWithWeapon();
            } else if (typeAttack == AttackType.SPECIAL_SKILL) {
                heroDamage = hero.specAttackWithWeapon();
            }
            enemy.takeDamage(heroDamage);
            System.out.println(hero.getName() + " hits " + enemy.getName() + "for " + heroDamage + " damage.");
            //TimeUnit.SECONDS.sleep(1);
            int enemyDamage = enemy.attack();
            hero.takeDamage(enemyDamage);
            System.out.println(enemy.getName() + " hits " + hero.getName() + "for " + enemyDamage + " damage.");
            //TimeUnit.SECONDS.sleep(1);
        }

        // remove the dead character
        if (! hero.isAlive()){
            System.out.println("Hero " + hero.getName() + " is defeated");
            heroList.remove(hero);
        } else if (! enemy.isAlive()){
            System.out.println("Enemy " + enemy.getName() + " has been slain");
            enemyList.remove(enemy);
        }

        // check is there is any winner yet.
        if (!this.isThereWinner()) {
            this.fight();
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
        Scanner scWeapon = new Scanner(System.in);
        System.out.println("Do you want to use weapon? (y/n): ");

        String answer = scWeapon.nextLine();

        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.print("Please enter 'y' or 'n' only! ");
            System.out.println("Do you want to use weapon? (y/n): ");
            answer = scWeapon.nextLine();
        }

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
            System.out.println("Please choose a valid number from " + min + " to " + max);
            userInput = tryCatch(min, max);
        }

        return userInput;
    }

    private int tryCatch(int min, int max) {
        int userInput = 0;
        try {
            //Scanner sc2 = new Scanner(System.in);
            userInput = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Please provide a number: ");
            sc.next();
        }
        return userInput;
    }

    private boolean isValidInput(int userInput, int min, int max) {
        return userInput >= min && userInput <= max;
    }

    private boolean isThereWinner() {
        if (heroList.size() == 0) {
            System.out.println("Team enemy won!");
            try
            {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("src/losing_sound.wav")));
                DisplayImage("src/defeat_4x.jpg");
                clip.start();
                TimeUnit.SECONDS.sleep(5);
                System.exit(0);
            }

            catch (Exception exc)
            {
                exc.printStackTrace(System.out);
            }

            return true;
        }

        if (enemyList.size() == 0) {
            System.out.println("Team hero won!");
            try
            {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("src/winning_sound.wav")));
                DisplayImage("src/Victory+Easter.jpg");
                clip.start();
                TimeUnit.SECONDS.sleep(5);
                System.exit(0);
            }
            catch (Exception exc)
            {
                exc.printStackTrace(System.out);
            }

            return true;
        }

        System.out.println("Go to next round: ");
        return false;
    }

////    // Util classes
    public JFrame DisplayImage(String imagePath){
        JFrame f = new JFrame(); //creates jframe f

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //this is your screen size

        f.setUndecorated(true); //removes the surrounding border

        ImageIcon image = new ImageIcon(imagePath); //imports the image

        JLabel lbl = new JLabel(image); //puts the image into a jlabel

        f.getContentPane().add(lbl); //puts label inside the jframe

        f.setSize(image.getIconWidth(), image.getIconHeight()); //gets h and w of image and sets jframe to the size

        int x = (screenSize.width - f.getSize().width)/2; //These two lines are the dimensions
        int y = (screenSize.height - f.getSize().height)/2;//of the center of the screen

        f.setLocation(x, y); //sets the location of the jframe
        f.setVisible(true); //makes the jframe visible
        return f;
    }




}
