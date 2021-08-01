package com.kiennguyen.project.problem1.impl;

import com.kiennguyen.project.problem1.Clist;

import java.util.Arrays;
import java.util.List;

public class ArrayList<K extends Comparable<K>> implements Clist<K> {
    private static final int FIRST_START = 0;
    private static final int DEFAULT_ARRAY = 1;
    private Object[] arrayOfK;
    private int size,flag;




    public ArrayList() {
        this.arrayOfK = new Object[DEFAULT_ARRAY];
        this.flag = FIRST_START;
        this.size = DEFAULT_ARRAY;
    }

    public ArrayList(int size) {
        this.size = size;
        this.flag = FIRST_START;
        this.arrayOfK = new Object[size];
    }

    @Override
    public void add(K arg) {
        arrayOfK[flag] = arg;
        if(flag == size-1){
            size++;
        }
        flag++;
        arrayOfK = Arrays.copyOf(arrayOfK,size);

    }

    @Override
    public void addAll(List<K> args) {
        Object[] array =  args.toArray();
        for (Object o: array) {
            add((K) o);
        }
    }

    @Override
    public void addAll(K[] i) {
        for (Object o: i) {
            add((K) o);
        }
    }

    @Override
    public K get(int i) {
        return (K) arrayOfK[i];
    }

    @Override
    public void insertAt(K arg, int i) {
        if( i< 0 || i > flag) {
            throw new IllegalArgumentException("index khong hop le");
        }else {
            Object[] temporyArray = Arrays.copyOfRange(arrayOfK, i, flag);
            arrayOfK[i] = arg;
            if (flag == size - 1) {
                size++;
            }
            flag++;
            arrayOfK = Arrays.copyOf(arrayOfK, size);



            int a = 0;
            for (i = i + 1; i < flag; i++) {
                arrayOfK[i] = temporyArray[a];
                a++;
            }
        }
    }

    @Override
    public void remove() {
        this.arrayOfK = new Object[DEFAULT_ARRAY];
        this.flag = FIRST_START;
        this.size = DEFAULT_ARRAY;
    }

    @Override
    public void removeAt(int i) {

        if (i < 0 || i > flag) {
            throw new IllegalArgumentException("index khong hop le");
        } else if(i == flag){
            arrayOfK[i] = null;
            if(flag == size){
                size--;
            }
            flag--;
        }else {
            Object[] temporyArray = Arrays.copyOfRange(arrayOfK, i + 1, flag);
            int a = 0;
            for (int x = i; x < flag-1; x++) {
                arrayOfK[i] = temporyArray[a];
                a++;
            }
            arrayOfK[flag] = null;
            if(flag == size-1){
                size--;
            }
            flag--;
        }
    }

    @Override
    public int size() {
        return size-1;
    }

    @Override
    public boolean contain(K arg) {
        for (int i = 0; i< size();i++) {
          if(arrayOfK[i].equals(arg)){
              return true;
          }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(arrayOfK[0] == null){
            return true;
        }
        return false;
    }
}
