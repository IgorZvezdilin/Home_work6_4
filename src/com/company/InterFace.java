package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InterFace {

    private static final int PROGRAM_EXIT = 0;
    private static final int CREATURE_UNITS = 1;
    private static final int RANDOM_CREATURE_UNITS = 2;
    private static final int UNRESOLVED_VALUE = 3;
    private static final int MAX_HEALTH_POINTS_VALUE = 200;
    private static final int MAX_DAMAGE_POINTS_VALUE = 100;
    private static final int MIN_HP_AND_DP_VALUE = 10;
    private static final String INFO_MESSAGE = "Inter %d to exit the program,%n Inter %d to create units,%n Inter %d to create units with random characters.%n";
    private static final String ENTER_NAME = "Enter the name of the %s warrior : ";
    private static final String ENTER_HEALTH_POINTS = "Enter the health points of the %s warrior : ";
    private static final String ENTER_DAMAGE_POINTS = "Enter the damage points of the %s warrior : ";


    public void scan() {
        int userChoice;

        Scanner scanner = new Scanner(System.in);
        userChoice = getUserChoice(scanner);

        while (userChoice != PROGRAM_EXIT) {
            if (userChoice == CREATURE_UNITS)
                createUnitsAndOutputToTheScreen(getEnterNameWarrior(scanner, "first"), getEnterHealthPoints(scanner, "first"), getEnterDamagePoints(scanner, "first"), getEnterNameWarrior(scanner, "second"), getEnterHealthPoints(scanner, "second"), getEnterDamagePoints(scanner, "second"));

            if (userChoice == RANDOM_CREATURE_UNITS)
                createRandomUnitsAndOutputToTheScreen();

            if (userChoice >= UNRESOLVED_VALUE)
                System.out.println("You enter a wrong number. Try again");

            userChoice = getUserChoice(scanner);
        }

        System.out.println("GoodBye");
        scanner.close();
    }

    private void createRandomUnitsAndOutputToTheScreen() {
        Random random = new Random();
        Units unit1 = new Units("Unit1", random.nextInt(MAX_HEALTH_POINTS_VALUE) + MIN_HP_AND_DP_VALUE, random.nextInt(MAX_DAMAGE_POINTS_VALUE) + MIN_HP_AND_DP_VALUE);
        Units unit2 = new Units("Unit2", random.nextInt(MAX_HEALTH_POINTS_VALUE) + MIN_HP_AND_DP_VALUE, random.nextInt(MAX_DAMAGE_POINTS_VALUE) + MIN_HP_AND_DP_VALUE);
        equalsMain(unit1, unit2);
    }

    private void createUnitsAndOutputToTheScreen(String first, int first2, int first3, String second, int second2, int second3) {
        Units unit1 = new Units(first, first2, first3);
        Units unit2 = new Units(second, second2, second3);
        equalsMain(unit1, unit2);
    }

    private int getEnterDamagePoints(Scanner scanner, String number) {
        int enterDamagePoints;
        System.out.println(String.format(ENTER_DAMAGE_POINTS, number));
        enterDamagePoints = scanner.nextInt();
        return enterDamagePoints;
    }

    private int getEnterHealthPoints(Scanner scanner, String number) {
        int enterHealthPoints;
        System.out.println(String.format(ENTER_HEALTH_POINTS, number));
        enterHealthPoints = scanner.nextInt();
        return enterHealthPoints;
    }

    private String getEnterNameWarrior(Scanner scanner, String number) {
        String enterName;
        System.out.println(String.format(ENTER_NAME, number));
        enterName = scanner.next();
        return enterName;
    }

    private int getUserChoice(Scanner scanner) {
        int userChoice;
        buildInfoMessage();
        userChoice = scanner.nextInt();
        return userChoice;
    }

    public static void buildInfoMessage() {
        System.out.println(String.format(INFO_MESSAGE, PROGRAM_EXIT, CREATURE_UNITS, RANDOM_CREATURE_UNITS));

    }

    private void equalsMain(Units unit1, Units unit2) {
        BattleService battleService = new BattleService();
        ArrayList<String> fightLog = battleService.fight(unit1, unit2);
        System.out.println(fightLog);

    }


}
