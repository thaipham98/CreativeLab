import java.util.Random;

public abstract class WeaponAbstract implements WeaponInterface {

    protected static final int DURABILITY_COST = 1;
    protected static final Random rand = new Random();

    protected String name;
    protected int strength;
    protected int durability;
    protected WeaponType type;
    protected Hero hero;

    public WeaponAbstract(String name, int strength, int durability, WeaponType type, Hero hero) {
        this.name = name;
        this.strength = strength;
        this.durability = durability;
        this.type = type;
        this.hero = hero;
    }

    public WeaponAbstract(String name, int strength, int durability, WeaponType type) {
        this.name = name;
        this.strength = strength;
        this.durability = durability;
        this.type = type;
    }

    protected boolean notDurable() {
        return durability <= 0;
    }



}
