import java.util.Random;

/* TODO Add one creative element all your own */
public class Armour {
    private String name;
    private int strength;
    private int durability;

    // add no argument constructor constructor*/
    public Armour() {

    }

    // add three argument constructor*/
    public Armour(String name, int strength, int durability) {
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