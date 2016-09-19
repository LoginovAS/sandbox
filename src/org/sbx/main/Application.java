package org.sbx.main;

import org.sbx.objects.ListOperator;
import org.sbx.service.Scenario;

import java.util.*;

/**
 * Created by aloginov on 08.09.16.
 */

public class Application {
    public static void main(String[] args){

        final String WORK_FILE_NAME = "/home/aloginov/input.txt";
        final String ADDITIONAL_FILE_NAME = "/home/aloginov/add_lines.txt";

        ArrayList<String> additionList;
        ArrayList<String> arrayList;
        LinkedList<String> linkedList;

        Scenario scenario = new Scenario();
        additionList = scenario.getArrayList(ADDITIONAL_FILE_NAME);

        /*
         *  Scenario #1:
         *  Add list to the middle of ArrayList using elements iteration
         *  and get characters total number;
         */
        //System.out.println("Scenario #1:");
        //arrayList = scenario.getArrayList(WORK_FILE_NAME);
        //scenario.addByElement(arrayList, additionList);
        //scenario.getTotalChars(arrayList);
        /*
         *  Scenario #1 END.
         */

        /*
         *  Scenario #2:
         *  Add list to the middle of LinkedList using elements iteration
         *  and get characters total number;
         */
         //System.out.println("Scenario #2:");
         //linkedList = scenario.getLinkedList(WORK_FILE_NAME);
         //scenario.addByElement(linkedList, additionList);
         //scenario.getTotalChars(linkedList);
        /*
         *  Scenario #2 END.
         */

        /*
         *  Scenario #3:
         *  Add list to the middle of ArrayList using addAll() method.
         */
         //System.out.println("Scenario #3:");
         //arrayList = scenario.getArrayList(WORK_FILE_NAME);
         //scenario.addWithAddAll(arrayList, additionList);
         //System.out.println(arrayList.size());
        /*
         *  Scenario #3 END.
         */

        /*
         *  Scenario #4:
         *  Add list to the middle of LinkedList using addAll() method.
         */
         System.out.println("Scenario #4:");
         linkedList = scenario.getLinkedList(WORK_FILE_NAME);
         scenario.addWithAddAll(linkedList, additionList);
        /*
         *  Scenario #4 END.
         */
    }
}
