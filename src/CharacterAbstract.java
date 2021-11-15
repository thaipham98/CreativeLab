/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/

import java.util.Random;

public abstract class CharacterAbstract implements ICharacter{

    private static final Random rand = new Random();
    protected String name;
    protected int hitPoints;
    protected int strength;
    protected boolean alive;

    public static int numChars = 0;

    /**
     * Construct a character object initializing all variables other than alive and
     * set alive to be true
     *
     * @param name      - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength  - initial strength of our character.
     */
    public CharacterAbstract(String name, int hitPoints, int strength) {
        numChars++;
        alive = true;
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public int attack() {
        return rand.nextInt(this.strength) + 1;
    }

    @Override
    public void takeDamage(int damage) {
        setHitPoints(this.hitPoints - damage);
    }

    @Override
    public void setHitPoints(int hitPoints) {
        if (hitPoints <= 0) {
            this.hitPoints = 0;
            alive = false;
        } else {
            this.hitPoints = hitPoints;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    /**
     * Represent character's name, hit point, strength, alive status
     * @return a String with information about character's name, hit point, strength, alive status
     */
    @Override
    public String toString() {
        return "Character name=" + name + ", hitPoints=" + hitPoints + ", strength=" + strength + ", alive=" + alive ;
    }

}
