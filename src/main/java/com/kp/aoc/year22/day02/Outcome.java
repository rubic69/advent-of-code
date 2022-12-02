package com.kp.aoc.year22.day02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public enum Outcome {

    WIN('Z', 6),
    LOSE('X', 0),
    DRAW('Y', 3);

    private final char abbreviation;

    @Getter
    private final int score;

    private static final Map<Character, Outcome> LOOKUP = new HashMap<>();

    static {
        for (Outcome outcome : Outcome.values()) {
            LOOKUP.put(outcome.abbreviation, outcome);
        }
    }

    public static Outcome get(char abbreviation) {
        return LOOKUP.get(abbreviation);
    }

}
