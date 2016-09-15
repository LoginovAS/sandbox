package classes;

import service.Service;

import java.util.*;

/**
 * Created by aloginov on 08.09.16.
 */

public class Application {
    public static void main(String[] args){

        // Set number of elements.
        final int COUNT_NEW_ELEMENTS = 500000;
        final int COUNT_ELEMENTS = 500000;
        final int INDEX_NUMBER = COUNT_ELEMENTS / 2;
        final String WORK_FILE_NAME = "/home/aloginov/input.txt";
        final String ADDITIONAL_FILE_NAME = "/home/aloginov/add_lines.txt";

        long startTime;
        long finishTime;
        long total;

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList;

        ListOperator arrayListOperator;
        ListOperator stringsListOperator;
        ListOperator linkedListOperator;

        /*
         *  Service block.
         */
        // Service.createInitialFiles();

        // Get list for insertion.
        strings = new ArrayList<>();
        stringsListOperator = new ListOperator(strings);
        stringsListOperator.getFromFile(ADDITIONAL_FILE_NAME);
        System.out.printf("'strings' list size: %d.\n", strings.size());

        /*
         *  Block for ArrayList.
         */
        // Get initial ArrayList.
        arrayList = new ArrayList<>();
        arrayListOperator = new ListOperator(arrayList);
        arrayListOperator.getFromFile(WORK_FILE_NAME);
        System.out.printf("ArrayList size: %d.\n", arrayList.size());

        // Insert elements from strings arrayList and track time.
        arrayListOperator = new ListOperator(arrayList);
        startTime = System.nanoTime();
        arrayListOperator.insertIntoList(strings, INDEX_NUMBER);
        finishTime = System.nanoTime();

        System.out.printf("ArrayList insert time: %d.\n", finishTime - startTime);

        // Get total numbers of symbols in ArrayList.
        startTime = System.nanoTime();
        total = arrayListOperator.getTotalChars();
        finishTime = System.nanoTime();

        System.out.printf("Total numbers of ArrayList chars: %d. Result got for %d nanoseconds.\n", total, finishTime - startTime);
        arrayList = null;
        Runtime.getRuntime().gc();
        /*
         *  End block for ArrayList.
         */

        /*
         *  Block for LinkedList.
         */
        linkedList = new LinkedList<>();
        linkedListOperator = new ListOperator(linkedList);
        linkedListOperator.getFromFile(WORK_FILE_NAME);
        System.out.printf("LinkedList size: %d.\n", linkedList.size());

        // Insert elements from strings arrayList and track time.
        linkedListOperator = new ListOperator(linkedList);
        startTime = System.nanoTime();
        linkedListOperator.insertIntoList(strings, INDEX_NUMBER);
        finishTime = System.nanoTime();

        System.out.printf("LinkedList insert time: %d nanoseconds.\n", finishTime - startTime);

        // Get total numbers of symbols in LinkedList.
        startTime = System.nanoTime();
        total = linkedListOperator.getTotalChars();
        finishTime = System.nanoTime();

        System.out.printf("Total numbers of LinkedList chars: %d. Result got for %d nanoseconds.\n", total, finishTime - startTime);
        linkedList = null;
        /*
         *  End block for LinkedList.
         */
    }
}
