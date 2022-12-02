package com.kp.aoc.year22.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {

    private Day02 solver;

    @BeforeEach
    void init() {
        solver = new Day02();
    }

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

    @Test
    void test_part_2_input_sample() throws IOException {
        List<String[]> input = readInput("part_1_sample");
        assertEquals(12, solver.solvePartTwo(new Day02.Input(input)));
    }

    @Test
    void test_part_2_input() throws IOException {
        List<String[]> input = readInput("part_2_input");
        assertEquals(13448, solver.solvePartTwo(new Day02.Input(input)));
    }

    private List<String[]> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day02/%s.txt".formatted(fileName));
        List<String> allLines = Files.readAllLines(path);
        return allLines.stream()
                .map(line -> line.split(" "))
                .collect(Collectors.toList());
    }

}