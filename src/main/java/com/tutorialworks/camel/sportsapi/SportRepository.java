package com.tutorialworks.camel.sportsapi;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SportRepository {

    private List<Sport> sports;

    public SportRepository() {
        sports = new ArrayList<>();
        sports.add(new Sport("American Football", 11, "NFL"));
        sports.add(new Sport("Basketball", 5, "NBA"));
        sports.add(new Sport("Baseball", 9, "MLB"));
        sports.add(new Sport("Volleyball", 6, "NVA"));

    }

    public List<Sport> getSports() {
        return sports;
    }

    public void addSport(Sport sport) {
        sports.add(sport);
    }

}
