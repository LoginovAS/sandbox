package org.sbx.service;

import org.sbx.managers.FileManager;
import org.sbx.objects.ListOperator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aloginov on 16.09.16.
 */
public class Scenario {

    // Set number of elements.
    final int COUNT_NEW_ELEMENTS = 100000;
    final int COUNT_ELEMENTS = 100000;
    final int INDEX_NUMBER = COUNT_ELEMENTS / 2;
    final String REPORT_FILE_NAME = "/home/aloginov/private/java/files/report.txt";

    long startTime;
    long finishTime;
    long total;

    ListOperator listOperator;

    public ArrayList<String> getArrayList(String fileName){
        /**
         * The method takes an ArrayList from the file and
         * returns it to requester.
         */
        listOperator = new ListOperator(new ArrayList<>());
        listOperator.loadFromFile(fileName);
        return (ArrayList<String>) listOperator.get();
    }

    public LinkedList<String> getLinkedList(String fileName){
        /**
         * The method takes a LinkedList from the file and
         * returns it to requester.
         */
        listOperator = new ListOperator(new LinkedList<>());
        listOperator.loadFromFile(fileName);
        return (LinkedList<String>) listOperator.get();
    }

    public void addByElement(List<String> mainList, List<String> additionList){
        /**
         * The method assesses how much time necessary to insert elements from
         * one list to the middle of another one, one by one.
         */
        startTime = System.nanoTime();
        new ListOperator(mainList).insertIntoList(additionList, INDEX_NUMBER);
        finishTime = System.nanoTime();
        System.out.printf("Insert time by element for %s: %d.\n", mainList.getClass(), finishTime - startTime);
        FileManager file = new FileManager(REPORT_FILE_NAME);
        file.openFileForOutput(true);
        file.writeToFile("Insert time by element for " + mainList.getClass() + ": " + (finishTime - startTime) + "ns");
    }

    public void addWithAddAll(List<String> mainList, List<String> additionList){
        /**
         * The method assesses how much time necessary to insert elements from
         * one list to the middle of another using addAll() method.
         */
        startTime = System.nanoTime();
        new ListOperator(mainList).addAllIntoList(additionList, INDEX_NUMBER);
        finishTime = System.nanoTime();
        System.out.printf("Insert time with addAll(): %d.\n", finishTime - startTime);
        FileManager file = new FileManager(REPORT_FILE_NAME);
        file.openFileForOutput(true);
        file.writeToFile("Insert time with addAll() for " + mainList.getClass() + ": " + (finishTime - startTime) + "ns");
    }

    public void addToEnd(List<String> mainList, List<String> additionList){
        /**
         * The method assesses how much time necessary to insert elements from
         * one list to the end of another one.
         */
        startTime = System.nanoTime();
        new ListOperator(mainList).insertIntoList(additionList);
        finishTime = System.nanoTime();
        System.out.printf("Insert time to the end for %s: %d.\n", mainList.getClass(), finishTime - startTime);
        FileManager file = new FileManager(REPORT_FILE_NAME);
        file.openFileForOutput(true);
        file.writeToFile("Insert time to the end for " + mainList.getClass() + ": " + (finishTime - startTime) + "ns");
    }

    public void getTotalChars(List<String> list){
        /**
         * The method assesses how much time necessary to pass all elements in the list
         * and count them.
         */
        // Get total numbers of symbols in ArrayList.
        startTime = System.nanoTime();
        total = new ListOperator(list).getTotalChars();
        finishTime = System.nanoTime();
        System.out.printf("Total numbers of list chars: %d. Result got for %d nanoseconds.\n", total, finishTime - startTime);
        FileManager file = new FileManager(REPORT_FILE_NAME);
        file.openFileForOutput(true);
        file.writeToFile("Total numbers of chars for " + list.getClass() + ": " + total + ". Result got for " + (finishTime - startTime) + "ns");
    }
}
