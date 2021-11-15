/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/


/**
 * Represent a melee weapon.
 * Melee is a weapon that has a high strength based special attack but takes a high durability cost.
 */
public class MeleeWeapon extends Weapon {

    private static final int DURABILITY_COST_SPECIAL = 3;

    /**
     * Construct a melee weapon with name, strength, durability and mana cost
     * @param name Name of the weapon
     * @param strength Strength of the weapon
     * @param durability Durability of the weapon
     */
    public MeleeWeapon(String name, int strength, int durability) {
        super(name, strength, durability, WeaponType.MELEE);
    }

    @Override
    public int damage() {
        if (notDurable()) return hero.attack();
        int minDamage = strength - 20;
        durability -= DURABILITY_COST;
        return rand.nextInt(strength - minDamage) + minDamage;
    }

    @Override
    public int specialAttack() {
        if (notDurable()) return hero.attack();
        int minDamage = strength - 10;
        durability -= DURABILITY_COST_SPECIAL;
        return rand.nextInt(strength + 5 - minDamage) + minDamage;
    }
}
