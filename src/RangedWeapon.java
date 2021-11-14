public class RangedWeapon extends Weapon {

    public RangedWeapon(String name, int strength, int durability, WeaponType type) {
        super(name, strength, durability, WeaponType.RANGED);
    }

    @Override
    public int damage() {
        if (notDurable())
            return 0;

        if (miss())
            return 0;

        int maxDamage = strength + 10;
        int minDamage = strength - 10;
        durability -= DURABILITY_COST;

        return rand.nextInt(maxDamage - minDamage) + minDamage;
    }

    private boolean miss() {
        return rand.nextBoolean();
    }
}
