public class MagicWeapon extends WeaponAbstract {

    private final int manaCost;

    public MagicWeapon(String name, int strength, int durability, int manaCost) {
        super(name, strength, durability, WeaponType.MAGIC);
        this.manaCost = manaCost;
    }

    @Override
    public int damage() {
       if (!notDurable())
           return 0;

       int minDamage = strength - 10;
       durability -= DURABILITY_COST;
       return rand.nextInt(strength - minDamage) + minDamage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int specialSkillManaCost() {
        return manaCost * 2;
    }

    public int specialAttack() {
        if (notDurable())
            return 0;

        durability -= DURABILITY_COST;
        return damage() * 2;
    }
}
