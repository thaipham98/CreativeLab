public class MagicWeapon extends Weapon {

    private final int manaCost;

    public MagicWeapon(String name, int strength, int durability, int manaCost, Hero hero) {
        super(name, strength, durability, WeaponType.MAGIC, hero);
        this.manaCost = manaCost;
    }

    @Override
    public int damage() {
       if (!notDurable())
           return 0;

       int minDamage = strength - 10;
       durability -= DURABILITY_COST;
       hero.useMagic(manaCost);
       return rand.nextInt(strength - minDamage) + minDamage;
    }

    public int specialAttack() {
        if (notDurable())
            return 0;
        hero.useMagic(2 * manaCost);
        durability -= DURABILITY_COST;
        return damage() * 2;
    }
}
