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
    public Hero(String name, int hitPoints, int strength) {
        super(name, hitPoints, strength);
    }

    public void setWeapon(Weapon w1) {
        this.w1 = w1;
    }

    public Weapon getWeapon() {
        return this.w1;
    }



    // TODO: check on this, depends on weapon class
    public int attackWithWeapon(){
        /* update this function to add the weapon attack */
        /* make sure weapon doesn't equal null before adding it */
        if (this.w1 == null) {
            return this.attack();
        }
        return this.w1.attack();
    }

    // TODO: check on this, depends on weapon class
    public int specAttackWithWeapon(){
        if (this.w1 == null) {
            return this.attack();
        }
        return this.w1.attack();
    }

    @Override
    public String toString() {
        return "HERO " + super.toString();
    }

    public void useMagic(int manaCost) {
         this.mana -= manaCost;
    }
}
