package com.kp.aoc.year22.day08;

import com.kp.aoc.Solver;

import java.util.List;

public class TreetopTreeHouse implements Solver<List<String>, Integer> {

    private static final int ALL = -1;

    @Override
    public Integer solvePartOne(List<String> input) {
        int[][] forestMatrix = toArray2D(input);

        int forestSize = input.size();

        int visibleTrees = forestSize * 4 - 4;

        for (int y = 1; y < forestSize - 1; y++) {
            for (int x = 1; x < forestSize - 1; x++) {
                if (isVisibleFromLeastOneSide(forestMatrix, y, x)) {
                    visibleTrees++;
                }
            }
        }

        return visibleTrees;
    }

    private boolean isVisibleFromLeastOneSide(int[][] forestMatrix, int y, int x) {
        return countVisibleTreesOnLeft(x, y, forestMatrix) == ALL
                || countVisibleTreesOnRight(x, y, forestMatrix) == ALL
                || countVisibleTreesOnTop(x, y, forestMatrix) == ALL
                || countVisibleTreesOnBottom(x, y, forestMatrix) == ALL;
    }

    @Override
    public Integer solvePartTwo(List<String> input) {
        int[][] forestMatrix = toArray2D(input);

        int forestSize = input.size();

        int score = 0;

        for (int y = 1; y < forestSize - 1; y++) {
            for (int x = 1; x < forestSize - 1; x++) {
                int treesVisibleOnLeft = countVisibleTreesOnLeft(x, y, forestMatrix);
                int leftCount = treesVisibleOnLeft == ALL ? x : treesVisibleOnLeft;

                int treesVisibleOnRight = countVisibleTreesOnRight(x, y, forestMatrix);
                int rightCount = treesVisibleOnRight == ALL ? forestSize - x - 1 : treesVisibleOnRight;

                int treesVisibleOnTop = countVisibleTreesOnTop(x, y, forestMatrix);
                int topCount = treesVisibleOnTop == ALL ? y : treesVisibleOnTop;

                int treesVisibleOnBottom = countVisibleTreesOnBottom(x, y, forestMatrix);
                int bottomCount = treesVisibleOnBottom == ALL ? forestSize - y - 1 : treesVisibleOnBottom;

                int currentScore = leftCount * rightCount * topCount * bottomCount;

                if (currentScore > score) {
                    score = currentScore;
                }
            }
        }

        return score;
    }

    private int[][] toArray2D(List<String> lines) {
        int[][] array = new int[lines.size()][lines.get(0).length()];

        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                array[y][x] = Character.getNumericValue(lines.get(y).charAt(x));
            }
        }

        return array;
    }

    private int countVisibleTreesOnLeft(int x, int y, int[][] forestMatrix) {
        for (int index = 1; index < x + 1; index++) {
            if (forestMatrix[y][x - index] >= forestMatrix[y][x]) {
                return index;
            }
        }

        return ALL;
    }

    private int countVisibleTreesOnRight(int x, int y, int[][] forestMatrix) {
        for (int index = 1; index < forestMatrix[y].length - x; index++) {
            if (forestMatrix[y][x + index] >= forestMatrix[y][x]) {
                return index;
            }
        }

        return ALL;
    }

    private int countVisibleTreesOnTop(int x, int y, int[][] forestMatrix) {
        for (int index = 1; index < y + 1; index++) {
            if (forestMatrix[y - index][x] >= forestMatrix[y][x]) {
                return index;
            }
        }

        return ALL;
    }

    private int countVisibleTreesOnBottom(int x, int y, int[][] forestMatrix) {
        for (int index = 1; index < forestMatrix.length - y; index++) {
            if (forestMatrix[y + index][x] >= forestMatrix[y][x]) {
                return index;
            }
        }

        return ALL;
    }

}
