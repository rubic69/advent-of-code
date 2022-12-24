package com.kp.aoc.year22.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CathodeRayTubeTest {

    private CathodeRayTube solver;

    @BeforeEach
    void init() {
        solver = new CathodeRayTube();
    }

    @Test
    void test_part_1_sample() throws IOException {
        assertEquals(13140, Integer.parseInt(solver.solvePartOne(readInput("sample"))));
    }

    @Test
    void test_part_1_input() throws IOException {
        assertEquals(15120, Integer.parseInt(solver.solvePartOne(readInput("input"))));
    }

    @Test
    void test_part_2_sample() throws IOException {
        String expected = """
                ##..##..##..##..##..##..##..##..##..##..
                ###...###...###...###...###...###...###.
                ####....####....####....####....####....
                #####.....#####.....#####.....#####.....
                ######......######......######......####
                #######.......#######.......#######.....""";

        assertEquals(expected, solver.solvePartTwo(readInput("sample")));
    }

    @Test
    void test_part_2_input() throws IOException {
        String expected = """
                ###..#..#.###....##.###..###..#.....##..
                #..#.#.#..#..#....#.#..#.#..#.#....#..#.
                #..#.##...#..#....#.###..#..#.#....#..#.
                ###..#.#..###.....#.#..#.###..#....####.
                #.#..#.#..#....#..#.#..#.#....#....#..#.
                #..#.#..#.#.....##..###..#....####.#..#.""";

        assertEquals(expected, solver.solvePartTwo(readInput("input")));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day10/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }

}