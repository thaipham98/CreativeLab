import java.util.Random;

public class Weapon {

    private String name;
    private int strength;
    private int durability;

    // add no argument constructor constructor*/
    public Weapon() {

    }

    // add three argument constructor*/
    public Weapon(String name, int strength, int durability) {
        this.name = name;
        this.strength = strength;
        this.durability = durability;
    }

    // create an attack method that returns a random value from 1 to weapon's
    // strength and deducts 1 from durability*/
    /* in the attack method if durability is 0 return 0 */
    public int attack() {
        if (this.durability == 0) {
            return 0;
        }

        Random rand = new Random();
        int att = rand.nextInt(strength);
        this.durability -= 1;
        return att;
    }

    /* create a toString override */
    @Override
    public String toString() {
        return "Weapon [name=" + name + ", strength=" + strength + ", durability=" + durability + "]";
    }
}
