package com.tutorialworks.camel.sportsapi;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SportService {

    private List<Sport> sports;

    public SportService() {
        sports = new ArrayList<>();
        sports.add(new Sport("Football"));
        sports.add(new Sport("Basketball"));
        sports.add(new Sport("Baseball"));
        sports.add(new Sport("Hockey"));
        sports.add(new Sport("Soccer"));
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void addSport(Sport sport) {
        sports.add(sport);
    }


}
