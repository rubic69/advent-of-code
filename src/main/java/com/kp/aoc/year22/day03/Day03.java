package com.kp.aoc.year22.day03;

import com.kp.aoc.Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day03 implements Solver<Day03.Input, Integer> {

    private final static String ITEM_PRIORITY = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public Integer solvePartOne(Input input) {
        return input.rucksacks().stream()
                .map(this::getPrioritySum)
                .reduce(0, Integer::sum);
    }

    private int getPrioritySum(String rucksack) {
        String comp_1 = rucksack.substring(0, rucksack.length() / 2);
        String comp_2 = rucksack.substring(rucksack.length() / 2);

        Set<Character> matchingItems = new HashSet<>();

        for (char item : comp_1.toCharArray()) {
            if (comp_2.indexOf(item) != -1) {
                matchingItems.add(item);
            }
        }

        return matchingItems.stream()
                .map(ITEM_PRIORITY::indexOf)
                .reduce(0, Integer::sum);
    }

    protected record Input(List<String> rucksacks) {}

}
