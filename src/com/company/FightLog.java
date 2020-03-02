package com.company;

public class FightLog {
    private static final int BATTLE_HISTORY_SIZE = 50;
    private int lastEventIndex = 0;
    private String[] events = new String[BATTLE_HISTORY_SIZE];
    private Units winner;
    private Units looser;

    public void setWinner(Units winner) {
        this.winner = winner;
    }

    public void setLooser(Units looser) {
        this.looser = looser;
    }

    public int getLastEventIndex() {
        return lastEventIndex;
    }

    public Units getWinner() {
        return winner;
    }

    public Units getLooser() {
        return looser;
    }


    public void add(String event) {
        events[lastEventIndex] = event;
        if (lastEventIndex + 1 > events.length) {
            String[] temp = events;
            events = new String[temp.length + 20];
            for (int i = 0; i < temp.length; i++) {
                events[i] = temp[i];
            }

        }

        lastEventIndex++;
    }

    public String getEvents(int index) {
        return events[index];
    }

}
