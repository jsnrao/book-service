package com.word.library.util;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String args[]) {
        List<String> test = new ArrayList<>();
            test.add("satya");
            test.add("Rao");
            test.add(1,"narayana");
            test.stream().forEach(System.out::println);

    }
}
