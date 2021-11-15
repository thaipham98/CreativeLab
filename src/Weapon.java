/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/


import java.util.Random;

/**
 * Represent a Weapon that can do some damage.
 * Weapon has an attack that returns a random number from some number to its strength,
 * but everytime the attack method is used it deducts 1 from durability.
 * If durability drops to 0, the weapon breaks and will only ever return 0 with its attack method.
 */
public abstract class Weapon implements WeaponInterface {

    protected static final int DURABILITY_COST = 1;
    protected static final Random rand = new Random();

    protected String name;
    protected int strength;
    protected int durability;
    protected WeaponType type;
    protected Hero hero;

    /**
     * Construct a weapon
     * @param name name of the weapon
     * @param strength strength of the weapon
     * @param durability durability of the weapon
     * @param type type of the weapon, from enum class, either MELEE, RANGED or MAGIC
     */
    public Weapon(String name, int strength, int durability, WeaponType type) {
        this.name = name;
        this.strength = strength;
        this.durability = durability;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", durability=" + durability +
//                ", hero=" + hero +
                '}';
    }

    @Override
    public boolean notDurable() {
        return durability <= 0;
    }

    @Override
    public void givenTo(Hero hero) {
        this.hero = hero;
    }

}
