package com.example.week_11.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.example.week_11.model.SoccerEntity;


public class Repository<T extends SoccerEntity> {
    // data to store
    private final List<T> items = new ArrayList<>();

    // add new item to store
    public void add(T item) {
        if (item == null) return;
        items.add(item);
    }

    // get all items
    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    // filter method on passed condition
    public List<T> filter(Predicate<T> condition) {
        return items.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}