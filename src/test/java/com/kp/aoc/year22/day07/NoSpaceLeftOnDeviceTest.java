package com.kp.aoc.year22.day07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoSpaceLeftOnDeviceTest {

    private NoSpaceLeftOnDevice solver;

    @BeforeEach
    void setUp() {
        solver = new NoSpaceLeftOnDevice();
    }

    @Test
    void test_part_1_sample() throws IOException {
        assertEquals(95437, solver.solvePartOne(readInput("sample")));
    }

    @Test
    void test_part_1_input() throws IOException {
        assertEquals(1118405, solver.solvePartOne(readInput("input")));
    }

    @Test
    void test_part_2_sample() throws IOException {
        assertEquals(24933642, solver.solvePartTwo(readInput("sample")));
    }

    @Test
    void test_part_2_input() throws IOException {
        assertEquals(12545514, solver.solvePartTwo(readInput("input")));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day07/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }

}