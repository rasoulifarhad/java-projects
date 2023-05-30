package com.farhad.example.collections.arraylist.sort;

import java.util.ArrayList;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayListSortingDemo {
    
    public static void SortAscendingArrayListWithCollectionsUtilDemo(ArrayList<String> arraylist) {
        log.info("{} Befor sort", arraylist);
        Collections.sort(arraylist);
        log.info("{} After ascending sort", arraylist);
    }

    public static void SortDescendingArrayListWithCollectionsUtilDemo(ArrayList<String> arraylist) {
        log.info("{} Befor sort", arraylist);
        Collections.sort(arraylist,Collections.reverseOrder());
        log.info("{} After descending sort", arraylist);
    }

}
