package com.kp.aoc.year22.day03;

import com.kp.aoc.Solver;
import com.kp.aoc.utils.CharUtils;

import java.util.ArrayList;
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

        Set<Character> priorityItems = CharUtils.set(comp_1);
        priorityItems.retainAll(CharUtils.set(comp_2));

        if (priorityItems.size() > 1) {
            throw new RuntimeException("Found multiple priority items!");
        }

        return ITEM_PRIORITY.indexOf(priorityItems.iterator().next());
    }

    @Override
    public Integer solvePartTwo(Input input) {
        return groupRucksacks(input).stream()
                .map(this::getPriority)
                .reduce(0, Integer::sum);
    }

    private static List<List<String>> groupRucksacks(Input input) {
        List<List<String>> rucksackGroups = new ArrayList<>();
        List<String> rucksackGroup = new ArrayList<>();

        input.rucksacks().forEach(rucksack -> {
            rucksackGroup.add(rucksack);
            if (rucksackGroup.size() == 3) {
                rucksackGroups.add(new ArrayList<>(rucksackGroup));
                rucksackGroup.clear();
            }
        });

        return rucksackGroups;
    }

    private int getPriority(List<String> rucksackGroup) {
        Set<Character> uniqueMatchingItems = CharUtils.set(rucksackGroup.get(0));
        uniqueMatchingItems.retainAll(CharUtils.set(rucksackGroup.get(1)));
        uniqueMatchingItems.retainAll(CharUtils.set(rucksackGroup.get(2)));

        if (uniqueMatchingItems.size() > 1) {
            throw new RuntimeException("Found multiple priority items!");
        }

        return ITEM_PRIORITY.indexOf(uniqueMatchingItems.iterator().next());
    }

    protected record Input(List<String> rucksacks) {
    }

}
