import java.util.Random;

public abstract class CharacterAbstract implements ICharacter{
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
        Random r1 = new Random();
        return r1.nextInt(this.strength);
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

    @Override
    public String toString() {
        return "Character [name=" + name + ", hitPoints=" + hitPoints + ", strength=" + strength + ", alive=" + alive + "]";
    }

}
