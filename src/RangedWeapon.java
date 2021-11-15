/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/


/**
 * Represent a ranged weapon.
 * Ranged is a weapon that has a low strength based attack, but has a random chance of
 * doing more or less damage with its special attack(or missing entirely).
 */
public class RangedWeapon extends Weapon {

    /**
     * Construct a ranged weapon with name, strength, durability and mana cost
     * @param name Name of the weapon
     * @param strength Strength of the weapon
     * @param durability Durability of the weapon
     */
    public RangedWeapon(String name, int strength, int durability) {
        super(name, strength, durability, WeaponType.RANGED);
    }

    @Override
    public int damage() {
        if (notDurable())
            hero.attack();

        int minDamage = strength - 10;
        durability -= DURABILITY_COST;

        return rand.nextInt(strength - minDamage) + minDamage;
    }

    @Override
    public int specialAttack() {
        if (notDurable())
            hero.attack();

        if (miss())
            return 0;

        int maxDamage = strength + 15;
        int minDamage = strength - 10;
        durability -= DURABILITY_COST;

        return rand.nextInt(maxDamage - minDamage) + minDamage;
    }

    /**
     * The weapon randomly misses the attack. When missed, return 0 damage.
     * @return random boolean value
     */
    private boolean miss() {
        return rand.nextBoolean();
    }
}
