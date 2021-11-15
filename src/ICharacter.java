/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/

/**
 * Represent a character in battle arena
 */
public interface ICharacter {

    /**
     * Represent an attack from a character
     * @return an integer from 1 to strength
     */
    int attack();

    /**
     * When character take damage, his hitPoint is deducted
     */
    void takeDamage(int damage);

    /**
     * Assigns new value to character's hitPoints
     * @param hitPoints hit point of a character
     */
    void setHitPoints(int hitPoints);

    /**
     * Get name of a character
     * @return name of character
     */
    String getName();

    /**
     * Get hit point of a character
     * @return hit point of the character
     */
    int getHitPoints();

    /**
     * Get strength of the character
     * @return Strength of the character
     */
    int getStrength();

    /**
     * Return the value of the alive status variable Allows outside objects to
     * determine if current character is alive
     *
     * @return value of alive status variable
     */
    boolean isAlive();

    /* Add a toString overload for character and test */
    /**
     * toString to for character, listing name, hitpoints, strength and whether he is alive
     * @return return a String to display information of character
     */
    String toString();

}
