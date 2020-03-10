package com.company;

import java.util.ArrayList;
import java.util.Random;

public class BattleService {


    public ArrayList<String> fight(Units unit1, Units unit2) {
        FightLog fightLog = new FightLog();
        var fightLogs = new ArrayList<String>();
        Random random = new Random();
        int round = 1;
        int hp1 = unit1.getHealthPoints();
        int hp2 = unit2.getHealthPoints();
        while (hp1 > 0 & hp2 > 0) {
            fightLogs.add(
                    "Round " + round + "\n"
                            + unit1.getName() + " health points = " + hp1 + "\n"    //Заносим очки здоровья 1 и 2 юнита в fightLog
                            + unit2.getName() + " health points = " + hp2 + "\n");
            if (random.nextInt(2) == 1) {                                  //Рандомим шанс попадания 2 юнита по 1 юниту
                switch (random.nextInt(3)) {                              //рандомим количество урона по юниту
                    case 0:                                                      //наносит весь свой урон
                        hp1 -= unit2.getDamagePoints();
                        fightLogs.add(unit2.getName() + " was able to deal " + unit2.getDamagePoints() + " points of damage" + "\n");
                        break;
                    case 1:                                                     //наносит половину урона
                        hp1 -= unit2.getDamagePoints() / 2;
                        fightLogs.add(unit2.getName() +
                                " slipped on a banana peel and was able to deal " + unit2.getDamagePoints() / 2 + " points of damage" + "\n"); //причина, почему наносится то или иное количество урона
                        break;
                    case 2:                                                      //наносит четверть урона
                        hp1 -= unit2.getDamagePoints() / 4;
                        fightLogs.add(unit2.getName() +
                                " remembered that he was about to defend a diploma that had not even been written yet, and so he was terribly upset. He was able to deal "
                                + unit2.getDamagePoints() / 4 + " points of damage" + "\n");
                        break;
                }


            } else fightLogs.add(unit2.getName() + " missed");

            if (random.nextInt(2) == 0) {            //Рандомим шанс попадания 1 юнита по 2 юниту
                switch (random.nextInt(3)) {         //рандомим количество урона по юниту
                    case 0:                                //наносит весь свой урон
                        hp2 -= unit1.getDamagePoints();
                        fightLogs.add(unit1.getName() + " was able to deal " + unit1.getDamagePoints() + " points of damage" + "\n");
                        break;
                    case 1:                                //наносит половину урона
                        hp2 -= unit1.getDamagePoints() / 2;
                        fightLogs.add(unit1.getName() + " tripped over a rock and was able to deals " //причина, почему наносится то или иное количество урона
                                + unit1.getDamagePoints() / 2 + " points of damage" + "\n");
                        break;
                    case 2:                               //наносит четверть урона
                        hp2 -= unit1.getDamagePoints() / 4;
                        fightLogs.add(unit1.getName() +
                                " suddenly realized that he was just a set of ones and zeros, and so he was terribly upset. He was able to deal "
                                + unit1.getDamagePoints() / 4 + " points of damage" + "\n");
                        break;
                }

            } else fightLogs.add(unit1.getName() + " missed");
            round++;
        }


        if (hp1 < 0 & hp2 < 0) fightLogs.add("The battle is over with a draw");
        else if ((hp1 > hp2) & (hp1 > 0)) {
            fightLog.setWinner(unit1);
            fightLog.setLooser(unit2);
            fightLogs.add("The winner is " + fightLog.getWinner().getName());
            fightLogs.add("The looser is " + fightLog.getLooser().getName());
        } else {
            fightLog.setWinner(unit2);
            fightLog.setLooser(unit1);
            fightLogs.add("The winner is " + fightLog.getWinner().getName());
            fightLogs.add("The looser is " + fightLog.getLooser().getName());
        }

        return fightLogs;
    }
}
