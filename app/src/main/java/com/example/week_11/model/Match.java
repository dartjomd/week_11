package com.example.week_11.model;

public class Match implements SoccerEntity {
    private String homeTeam;
    private String awayTeam;
    private String score;
    private String date;
    private String stadium;

    // constructor
    public Match(String homeTeam, String awayTeam, String score, String date, String stadium) {

        // validation for null
        if (homeTeam == null || awayTeam == null) {
            throw new IllegalArgumentException("Teams cannot be null");
        }

        // set passed arguments
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.date = date;
        this.stadium = stadium;
    }

    @Override
    public String getId() { return homeTeam + "vs" + awayTeam; }

    @Override
    public String getName() { return homeTeam + " " + score + " " + awayTeam; }

    // getters
    public String getStadium() { return stadium; }
}