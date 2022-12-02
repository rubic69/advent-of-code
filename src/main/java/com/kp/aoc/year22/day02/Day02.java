package com.kp.aoc.year22.day02;

import com.kp.aoc.Solver;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.kp.aoc.year22.day02.HandShape.PAPER;
import static com.kp.aoc.year22.day02.HandShape.ROCK;
import static com.kp.aoc.year22.day02.HandShape.SCISSORS;

public class Day02 implements Solver<Day02.Input, Integer> {

    private static final Map<HandShape, HandShape> shapeWinsAgainst = new EnumMap<>(HandShape.class);
    private static final Map<HandShape, HandShape> shapeLoseAgainst = new EnumMap<>(HandShape.class);

    static {
        shapeWinsAgainst.put(ROCK, SCISSORS);
        shapeWinsAgainst.put(PAPER, ROCK);
        shapeWinsAgainst.put(SCISSORS, PAPER);

        shapeLoseAgainst.put(SCISSORS, ROCK);
        shapeLoseAgainst.put(ROCK, PAPER);
        shapeLoseAgainst.put(PAPER, SCISSORS);
    }

    @Override
    public Integer solvePartOne(Input input) {
        List<String[]> handShapes = input.handShapes();

        return handShapes.stream()
                .map(this::getScorePartOne)
                .reduce(0, Integer::sum);
    }

    private Integer getScorePartOne(String[] handShapePair) {
        HandShape opponentShape = HandShape.of(handShapePair[0].charAt(0));
        HandShape myShape = HandShape.of(handShapePair[1].charAt(0));

        if (opponentShape == myShape) {
            return Outcome.DRAW.getScore() + myShape.getShapeScore();
        }

        if (shapeWinsAgainst.get(opponentShape) == myShape) {
            return myShape.getShapeScore();
        } else {
            return Outcome.WIN.getScore() + myShape.getShapeScore();
        }
    }

    @Override
    public Integer solvePartTwo(Input input) {
        List<String[]> handShapes = input.handShapes();

        return handShapes.stream()
                .map(this::getScorePartTwo)
                .reduce(0, Integer::sum);
    }

    private Integer getScorePartTwo(String[] shapeAndOutcomePair) {
        HandShape opponentShape = HandShape.of(shapeAndOutcomePair[0].charAt(0));
        Outcome outcome = Outcome.get(shapeAndOutcomePair[1].charAt(0));

        switch (outcome) {
            case WIN -> {
                return outcome.getScore() + shapeLoseAgainst.get(opponentShape).getShapeScore();
            }
            case LOSE -> {
                return + outcome.getScore() + shapeWinsAgainst.get(opponentShape).getShapeScore();
            }
            case DRAW -> {
                return outcome.getScore() + opponentShape.getShapeScore();
            }
            default -> throw new UnsupportedOperationException("Shouldn't never happen because every case is covered");
        }
    }

    protected record Input(List<String[]> handShapes) {}

}
