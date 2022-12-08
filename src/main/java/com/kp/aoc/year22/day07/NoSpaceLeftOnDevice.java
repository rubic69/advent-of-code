package com.kp.aoc.year22.day07;

import com.kp.aoc.Solver;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Log
public class NoSpaceLeftOnDevice implements Solver<List<String>, Integer> {

    private static final String ARGUMENT_DELIMITER = " ";

    private static final String COMMAND = "$";
    private static final String CHANGE_DIR = "cd";
    private static final String RETURN_DIR = "..";
    private static final String LIST_DIR = "ls";
    private static final String DIR = "dir";

    private static final int TOTAL_DISC_SIZE = 70_000_000;
    private static final int MIN_UPDATE_SIZE = 30_000_000;

    @Override
    public Integer solvePartOne(List<String> consoleHistory) {
        Dir rootDir = loadDirInfo(consoleHistory);

        return rootDir.flatList().stream()
                .skip(1)
                .map(Dir::getSize)
                .filter(size -> size <= 100000)
                .reduce(0, Integer::sum);
    }

    @Override
    public Integer solvePartTwo(List<String> consoleHistory) {
        Dir rootDir = loadDirInfo(consoleHistory);

        List<Dir> dirs = rootDir.flatList();

        int currentEmptySpace = TOTAL_DISC_SIZE - dirs.get(1).getSize();
        int missingSpaceForUpdate = MIN_UPDATE_SIZE - currentEmptySpace;

        return rootDir.flatList().stream()
                .skip(1)
                .map(Dir::getSize)
                .sorted(Comparator.comparingInt(o -> o))
                .filter(size -> size >= missingSpaceForUpdate)
                .findFirst()
                .orElseThrow();
    }

    // TODO: make this cycle more clear
    private static Dir loadDirInfo(List<String> consoleHistory) {
        Dir root = new Dir(null);
        Dir currentDir = root;

        for (String historyItem : consoleHistory) {
            String[] itemArguments = historyItem.split(ARGUMENT_DELIMITER);
            switch (itemArguments[0]) {
                case COMMAND -> {
                    switch (itemArguments[1]) {
                        case CHANGE_DIR -> {
                            if (RETURN_DIR.equals(itemArguments[2])) {
                                currentDir = currentDir.getParentDir();
                            } else {
                                Dir subDir = new Dir(itemArguments[2]);
                                currentDir.addSubDir(subDir);
                                currentDir = subDir;
                            }
                        }
                        case LIST_DIR -> currentDir.setSize(0);
                        default ->
                                throw new UnsupportedOperationException("Unsupported command [%s]".formatted(itemArguments[1]));
                    }
                }
                case DIR -> {
                    // ignore
                }
                default -> {
                    int fileSize = Integer.parseInt(itemArguments[0]);
                    currentDir.addSize(fileSize);
                }
            }
        }
        return root;
    }

    @RequiredArgsConstructor
    @Getter
    @Setter
    private static class Dir {

        private final String name;
        private int size;

        private Dir parentDir;
        private List<Dir> subDirs = new ArrayList<>();

        public void addSubDir(Dir subDir) {
            subDir.setParentDir(this);
            subDirs.add(subDir);
        }

        public void addSize(int sizeToAdd) {
            size += sizeToAdd;

            if (parentDir != null) {
                parentDir.addSize(sizeToAdd);
            }
        }

        // TODO: revisit this recursion solution
        public List<Dir> flatList() {
            List<Dir> flatList = new ArrayList<>();

            flatList.add(this);

            if (!subDirs.isEmpty()) {
                List<Dir> collect = subDirs.stream()
                        .map(Dir::flatList)
                        .flatMap(Collection::stream)
                        .toList();

                flatList.addAll(collect);

            }

            return flatList;
        }

    }
}
