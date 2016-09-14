package classes;

import java.util.*;

/**
 * Created by aloginov on 08.09.16.
 */

public class Application {
    public static void main(String[] args){

        ListOperator listOperator = new ListOperator();

        // Set number of elements.
        final int COUNT_NEW_ELEMENTS = 500000;
        final int COUNT_ELEMENTS = 500000;
        final int INDEX_NUMBER = COUNT_ELEMENTS / 2;

        // Create list for insertion.
        List<String> strings = new ArrayList<>(COUNT_ELEMENTS);

        long startTime;
        long finishTime;
        long total;

        List<String> list;

        for (int i = 0; i < COUNT_NEW_ELEMENTS; i++)
            strings.add(new StringCreator(1000).getString());

        // Beginning ArrayList initialization.
        list = new ArrayList<>(COUNT_ELEMENTS);
        // Fill beginning ArrayList.
        list.addAll(strings);

        // Insert elements from strings list and track time.
        startTime = System.nanoTime();
        listOperator.insertIntoList(list, strings, INDEX_NUMBER);
        finishTime = System.nanoTime();

        System.out.printf("ArrayList insert time: %d.\n", finishTime - startTime);

        startTime = System.nanoTime();
        total = listOperator.getTotalChars(list);
        finishTime = System.nanoTime();

        System.out.printf("Total numbers of ArrayList chars: %d. Result got for %d nanoseconds.\n", total, finishTime - startTime);

        // Beginning LinkedList initialization.
        list = new LinkedList<>();
        // Fill beginning LinkedList.
        list.addAll(strings);

        // Insert elements from strings list and track time.
        startTime = System.nanoTime();
        listOperator.insertIntoList(list, strings, INDEX_NUMBER);
        finishTime = System.nanoTime();

        System.out.printf("LinkedList insert time: %d nanoseconds.\n", finishTime - startTime);

        startTime = System.nanoTime();
        total = listOperator.getTotalChars(list);
        finishTime = System.nanoTime();

        System.out.printf("Total numbers of LinkedList chars: %d. Result got for %d nanoseconds.\n", total, finishTime - startTime);
    }
}
