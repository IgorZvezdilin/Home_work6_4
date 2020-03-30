package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleService {

    public static final int ROLL_100_PERCENT = 100;
    public static final int ATTACK_CHANCE = 50;
    public static final int FULL_DAMAGE_CHANCE = 66;
    public static final int HALF_DAMAGE_CHANCE = 33;
    public static final int FIRST_ROUND_NUMBER = 1;
    public static final int HALF_DAMAGE_MODIFIER = 2;
    public static final int QUOTER_DAMAGE_MODIFIER = 4;
    public static final int MIN_ROLL_VALUE = 1;
    private int roundNumber =FIRST_ROUND_NUMBER;
    private static Random randomNumberGenerator = new Random();


    public List<String> fight(Units attacker, Units defender) {
        FightLog fightLog = new FightLog();
        ArrayList<String> fightLogs = new ArrayList<>();


        while (attacker.getCurrentHealth() > Units.MIN_HP && defender.getCurrentHealth() > Units.MIN_HP) {
            fightLogs.add(FightLog.buildInfoMessage(attacker, defender, roundNumber));
            increaseRoundNumber();
            if (successfulRoll(roll(ROLL_100_PERCENT), ATTACK_CHANCE)) performAttack(attacker, defender, fightLogs);
             else fightLogs.add(FightLog.buildMissedMessage(attacker));

            if (!successfulRoll(roll(ROLL_100_PERCENT), ATTACK_CHANCE)) {
                fightLogs.add(FightLog.buildContrAttackMessage(defender));
                performAttack(defender, attacker, fightLogs);
            } else fightLogs.add(FightLog.buildMissedMessage(defender));

        }

        checkWhoIsWinner(attacker, defender, fightLog, fightLogs);

        return fightLogs;


    }

    private void performAttack(Units attacker, Units defender, ArrayList<String> fightLogs) {
        int damage = calculateDamage(attacker.getDamagePoints(), roll(ROLL_100_PERCENT));
        doDamage(defender, damage);
        fightLogs.add(FightLog.buildDamageMessage(attacker, defender, damage));
    }

    private void checkWhoIsWinner(Units attacker, Units defender, FightLog fightLog, ArrayList<String> fightLogs) {
        if (attacker.getCurrentHealth() < Units.MIN_HP && defender.getCurrentHealth() < Units.MIN_HP)
            fightLogs.add(FightLog.buildDrawMessage());
        else if ((attacker.getCurrentHealth() > defender.getCurrentHealth()) && (attacker.getCurrentHealth() > Units.MIN_HP)) {
            fightLogs.add(FightLog.buildWinMessage(attacker));
            fightLogs.add(FightLog.buildLoseMessage(defender));
        } else {
            fightLogs.add(FightLog.buildWinMessage(defender));
            fightLogs.add(FightLog.buildLoseMessage(attacker));
        }
    }



    private void increaseRoundNumber() {
        roundNumber++;
    }


    private static int roll(int maxValue) {
        return randomNumberGenerator.nextInt(maxValue) + MIN_ROLL_VALUE;
    }

    private static int calculateDamage(int unitDamagePoints, int damageRollResult) {
        if (successfulRoll(roll(damageRollResult), FULL_DAMAGE_CHANCE))
            return unitDamagePoints;
        if (successfulRoll(roll(damageRollResult), HALF_DAMAGE_CHANCE))
            return unitDamagePoints / HALF_DAMAGE_MODIFIER;
        return unitDamagePoints / QUOTER_DAMAGE_MODIFIER;

    }

    private static boolean successfulRoll(int rollResult, int minimum) {
        return rollResult >= minimum;
    }

    private void doDamage(Units defender, int attackerDamage) {
        defender.decreaseCurrentHealth(attackerDamage);

    }


}
