public class MeleeWeapon extends WeaponAbstract {

    private static final int DURABILITY_COST = 3;

    public MeleeWeapon(String name, int strength, int durability) {
        super(name, strength, durability, WeaponType.MELEE);
    }

    @Override
    public int damage() {
        if (notDurable()) return 0;
        int minDamage = strength - 10;
        durability -= DURABILITY_COST;
        return rand.nextInt(strength - minDamage) + minDamage;
    }
}
