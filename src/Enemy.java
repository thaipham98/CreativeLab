/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/

import java.util.Random;

/**
 * Represent a bad guy or enemy
 */
public class Enemy extends CharacterAbstract{
    // TODO: change into phrases to badguy to speak
    String[] phrases = {"Your soul is mine", "What a weakling!", "On cooldown", "Ah-hah", "Did not ring a bell"};

    /**
     * Construct an enemy character object initializing all variables other than alive and
     * set alive to be true
     *
     * @param name      - characters name
     * @param hitPoints - initial set of hitPoints for our character
     * @param strength  - initial strength of our character.
     */
    public Enemy(String name, int hitPoints, int strength) {
        super(name, hitPoints, strength);
    }

    @Override
    public int attack(){
        Random r = new Random();
        System.out.println(phrases[r.nextInt(phrases.length)]);
        return super.attack();
    }

    @Override
    public String toString() {
        return "ENEMY " + super.toString();
    }
}
