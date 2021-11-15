/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/

/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/


/**
 * Represent a magic weapon.
 * Magic is a weapon that uses very little durability, but deducts mana from the hero for every use.
 * If the hero runs out of mana, then it only returns 0.
 * It has a special attack that uses more mana, but does more damage.
 */
public class MagicWeapon extends Weapon {

    private final int manaCost;

    /**
     * Construct a magic weapon with name, strength, durability and mana cost
     * @param name Name of the weapon
     * @param strength Strength of the weapon
     * @param durability Durability of the weapon
     * @param manaCost Mana cost of the weapon
     */
    public MagicWeapon(String name, int strength, int durability, int manaCost) {
        super(name, strength, durability, WeaponType.MAGIC);
        this.manaCost = manaCost;
    }

    @Override
    public int damage() {
       if (notDurable()) {
           System.out.println("Weapon is not usable");
           return hero.attack();
       }

       if (hero.getMana() < manaCost) {
           System.out.println("Out of mana. Cannot use special skill, attack regularly!");
           return hero.attack();
       }

       int minDamage = strength - 10;
       durability -= DURABILITY_COST;
       hero.useMagic(manaCost);
       return rand.nextInt(strength - minDamage) + minDamage;
    }

    /**
     * Special attack that uses more mana, but does more damage.
     * @return damage of the special attack
     */
    public int specialAttack() {
        if (notDurable()) {
            System.out.println("Weapon is not usable");
            return hero.attack();
        }

        if (hero.getMana() < 2 * manaCost) {
            System.out.println("Out of mana. Cannot use special skill, attack regularly!");
            return hero.attack();
        }

        hero.useMagic(2 * manaCost);
        durability -= DURABILITY_COST;
        return damage() * 2;
    }
}
