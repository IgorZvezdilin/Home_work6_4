package com.company;

public class FightLog {
    private static final String DAMAGE_MESSAGE = " %n %s deal %s damage to %s";
    private static final String MISSED_MESSAGE = "%n %s missed %n";
    private static final String CONTRATTACK_MESSAGE = "%n %s tries to contrattack ";
    private static final String DRAW_MESSAGE = "%n The battle is over with a draw ";
    private static final String WIN_MESSAGE = "%n %s won!!!";
    private static final String LOSE_MESSAGE = "%n %s lost!!!";
    private static final String INFO_MESSAGE = "%n Round %d %n, %s has %s HP remaining and %s has %s HP remaining ";

    public static String buildInfoMessage(Units unit1, Units unit2, int roundNumber) {
        return String.format(INFO_MESSAGE, roundNumber, unit1.getName(), unit1.getCurrentHealth(), unit2.getName(), unit2.getCurrentHealth());
    }

    public static String buildDamageMessage(Units attacker, Units defender, int damagePoints) {
        return String.format(DAMAGE_MESSAGE, attacker.getName(), damagePoints, defender.getName());
    }

    public static String buildMissedMessage(Units attacker) {
        return String.format(MISSED_MESSAGE, attacker.getName());
    }

    public static String buildContrAttackMessage(Units defender) {
        return String.format(CONTRATTACK_MESSAGE, defender.getName());
    }

    public static String buildDrawMessage() {
        return DRAW_MESSAGE;
    }

    public static String buildWinMessage(Units winner) {
        return String.format(WIN_MESSAGE, winner.getName());
    }

    public static String buildLoseMessage(Units looser) {
        return String.format(LOSE_MESSAGE, looser.getName());
    }


}
