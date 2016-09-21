package org.sbx.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.managers.FileManager;
import org.sbx.managers.LoggerManager;
import org.sbx.objects.ListOperator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aloginov on 16.09.16.
 */
public class Scenario {

    private static final Logger logger = LogManager.getLogger(Scenario.class);

    // Set number of elements.

    long startTime;
    long finishTime;
    long total;

    ListOperator listOperator;

    public ArrayList<String> getArrayList(String fileName){
        /**
         * The method takes an ArrayList from the file and
         * returns it to requester.
         */
        listOperator = new ListOperator(new ArrayList<String>());
        listOperator.loadFromFile(fileName);
        return (ArrayList<String>) listOperator.get();
    }

    public LinkedList<String> getLinkedList(String fileName){
        /**
         * The method takes a LinkedList from the file and
         * returns it to requester.
         */
        listOperator = new ListOperator(new LinkedList<String>());
        listOperator.loadFromFile(fileName);
        return (LinkedList<String>) listOperator.get();
    }

    public void addByElement(List<String> mainList, List<String> additionList){
        /**
         * The method assesses how much time necessary to insert elements from
         * one list to the middle of another one, one by one.
         */
        startTime = System.nanoTime();
        new ListOperator(mainList).insertIntoList(additionList, mainList.size() / 2);
        finishTime = System.nanoTime();
        logger.info(LoggerManager.INSERT_TIME_BY_ELEMENT, mainList.getClass(), finishTime - startTime);
    }

    public void addWithAddAll(List<String> mainList, List<String> additionList){
        /**
         * The method assesses how much time necessary to insert elements from
         * one list to the middle of another using addAll() method.
         */
        startTime = System.nanoTime();
        new ListOperator(mainList).addAllIntoList(additionList, mainList.size() / 2);
        finishTime = System.nanoTime();
        logger.info(LoggerManager.INSERT_TIME_ADDALL, mainList.getClass(), finishTime - startTime);
    }

    public void addToEnd(List<String> mainList, List<String> additionList){
        /**
         * The method assesses how much time necessary to insert elements from
         * one list to the end of another one.
         */
        startTime = System.nanoTime();
        new ListOperator(mainList).insertIntoList(additionList);
        finishTime = System.nanoTime();
        logger.info(LoggerManager.INSERT_TIME_TO_END, mainList.getClass(), finishTime - startTime);
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
        logger.info(LoggerManager.TOTAL_CHARS, list.getClass(), total, LoggerManager.GET_RESULT_TIME, finishTime - startTime);
    }
}
