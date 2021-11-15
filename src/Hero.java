public class Hero extends CharacterAbstract{
    private int mana;
    private Weapon w1;


    /**
     * Construct a character object initializing all variables other than alive and
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

    public void setWeapon(Weapon w1) {
        this.w1 = w1;
        w1.givenTo(this);
    }

    public Weapon getWeapon() {
        return this.w1;
    }

    public int getMana() {
        return this.mana;
    }

    // TODO: check on this, depends on weapon class
    public int attackWithWeapon(){
        /* update this function to add the weapon attack */
        /* make sure weapon doesn't equal null before adding it */
        if (this.w1 == null) {
            System.out.println("Hero is not holding a weapon. Deal regular damage");
            return this.attack();
        }
        return this.w1.damage();
    }

    // TODO: check on this, depends on weapon class
    public int specAttackWithWeapon(){
        if (this.w1 == null || !(w1 instanceof MagicWeapon)) {
            System.out.println("Hero is not holding magic weapon. Deal regular damage");
            return this.attack();
        }
        
        return ((MagicWeapon) this.w1).specialAttack();
    }

    @Override
    public String toString() {
        return "HERO " + super.toString() + ", mana = " + mana;
    }

    public void useMagic(int manaCost) {
        this.mana -= manaCost;
    }
}
