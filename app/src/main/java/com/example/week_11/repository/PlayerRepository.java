package com.example.week_11.repository;


import com.example.week_11.model.Player;
import java.util.List;

public class PlayerRepository extends Repository<Player> {

    // search for players
    public List<Player> findByPosition(String position) {

        // find player ignoring case
        return filter(p -> p.getPosition().equalsIgnoreCase(position));
    }
}