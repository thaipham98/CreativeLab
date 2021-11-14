import java.util.Random;

public class Enemy extends CharacterAbstract{
    // TODO: change into phrases to badguy to speak
    String[] phrases = {"phrase1", "phrase2", "phrase3", "phrase4", "phrase5"};



    /**
     * Construct a character object initializing all variables other than alive and
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
//        System.out.println("random phrases");
        int damage = super.attack();
        return damage;

    }

    @Override
    public String toString() {
        return "HERO " + super.toString();
    }
}
