/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/


/**
 * Represent a hero
 */
public class Hero extends CharacterAbstract{
    private int mana;
    private Weapon w1;


    /**
     * Construct a character hero object initializing all variables other than alive and
     * set alive to be true
     *
     * @param name      - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength  - initial strength of our character.
     */
    public Hero(String name, int hitPoints, int strength, int mana) {
        super(name, hitPoints, strength);
        this.mana = mana;
    }

    /**
     * Give weapon to hero
     * @param w1 Weapon to give hero
     */
    public void setWeapon(Weapon w1) {
        this.w1 = w1;
        w1.givenTo(this);
    }

    /**
     * Get hero's weapon
     * @return The weapon of hero
     */
    public Weapon getWeapon() {
        return this.w1;
    }

    /**
     * Get hero's mana
     * @return The mana of hero
     */
    public int getMana() {
        return this.mana;
    }

    /**
     * Attack enemy with weapon.
     * If weapon is no longer durable or if the hero doesnt have weapon,
     * use regular attack instead
     * @return damage from the attack with weapon
     */
    public int attackWithWeapon(){
        /* update this function to add the weapon attack */
        /* make sure weapon doesn't equal null before adding it */
        if (this.w1 == null) {
            System.out.println("Hero is not holding a weapon. Deal regular damage");
            return this.attack();
        }
        return this.w1.damage();
    }

    /**
     * Special attack with magic weapon that cost more mana but cost higher damage.
     * If the weapon is no longer durable or if the hero doesnt have weapon,
     * use regular attack instead
     * @return damage by special attack with magic weapon.
     */
    public int specAttackWithWeapon(){
        if (this.w1 == null ) { //|| !(w1 instanceof MagicWeapon)
            System.out.println("Hero is not holding weapon. Deal regular damage");
            return this.attack();
        }
        
        return this.w1.specialAttack();
    }

    @Override
    public String toString() {
        return "HERO " + super.toString() + ", mana = " + mana;
    }

    /**
     * If the hero use magic weapon, his mana is deducted
     * @param manaCost Mana cost by the magic weapon
     */
    public void useMagic(int manaCost) {
        this.mana -= manaCost;
    }
}
