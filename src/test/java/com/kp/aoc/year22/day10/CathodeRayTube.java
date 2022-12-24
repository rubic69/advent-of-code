package com.kp.aoc.year22.day10;

import com.kp.aoc.Solver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CathodeRayTube implements Solver<List<String>, String> {

    // driven by precise clock circuit
    // ticks at constant time
    // each tick is called cycle

    // The CPU has a single register - X
    // X - starts with the value 1
    // It supports only two instructions:
    //  [addx V] takes two cycles to complete. After two cycles, the X register is increased by the value V. (V can be negative.)
    //  [noop] takes one cycle to complete. It has no other effect.

    @Override
    public String solvePartOne(List<String> input) {
        int result = 0;

        Set<Integer> cycles = Set.of(20, 60, 100, 140, 180, 220);

        int x = 1;
        int cycle = 0;

        for (String instruction : input) {
            cycle++;
            if (cycles.contains(cycle)) {
                System.out.println("Cycle [%d] X [%d]".formatted(cycle, x));
                result += cycle * x;
            }

            String[] instructionArgs = instruction.split(" ");

            if (instructionArgs.length == 2) {
                // addx
                cycle++;
                if (cycles.contains(cycle)) {
                    System.out.println("Cycle [%d] X [%d]".formatted(cycle, x));
                    result += cycle * x;
                }
                int value = Integer.parseInt(instructionArgs[1]);
                x += value;
            }
        }

        return String.valueOf(result);
    }

//gi

    @Override
    public String solvePartTwo(List<String> input) {
        StringBuilder crtScreen = new StringBuilder();

        int registerX = 1;
        String[] currentCommand = null;

        Iterator<String> commandIterator = input.iterator();

        for (int cycle = 0; cycle < 240; cycle++) {
            int rowCycle = cycle % 40;
            if (rowCycle == 0 && cycle != 0) {
                crtScreen.append("\n");
            }

            if (registerX - 1 <= rowCycle && rowCycle <= registerX + 1) {
                crtScreen.append('#');
            } else {
                crtScreen.append(".");
            }

            if (currentCommand == null) {
                if (!commandIterator.hasNext()) {
                    throw new UnsupportedOperationException("Not enough commands provided for 240 cycles");
                }

                String[] nextCommand = commandIterator.next().split(" ");
                if (nextCommand.length == 2) {
                    // two arguments found -> addx command
                    currentCommand = nextCommand;
                }
            } else {
                // finish addx command and reset
                int value = Integer.parseInt(currentCommand[1]);
                registerX += value;
                currentCommand = null;
            }
        }

        return crtScreen.toString();
    }

    private void lightPixel(int registerX, int rowCycle, StringBuilder crtScreen) {
        if (registerX - 1 <= rowCycle && rowCycle <= registerX + 1) {
            crtScreen.append('#');
        } else {
            crtScreen.append(".");
        }
    }

}
