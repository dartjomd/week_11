package com.example.week_11.model;


public class Team implements SoccerEntity {
    private String name;
    private String country;
    private String league;
    private String stadium;
    private int foundedYear;

    public Team(String name, String country, String league, String stadium, int foundedYear) {
        // validate team name
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Team name cannot be empty");

        // set attributes
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.foundedYear = foundedYear;
    }

    @Override
    public String getId() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    // getters
    public String getCountry() { return country; }
    public String getLeague() { return league; }
    public String getStadium() { return stadium; }
}