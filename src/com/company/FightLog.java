package com.company;

public class FightLog {
    private Units winner;
    private Units looser;


    public void setWinner(Units winner) {
        this.winner = winner;
    }

    public void setLooser(Units looser) {
        this.looser = looser;
    }

    public Units getWinner() {
        return winner;
    }

    public Units getLooser() {
        return looser;
    }



}
