public class MagicWeapon extends Weapon {

    private final int manaCost;

    public MagicWeapon(String name, int strength, int durability, int manaCost) {
        super(name, strength, durability, WeaponType.MAGIC);
        this.manaCost = manaCost;
    }

    @Override
    public int damage() {
       if (notDurable() || hero.getMana() < manaCost) {
           System.out.println("Out of mana. Cannot use special skill, attack regularly!");
           return hero.attack();
       }

       int minDamage = strength - 10;
       durability -= DURABILITY_COST;
       hero.useMagic(manaCost);
       return rand.nextInt(strength - minDamage) + minDamage;
    }

    public int specialAttack() {
        if (notDurable() || hero.getMana() < manaCost) {
            System.out.println("Out of mana. Cannot use special skill, attack regularly!");
            return hero.attack();
        }

        hero.useMagic(2 * manaCost);
        durability -= DURABILITY_COST;
        return damage() * 2;
    }
}
