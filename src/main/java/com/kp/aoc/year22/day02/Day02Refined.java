package com.kp.aoc.year22.day02;

import com.kp.aoc.Solver;

public class Day02Refined implements Solver<Day02.Input, Integer> {

    private static final String OPPONENT_SHAPES = "ABC";
    private static final String MY_SHAPES = "XYZ";

    private static final int DRAW_SCORE = 3;
    private static final int WIN_SCORE = 6;

    private static final String OUTCOME_LOSE = "X";
    private static final String OUTCOME_DRAW = "Y";
    private static final String OUTCOME_WIN = "Z";

    //                             ╔═════════════════════════════════════╗
    //                             ║               Opponent              ║
    //                             ╠══════════╦═══════════╦══════════════╣
    //                             ║ (A) Rock ║ (B) Paper ║ (C) Scissors ║
    //                     ╔═══════╬══════════╬═══════════╬══════════════╣
    //                     ║ Index ║ 0        ║ 1         ║ 2            ║
    // ╔════╦══════════════╬═══════╬══════════╬═══════════╬══════════════╣
    // ║    ║ (X) Rock     ║ 0     ║ 0 (DRAW) ║ 2 (LOSE)  ║ 1 (WIN)      ║
    // ║    ╠══════════════╬═══════╬══════════╬═══════════╬══════════════╣
    // ║ Me ║ (Y) Paper    ║ 1     ║ 1 (WIN)  ║ 0 (DRAW)  ║ 2 (LOSE)     ║
    // ║    ╠══════════════╬═══════╬══════════╬═══════════╬══════════════╣
    // ║    ║ (Z) Scissors ║ 2     ║ 2 (LOSE) ║ 1 (WIN)   ║ 0 (DRAW)     ║
    // ╚════╩══════════════╩═══════╩══════════╩═══════════╩══════════════╝

    @Override
    public Integer solvePartOne(Day02.Input input) {
        return input.handShapes().stream()
                .map(this::calculateMatchScore)
                .reduce(0, Integer::sum);
    }

    private Integer calculateMatchScore(String[] handShapePair) {
        int opponentPowerIndex = OPPONENT_SHAPES.indexOf(handShapePair[0]);
        int myPowerIndex = MY_SHAPES.indexOf(handShapePair[1]);

        int shapeScore = myPowerIndex + 1;

        int roundOutcome = Math.floorMod(myPowerIndex - opponentPowerIndex, 3);

        return switch (roundOutcome) {
            case 1 -> WIN_SCORE + shapeScore;
            case 0 -> DRAW_SCORE + shapeScore;
            case 2 -> shapeScore;
            default -> throw new UnsupportedOperationException("Should never happen");
        };
    }

    // Win -> -1
    // Lose -> +1
    // Draw -> Doesn't matter
    //
    //  ╔═══════╦══════════╦═══════════╦══════════════╗
    //  ║       ║ (A) Rock ║ (B) Paper ║ (C) Scissors ║
    //  ╠═══════╬══════════╬═══════════╬══════════════╣
    //  ║ Index ║ 0        ║ 1         ║ 2            ║
    //  ╠═══════╬══════════╬═══════════╬══════════════╣
    //  ║ Win   ║ 2        ║ 0         ║ 1            ║
    //  ╠═══════╬══════════╬═══════════╬══════════════╣
    //  ║ Lose  ║ 1        ║ 2         ║ 0            ║
    //  ╠═══════╬══════════╬═══════════╬══════════════╣
    //  ║ Draw  ║ 0        ║ 1         ║ 2            ║
    //  ╚═══════╩══════════╩═══════════╩══════════════╝

    @Override
    public Integer solvePartTwo(Day02.Input input) {
        return input.handShapes().stream()
                .map(this::calculateCleverMatchScore)
                .reduce(0, Integer::sum);
    }

    private Integer calculateCleverMatchScore(String[] handShapeAndOutcomePair) {
        int opponentPowerIndex = OPPONENT_SHAPES.indexOf(handShapeAndOutcomePair[0]);

        return switch (handShapeAndOutcomePair[1]) {
            case OUTCOME_LOSE -> Math.floorMod(opponentPowerIndex - 1, 3) + 1;
            case OUTCOME_DRAW -> DRAW_SCORE + opponentPowerIndex + 1;
            case OUTCOME_WIN -> WIN_SCORE + Math.floorMod(opponentPowerIndex + 1, 3) + 1;
            default -> throw new UnsupportedOperationException("Should never happen");
        };
    }

}
