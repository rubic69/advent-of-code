package com.kp.aoc.utils;

import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class CharUtils {

    public static Set<Character> set(String string) {
        if (string == null) {
            return Set.of();
        }
        return string.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toSet());
    }

}
