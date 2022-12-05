package com.kp.aoc.year22.day05;

import com.kp.aoc.Solver;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SupplyStacks implements Solver<List<String>, String> {

    private static final String EMPTY_LINE = "";

    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+)");

    private static final int INDEX_MOVE_AMOUNT = 0;
    private static final int INDEX_MOVE_FROM = 1;
    private static final int INDEX_MOVE_TO = 2;

    private static final int SPACE_BETWEEN_STACKS = 4;

    @Override
    public String solvePartOne(List<String> input) {
        int splitIndex = input.indexOf(EMPTY_LINE);

        Map<Integer, Deque<Character>> stackMap = prefillContainers(input.subList(0, splitIndex));

        input.subList(splitIndex + 1, input.size()).stream()
                .map(this::parseMove)
                .forEach(move -> IntStream.rangeClosed(1, move.amount())
                        .forEach(counter -> stackMap.get(move.to()).add(stackMap.get(move.from()).removeLast())));

        return getTopCrates(stackMap);
    }

    @Override
    public String solvePartTwo(List<String> input) {
        int split = input.indexOf(EMPTY_LINE);

        Map<Integer, Deque<Character>> stackMap = prefillContainers(input.subList(0, split));

        input.subList(split + 1, input.size()).stream()
                .map(this::parseMove)
                .forEach(move -> {
                    Deque<Character> temp = new ArrayDeque<>();
                    IntStream.rangeClosed(1, move.amount())
                            .forEach(counter -> temp.addFirst(stackMap.get(move.from()).removeLast()));
                    stackMap.get(move.to()).addAll(temp);
                });

        return getTopCrates(stackMap);
    }

    private static Map<Integer, Deque<Character>> prefillContainers(List<String> stacks) {
        Collections.reverse(stacks);
        String stackNumberLine = stacks.get(0);

        Map<Integer, Deque<Character>> stackMap = NUMBER_PATTERN.matcher(stackNumberLine)
                .results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .collect(Collectors.toMap(Function.identity(), ArrayDeque::new));

        stacks.stream()
                .skip(1)
                .forEach(stack -> {
                    AtomicInteger index = new AtomicInteger(1);

                    IntStream.rangeClosed(1, stackMap.size())
                            .forEach(containerNr -> {
                                if (stack.length() < index.get()) {
                                    return;
                                }

                                char crate = stack.charAt(index.get());
                                if (crate != ' ') {
                                    stackMap.get(containerNr).add(crate);
                                }

                                index.addAndGet(SPACE_BETWEEN_STACKS);
                            });
                });

        return stackMap;
    }

    private Move parseMove(String line) {
        Integer[] moveParameters = NUMBER_PATTERN.matcher(line)
                .results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        return new Move(moveParameters[INDEX_MOVE_AMOUNT], moveParameters[INDEX_MOVE_FROM], moveParameters[INDEX_MOVE_TO]);
    }

    private String getTopCrates(Map<Integer, Deque<Character>> stackMap) {
        return IntStream.rangeClosed(1, stackMap.size())
                .boxed()
                .map(stackMap::get)
                .map(Deque::getLast)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private record Move(int amount, int from, int to) {
    }
}
