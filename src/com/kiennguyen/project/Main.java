package com.kiennguyen.project;

import com.kiennguyen.project.problem1.Clist;
import com.kiennguyen.project.problem1.impl.ArrayList;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Clist<String> clist = new ArrayList<>();
        clist.add("Kien");
        clist.add("Minh");
        String[] list = {"Hai", "Quang", "Chi", "Lan", "Ngoc"};
        clist.addAll(list);
        List<String> strings = new java.util.ArrayList<>();
        strings.add("Thang");
        clist.addAll(strings);
        clist.insertAt("asdasdasdasdasd",3);
        clist.removeAt(3);

        for(int i = 0;i < clist.size();i++){
            System.out.println(clist.get(i));
        }
        System.out.println(clist.contain("LALALA"));
    }
}
