package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InterFace {

    public void print(String[] fightLog) {
        for (String s : fightLog) {
            System.out.println(s);
        }



    }

    public void scan() {
        int userChoice;
        String enterName;
        int enterHealthPoints;
        int enterDamagePoints;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inter '0', to exit the program,\n" +
                "Inter '1', to create units,\n" +
                "Inter '2' to create units with random characters.\n");

        userChoice = scanner.nextInt();


        while (userChoice != 0) {
            if (userChoice == 1) {
                System.out.println("Enter the name of the first warrior : ");
                enterName = scanner.next();
                System.out.println("Enter the health points of the first warrior : ");
                enterHealthPoints = scanner.nextInt();
                System.out.println("Enter the damage points of the first warrior : ");
                enterDamagePoints = scanner.nextInt();
                Units unit1 = new Units(enterName, enterHealthPoints, enterDamagePoints);
                System.out.println("Enter the name of the second warrior: ");
                enterName = scanner.next();
                System.out.println("Enter the health points of the second warrior: ");
                enterHealthPoints = scanner.nextInt();
                System.out.println("Enter the damage points of the second warrior : ");
                enterDamagePoints = scanner.nextInt();
                Units unit2 = new Units(enterName, enterHealthPoints, enterDamagePoints);

                equalsMain(unit1, unit2);

            }

            if (userChoice == 2) {
                Random random = new Random();
                enterHealthPoints = random.nextInt(200) + 10;
                enterDamagePoints = random.nextInt(100) + 10;
                Units unit1 = new Units("Unit1", enterHealthPoints, enterDamagePoints);
                enterHealthPoints = random.nextInt(200) + 10;
                enterDamagePoints = random.nextInt(100) + 10;
                Units unit2 = new Units("Unit2", enterHealthPoints, enterDamagePoints);

                equalsMain(unit1, unit2);

            }

            if (userChoice > 2)
                System.out.println("You enter a wrong number. Try again");

            System.out.println("Inter '0', to exit the program,\n" +
                    "Inter '1', to create units,\n" +
                    "Inter '2' to create units with random characters.\n"
            );
            userChoice = scanner.nextInt();


        }

        System.out.println("GoodBye");
        scanner.close();
    }

    private void equalsMain(Units unit1, Units unit2) {
        BattleService battleService = new BattleService();
        String[] fightLogs = battleService.fight(unit1, unit2).toArray(new String[0]);
        print(fightLogs);
    }


}
