package com.farhad.example.collections.arraylist.sort;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListSortingDemoTest {
    
    private ArrayList<String> countryList ;

    @BeforeEach
    public void setup(){
        countryList = new ArrayList<>();
        countryList.add("France");         
        countryList.add("USA");         
        countryList.add("Iran");         
        countryList.add("Spain");         
        countryList.add("England");                 
    }

    @AfterEach
    public void tearDown() {
        countryList = null;
    }

    @Test
    public void SortAscendingArrayListWithCollectionsUtilDemoTest() {
        ArrayListSortingDemo.SortAscendingArrayListWithCollectionsUtilDemo(countryList);
    }

    @Test
    public void SortDescendingArrayListWithCollectionsUtilDemoTest() {
        ArrayListSortingDemo.SortDescendingArrayListWithCollectionsUtilDemo(countryList);
    }

    @Test
    public void SortArrayListWithCollectionsUtilDemoTest() {
        ArrayList<String> list = new ArrayList<>(countryList);
        ArrayListSortingDemo.SortAscendingArrayListWithCollectionsUtilDemo(list);
        list = new ArrayList<>(countryList);
        ArrayListSortingDemo.SortDescendingArrayListWithCollectionsUtilDemo(list);
    }

}
