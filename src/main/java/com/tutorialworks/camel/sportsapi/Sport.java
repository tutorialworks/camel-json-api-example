package com.tutorialworks.camel.sportsapi;

public class Sport {

    private String name;
    private int players;
    private String league;

    public Sport() {
    }

    public Sport(String name, int players, String league) {
        this.name = name;
        this.players = players;
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", league='" + league + '\'' +
                '}';
    }
}
