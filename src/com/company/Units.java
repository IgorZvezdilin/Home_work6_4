package com.company;

public class Units {
    private String name;
    private int healthPoints;
    private int damagePoints;


    public Units(String name, int healthPoints, int damagePoints) {
        this.name = name;
        setHealthPoints(healthPoints);
        setDamagePoints(damagePoints);

    }

    private void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    private void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }


}


