package com.kp.aoc.year22.day02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@RequiredArgsConstructor
public enum HandShape {

    ROCK(Set.of('A', 'X'), 1),
    PAPER(Set.of('B', 'Y'), 2),
    SCISSORS(Set.of('C', 'Z'), 3);

    private final Set<Character> abbreviations;
    @Getter
    private final int shapeScore;

    private static final Map<Character, HandShape> LOOKUP = new HashMap<>();

    static {
        for (HandShape handShape : HandShape.values()) {
            for (char abbreviation : handShape.abbreviations) {
                LOOKUP.put(abbreviation, handShape);
            }
        }
    }

    public static HandShape of(char abbreviation) {
        return LOOKUP.get(abbreviation);
    }

}
