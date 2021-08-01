package com.kiennguyen.project.problem1;

import java.util.List;

public interface Clist<K extends Comparable<K>> {
    void add (K arg);
    void addAll(List<K> args);
    void addAll(K[] i);
    K get(int i);
    void insertAt(K arg,int i);
    void remove();
    void removeAt(int i);
    int size();
    boolean contain(K arg);
    boolean isEmpty();
}
