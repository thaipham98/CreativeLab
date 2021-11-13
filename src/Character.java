import java.util.Random;

/**
 * Character class Generic RPG Character
 */
public class Character {
    private String name;
    private int hitPoints;
    private int strength;
    private boolean alive;
    private Weapon w1;
    private Armour a1;

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

    public void setAmour(Armour a1) {
        this.a1 = a1;
    }

    public Armour getAmour() {
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