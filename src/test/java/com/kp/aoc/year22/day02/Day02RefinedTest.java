package com.kp.aoc.year22.day02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Day02RefinedTest {

    private final Day02Refined solver = new Day02Refined();

    @Test
    void test_part_1_input_sample() throws IOException {
        List<String[]> input = readInput("part_1_sample");
        assertEquals(15, solver.solvePartOne(new Day02.Input(input)));
    }

    @Test
    void test_part_1_input() throws IOException {
        List<String[]> input = readInput("part_1_input");
        assertEquals(13924, solver.solvePartOne(new Day02.Input(input)));
    }

    private List<String[]> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day02/%s.txt".formatted(fileName));
        List<String> allLines = Files.readAllLines(path);
        return allLines.stream()
                .map(line -> line.split(" "))
                .collect(Collectors.toList());
    }

}