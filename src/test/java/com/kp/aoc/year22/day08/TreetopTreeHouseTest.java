package com.kp.aoc.year22.day08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreetopTreeHouseTest {

    private TreetopTreeHouse solver;

    @BeforeEach
    void init() {
        solver = new TreetopTreeHouse();
    }

    @Test
    void test_part_1_sample() throws IOException {
        assertEquals(21, solver.solvePartOne(readInput("sample")));
    }

    @Test
    void test_part_1_input() throws IOException {
        assertEquals(1823, solver.solvePartOne(readInput("input")));
    }

    @Test
    void test_part_2_sample() throws IOException {
        assertEquals(8, solver.solvePartTwo(readInput("sample")));
    }

    @Test
    void test_part_2_input() throws IOException {
        assertEquals(211680, solver.solvePartTwo(readInput("input")));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day08/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }

}