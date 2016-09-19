package org.sbx.service;

import org.sbx.objects.ListOperator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aloginov on 14.09.16.
 */
public class Service {

    public static void createInitialFiles(){

        final int COUNT_NEW_ELEMENTS = 100000;
        final int COUNT_ELEMENTS = 100000;
        // final int INDEX_NUMBER = COUNT_ELEMENTS / 2;
        final String MAIN_FILE_NAME = "/home/aloginov/input.txt";
        final String ADDITIONAL_FILE_NAME = "/home/aloginov/add_lines.txt";

        ListOperator listOperator;

        List<String> strings;

        /*
         *  Main data file creation block.
         */
        strings = new ArrayList<>(COUNT_ELEMENTS);

        for (int i = 0; i < COUNT_ELEMENTS; i++)
            strings.add(new StringCreator(1000).getString());

        listOperator = new ListOperator(strings);
        listOperator.writeToFile(MAIN_FILE_NAME);
        /*
         *  The end of main data file creation block.
         */

        /*
         *  Additional data file creation block.
         */
        strings = new ArrayList<>(COUNT_NEW_ELEMENTS);

        for (int i = 0; i < COUNT_NEW_ELEMENTS; i++)
            strings.add(new StringCreator(1000).getString());

        listOperator = new ListOperator(strings);
        listOperator.writeToFile(ADDITIONAL_FILE_NAME);
        /*
         *  The end of additional data file creation block.
         */
    }
}
