package com.company;

import java.util.function.Predicate;

public class RangePredicate <T extends Comparable> implements Predicate<T> {
    T begin, end;

    public RangePredicate(T begin, T end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public boolean test(T currentValue) {
        return currentValue.compareTo(begin) > 0 && currentValue.compareTo(end) < 0;
    }
}
