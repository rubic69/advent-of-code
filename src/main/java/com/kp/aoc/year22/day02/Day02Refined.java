package com.kp.aoc.year22.day02;

import com.kp.aoc.Solver;

import java.util.List;

public class Day02Refined implements Solver<Day02.Input, Integer> {

    private static final String OPPONENT_SHAPES = "ABC";
    private static final String MY_SHAPES = "XYZ";

    private static final int DRAW_SCORE = 3;
    private static final int WIN_SCORE = 6;

    /**
     *                    +----------+-----------+--------------+
     *                    | Rock (A) | Paper (B) | Scissors (C) |
     *                    +----------+-----------+--------------+
     *                    | 0        |  1        |  2           |
     * +--------------+---+----------+-----------+--------------+
     * | Rock (X)     | 0 | 0        | -1        | -2           |
     * +--------------+---+----------+-----------+--------------+
     * | Paper (Y)    | 1 | 1        |  0        | -1           |
     * +--------------+---+----------+-----------+--------------+
     * | Scissors (Z) | 2 | 2        |  1        |  0           |
     * +--------------+---+----------+-----------+--------------+
     * <p>
     * Draw -> 0
     * Win -> -2 & 1
     * Lose -> anything else (-1, 2)
     */
    @Override
    public Integer solvePartOne(Day02.Input input) {
        List<String[]> allHandShapes = input.handShapes();

        return allHandShapes.stream()
                .map(this::calculateMatchScore)
                .reduce(0, Integer::sum);
    }

    private Integer calculateMatchScore(String[] handShapes) {
        int opponentPowerIndex = OPPONENT_SHAPES.indexOf(handShapes[0]);
        int myPowerIndex = MY_SHAPES.indexOf(handShapes[1]);

        int shapeScore = myPowerIndex + 1;

        return switch (myPowerIndex - opponentPowerIndex) {
            case -2, 1 -> WIN_SCORE + shapeScore;
            case 0 -> DRAW_SCORE + shapeScore;
            default -> shapeScore;
        };
    }
}
