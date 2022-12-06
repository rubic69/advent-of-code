package com.kp.aoc.year22.day06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TuningTroubleTest {

    private TuningTrouble solver;

    @BeforeEach
    void setUp() {
        solver = new TuningTrouble();
    }

    @Test
    void test_part_1_sample() {
        assertEquals(7, solver.solvePartOne("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(5, solver.solvePartOne("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(6, solver.solvePartOne("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(10, solver.solvePartOne("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(11, solver.solvePartOne("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }

    @Test
    void test_part_1_input() throws IOException {
        assertEquals(1109, solver.solvePartOne(readInput("input").get(0)));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day06/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }
}