package com.kp.aoc.year22.day03;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    private final Day03 solver = new Day03();

    @Test
    void test_part_1_input_sample() throws IOException {
        List<String> rucksacks = readInput("part_1_sample");
        assertEquals(157, solver.solvePartOne(new Day03.Input(rucksacks)));
    }

    @Test
    void test_part_1_input() throws IOException {
        List<String> rucksacks = readInput("part_1_input");
        assertEquals(8018, solver.solvePartOne(new Day03.Input(rucksacks)));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day03/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }

}