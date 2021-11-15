public interface ICharacter {

    /**
     * Attack
     * @return from 1 to strength
     */
    public int attack();

    /**
     * Take damage, hitPoint is deducted
     * @return
     */
    public void takeDamage(int damage);

    /**
     * Basic setter for hitPoints Assigns new value to character hitPoints
     *
     * @param hitPoints
     */
    public void setHitPoints(int hitPoints);

    // The minimum getters needed for this to work skipping documentation for this.
    public String getName();

    public int getHitPoints();

    public int getStrength();

    /**
     * Return the value of the alive status variable Allows outside objects to
     * determine if current character is alive
     *
     * @return value of alive status variable
     */
    public boolean isAlive();

    /* Add a toString overload for character and test */
    /**
     * toString to for character, listing name, hitpoints, strength and whether he is alive
     * @return
     */
    public String toString();

}
