package com.example.week_11.repository;


import com.example.week_11.model.Team;
import java.util.List;

public class TeamRepository extends Repository<Team> {

    // search method by league
    public List<Team> findByLeague(String league) {
        // use lambda
        return filter(team -> team.getName().contains(league));
    }
}