import java.util.HashMap;
import java.util.Map;

public enum AttackType {
    REGULAR_ATTACK(1), ATTACK_WITH_WEAPON(2), SPECIAL_SKILL(3);

    private int value;
    private static Map map = new HashMap< >();

    private AttackType(int attackType) {
        this.value = attackType;
    }

    static {
        for (AttackType attackType: AttackType.values()) {
            map.put(attackType.value, attackType);
        }
    }

    public static AttackType valueOf(int attackType) {
        return (AttackType) map.get(attackType);
    }
}
