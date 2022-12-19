package com.kp.aoc.year22.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RopeBridgeTest {

    private RopeBridge solver;

    @BeforeEach
    void init() {
        solver = new RopeBridge();
    }

    @Test
    void test_part_1_sample() throws IOException {
        assertEquals(13, solver.solvePartOne(new RopeBridge.Input(2, readInput("sample"))));
    }

    @Test
    void test_part_1_input() throws IOException {
        assertEquals(6175, solver.solvePartOne(new RopeBridge.Input(2, readInput("input"))));
    }

    @Test
    void test_part_2_sample() throws IOException {
        assertEquals(13, solver.solvePartTwo(new RopeBridge.Input(2, readInput("sample"))));
        assertEquals(1, solver.solvePartTwo(new RopeBridge.Input(10, readInput("sample"))));
        assertEquals(36, solver.solvePartTwo(new RopeBridge.Input(10, readInput("sample_2"))));
    }

    @Test
    void test_part_2_input() throws IOException {
        assertEquals(2578, solver.solvePartTwo(new RopeBridge.Input(10, readInput("input"))));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day09/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }

}