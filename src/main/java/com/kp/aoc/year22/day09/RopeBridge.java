package com.kp.aoc.year22.day09;

import com.kp.aoc.Solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RopeBridge implements Solver<RopeBridge.Input, Integer> {

    private static final String DIRECTION_DELIMITER = " ";

    private static final String RIGHT = "R";
    private static final String LEFT = "L";
    private static final String UP = "U";
    private static final String DOWN = "D";

    private static final int HEAD_INDEX = 0;

    @Override
    public Integer solvePartOne(Input input) {
        return solvePartTwo(input);
    }

    @Override
    public Integer solvePartTwo(Input input) {
        Set<String> tailVisitedPositions = new HashSet<>();

        List<Knot> knots = preloadKnots(input.ropeLength());

        for (String moveInstruction : input.moveInstructions()) {
            String[] directionAndSteps = moveInstruction.split(DIRECTION_DELIMITER);
            var direction = directionAndSteps[0];
            var amountOfSteps = Integer.parseInt(directionAndSteps[1]);

            Knot head = knots.get(HEAD_INDEX);
            final int tailIndex = knots.size() - 1;

            for (int step = 0; step < amountOfSteps; step++) {
                head.move(direction);

                for (int knotIndex = 0; knotIndex < tailIndex; knotIndex++) {
                    Knot first = knots.get(knotIndex);
                    Knot second = knots.get(knotIndex + 1);
                    moveSecondAccordingToFirst(first, second);
                }

                tailVisitedPositions.add(knots.get(tailIndex).getCoordinates());
            }
        }

        return tailVisitedPositions.size();
    }

    private List<Knot> preloadKnots(int ropeLength) {
        if (ropeLength < 2) {
            throw new IllegalArgumentException("Rope length can't be shorter than 2 (H & T already takes two places)");
        }

        List<Knot> knots = new ArrayList<>(ropeLength);
        knots.add(new Knot("H"));

        for (int i = 1; i < ropeLength - 1; i++) {
            knots.add(new Knot(String.valueOf(i)));
        }

        knots.add(new Knot("T"));

        return knots;
    }

    public void moveSecondAccordingToFirst(Knot first, Knot second) {
        int xDiff = first.x - second.x;
        int yDiff = first.y - second.y;

        if (Math.abs(xDiff) <= 1 && Math.abs(yDiff) <= 1) {
            // In the range of [-1;-1] [1;1]
            return;
        }

        if (xDiff > 0) {
            second.moveRight();
        }

        if (xDiff < 0) {
            second.moveLeft();
        }

        if (yDiff > 0) {
            second.moveUp();
        }

        if (yDiff < 0) {
            second.moveDown();
        }
    }

    public record Input(int ropeLength, List<String> moveInstructions) {

    }

    public static class Knot {

        private final String id;
        private int x = 0;
        private int y = 0;

        public Knot(String id) {
            this.id = id;
        }

        public void move(String direction) {
            switch (direction) {
                case RIGHT -> moveRight();
                case LEFT -> moveLeft();
                case UP -> moveUp();
                case DOWN -> moveDown();
                default -> throw new UnsupportedOperationException();
            }
        }

        public void moveLeft() {
            x--;
        }

        public void moveRight() {
            x++;
        }

        public void moveUp() {
            y++;
        }

        public void moveDown() {
            y--;
        }

        public String getCoordinates() {
            return x + ":" + y;
        }

        @Override
        public String toString() {
            return "Knot{" +
                    "id='" + id + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
