package com.company;

import java.util.Random;

public class BattleService {
    public FightLog fight(Units unit1, Units unit2) {
        FightLog fightLog = new FightLog();
        Random random = new Random();
        int round = 1;
        int hp1 = unit1.getHealthPoints();
        int hp2 = unit2.getHealthPoints();
        while (hp1 > 1 & hp2 > 1) {
            fightLog.add(
                    "Round " + round + "\n"
                            + unit1.getName() + " health points = " + hp1 + "\n"
                            + unit2.getName() + " health points = " + hp2 + "\n");
            if (random.nextInt(2) == 1) {
                switch (random.nextInt(3)) {
                    case 0:
                        hp1 -= unit2.getDamagePoints();
                        fightLog.add(unit2.getName() + " was able to deal " + unit2.getDamagePoints() + " points of damage" + "\n");
                        break;
                    case 1:
                        hp1 -= unit2.getDamagePoints() / 2;
                        fightLog.add(unit2.getName() +
                                " slipped on a banana peel and was able to deal " + unit2.getDamagePoints() / 2 + " points of damage" + "\n");
                        break;
                    case 2:
                        hp1 -= unit2.getDamagePoints() / 4;
                        fightLog.add(unit2.getName() +
                                " remembered that he was about to defend a diploma that had not even been written yet, and so he was terribly upset. He was able to deal "
                                + unit2.getDamagePoints() / 4 + " points of damage" + "\n");
                        break;
                }


            } else fightLog.add(unit2.getName() + " missed");

            if (random.nextInt(2) == 0) {
                switch (random.nextInt(3)) {
                    case 0:
                        hp2 -= unit1.getDamagePoints();
                        fightLog.add(unit1.getName() + " was able to deal " + unit1.getDamagePoints() + " points of damage" + "\n");
                        break;
                    case 1:
                        hp2 -= unit1.getDamagePoints() / 2;
                        fightLog.add(unit1.getName() + " tripped over a rock and was able to deals "
                                + unit1.getDamagePoints() / 2 + " points of damage" + "\n");
                        break;
                    case 2:
                        hp2 -= unit1.getDamagePoints() / 4;
                        fightLog.add(unit1.getName() +
                                " suddenly realized that he was just a set of ones and zeros, and so he was terribly upset. He was able to deal "
                                + unit1.getDamagePoints() / 4 + " points of damage" + "\n");
                        break;
                }

            } else fightLog.add(unit1.getName() + " missed");
            round++;
        }


        if (hp1 < 0 & hp2 < 0) fightLog.add("The battle is over with a draw");
        else if ((hp1 > hp2) & (hp1 > 0)) {
            fightLog.setWinner(unit1);
            fightLog.setLooser(unit2);
        } else {
            fightLog.setWinner(unit2);
            fightLog.setLooser(unit1);
        }


        return fightLog;
    }
}
