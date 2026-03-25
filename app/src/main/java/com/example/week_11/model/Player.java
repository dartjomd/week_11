package com.example.week_11.model;


public class Player implements SoccerEntity {
    private String name;
    private int age;
    private String nationality;
    private String position;
    private String currentTeam;
    private int number;

    public Player(String name, int age, String nationality, String position, String currentTeam, int number) {
        // validate name
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

        // set attributes
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.currentTeam = currentTeam;
        this.number = number;
    }

    @Override
    public String getId() {
        return name + "_" + number;
    }

    @Override
    public String getName() {
        return name;
    }

    // getters
    public int getAge() { return age; }
    public String getPosition() { return position; }
    public String getCurrentTeam() { return currentTeam; }
}