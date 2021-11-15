/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/


/**
 * Represent a weapon that can do some damage
 */
public interface WeaponInterface {
    /**
     * The weapon damage that returns a random number from some number to its strength,
     * but everytime the attack method is used it deducts 1 from durability.
     * If durability drops to 0, the weapon breaks and will only ever return 0 with its attack method.
     * @return random integer from 0 to strength of weapon, unless the weapon is no longer durable
     */
    int damage();

    /**
     * Check if the durability of the weapon is below 0
     * @return if the weapon is not durable.
     */
    boolean notDurable();

    /**
     * The weapon is given to a hero. Set the hero's weapon to this weapon
     * @param hero the hero that uses the weapon
     */
    void givenTo(Hero hero);
}
