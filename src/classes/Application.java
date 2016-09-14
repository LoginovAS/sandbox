package classes;

import java.util.*;

/**
 * Created by aloginov on 08.09.16.
 */

public class Application {
    public static void main(String[] args){

        // Set number of elements.
        final int COUNT_NEW_ELEMENTS = 1000000;
        final int COUNT_ELEMENTS = 1000000;
        final int INDEX_NUMBER = COUNT_ELEMENTS / 2;
        final String WORK_FILE_NAME = "/home/aloginov/input.txt";
        final String ADDITIONAL_FILE_NAME = "/home/aloginov/add_lines.txt";

        ArrayList<String> strings;

        long startTime;
        long finishTime;
        long total;

        ArrayList<String> arrayList;
        LinkedList<String> linkedList;

        ListOperator listOperator;

        // Get initial ArrayList.
        arrayList = (ArrayList<String>) (new ListOperator(new ArrayList<String>())).getList(WORK_FILE_NAME);

        // Get list for insertion.
        strings = (ArrayList<String>) (new ListOperator(new ArrayList<>())).getList(ADDITIONAL_FILE_NAME);

        /*
         *  Block for ArrayList.
         */

        // Insert elements from strings arrayList and track time.
        listOperator = new ListOperator(arrayList);
        startTime = System.nanoTime();
        listOperator.insertIntoList(strings, INDEX_NUMBER);
        finishTime = System.nanoTime();

        System.out.printf("ArrayList insert time: %d.\n", finishTime - startTime);

        // Get total numbers of symbols in ArrayList.
        startTime = System.nanoTime();
        total = listOperator.getTotalChars();
        finishTime = System.nanoTime();

        System.out.printf("Total numbers of ArrayList chars: %d. Result got for %d nanoseconds.\n", total, finishTime - startTime);

        arrayList = null;

        /*
         *  End block for ArrayList.
         */

        /*
         *  Block for LinkedList.
         */
        linkedList = (LinkedList<String>) (new ListOperator(new LinkedList<>())).getList(WORK_FILE_NAME);

        // Insert elements from strings arrayList and track time.
        listOperator = new ListOperator(linkedList);
        startTime = System.nanoTime();
        listOperator.insertIntoList(strings, INDEX_NUMBER);
        finishTime = System.nanoTime();

        System.out.printf("LinkedList insert time: %d nanoseconds.\n", finishTime - startTime);

        // Get total numbers of symbols in LinkedList.
        startTime = System.nanoTime();
        total = listOperator.getTotalChars();
        finishTime = System.nanoTime();

        System.out.printf("Total numbers of LinkedList chars: %d. Result got for %d nanoseconds.\n", total, finishTime - startTime);

        linkedList = null;
        strings = null;
        /*
         *  End block for LinkedList.
         */
    }
}
