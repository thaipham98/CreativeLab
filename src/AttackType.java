/*
Writtem by Thuytien Bui and Thai Pham.
Written on Nov 14, 2021
*/

import java.util.HashMap;
import java.util.Map;

/**
 * Represent attack type: regular attack, attack with weapon,
 * or special attack with weapon (only for magic weapon)
 */
public enum AttackType {
    REGULAR_ATTACK(1), ATTACK_WITH_WEAPON(2), SPECIAL_SKILL(3);

    private int value;
    private static Map map = new HashMap< >();

    /**
     * Construct the AttackType with an integer value from 1 to 3
     * @param attackType an integer from 1 to 3
     */
    private AttackType(int attackType) {
        this.value = attackType;
    }

    static {
        for (AttackType attackType: AttackType.values()) {
            map.put(attackType.value, attackType);
        }
    }

    /**
     * Return the AttackType when passing a suitable integer
     * @param attackType an integer from 1 to 3
     * @return AttackType: REGULAR_ATTACK(1), ATTACK_WITH_WEAPON(2) or SPECIAL_SKILL(3);
     */

    public static AttackType valueOf(int attackType) {
        return (AttackType) map.get(attackType);
    }
}
