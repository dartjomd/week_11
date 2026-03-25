package com.example.week_11.utils;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import com.example.week_11.model.Team;

public class TeamIterator implements Iterator<Team> {

    // lest with teams
    private List<Team> teams;

    // initial position
    private int position = 0;

    // constructor
    public TeamIterator(List<Team> teams) {
        this.teams = teams;
    }

    // check if there is next element
    @Override
    public boolean hasNext() {
        return position < teams.size();
    }

    // get next element if exists
    @Override
    public Team next() {
        if (!hasNext()) throw new NoSuchElementException();
        return teams.get(position++);
    }
}
