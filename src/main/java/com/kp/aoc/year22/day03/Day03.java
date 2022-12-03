package com.kp.aoc.year22.day03;

import com.kp.aoc.Solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        Set<Character> priorityItems = findUniqueMatchingItems(comp_1, comp_2);

        if (priorityItems.size() > 1) {
            throw new RuntimeException("Found multiple priority items!");
        }

        return ITEM_PRIORITY.indexOf(priorityItems.iterator().next());
    }

    private static Set<Character> findUniqueMatchingItems(String container_1, String container_2) {
        Set<Character> matchingItems = new HashSet<>();

        for (char item : container_1.toCharArray()) {
            if (container_2.indexOf(item) != -1) {
                matchingItems.add(item);
            }
        }
        return matchingItems;
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
        String commonRucksackItems = findUniqueMatchingItems(rucksackGroup.get(0), rucksackGroup.get(1)).stream()
                .map(Object::toString)
                .collect(Collectors.joining());

        Set<Character> priorityItems = findUniqueMatchingItems(commonRucksackItems, rucksackGroup.get(2));

        if (priorityItems.size() > 1) {
            throw new RuntimeException("Found multiple priority items!");
        }

        return ITEM_PRIORITY.indexOf(priorityItems.iterator().next());
    }

    protected record Input(List<String> rucksacks) {
    }

}
