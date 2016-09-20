package org.sbx.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.managers.LoggerManager;
import org.sbx.objects.ListOperator;
import org.sbx.service.Scenario;
import org.sbx.service.Service;

import java.util.*;

/**
 * Created by aloginov on 08.09.16.
 */

public class Application {
    public static void main(String[] args){

        final Logger logger = LogManager.getLogger(Application.class);

        logger.info(LoggerManager.STARTING_MESSAGE);

        HashMap properties = (HashMap) Service.getProperties();

        final String WORK_FILE_NAME = (String) properties.get("work.file.name");
        final String ADDITIONAL_FILE_NAME = (String) properties.get("addition.file.name");
        final int COUNT_NEW_ELEMENTS = Integer.parseInt((String) properties.get("count.new.elements"));
        final int COUNT_ELEMENTS = Integer.parseInt((String) properties.get("count.elements"));
        final Boolean CREATE_FILES = Boolean.parseBoolean((String) properties.get("create.files"));

        ArrayList<String> additionList;
        ArrayList<String> arrayList;
        LinkedList<String> linkedList;

        /*
         *  Initial files creation block
         */
        if (CREATE_FILES) {
            Service.createInitialFiles(COUNT_ELEMENTS, COUNT_NEW_ELEMENTS);
        }
        /*
         *  End files creation block.
         */

        Scenario scenario = new Scenario();
        additionList = scenario.getArrayList(ADDITIONAL_FILE_NAME);

        /*
         *  Scenario #1:
         *  Add list to the middle of ArrayList using elements iteration
         *  and get characters total number;
         */
        logger.info(LoggerManager.SCENARIO, 1, "started");
        arrayList = scenario.getArrayList(WORK_FILE_NAME);
        scenario.addByElement(arrayList, additionList);
        scenario.getTotalChars(arrayList);
        logger.info(LoggerManager.SCENARIO, 1, "finished");
        /*
         *  Scenario #1 END.
         */

        /*
         *  Scenario #2:
         *  Add list to the middle of LinkedList using elements iteration
         *  and get characters total number;
         */
        logger.info(LoggerManager.SCENARIO, 2, "started");
        linkedList = scenario.getLinkedList(WORK_FILE_NAME);
        scenario.addByElement(linkedList, additionList);
        scenario.getTotalChars(linkedList);
        logger.info(LoggerManager.SCENARIO, 2, "finished");
        /*
         *  Scenario #2 END.
         */

        /*
         *  Scenario #3:
         *  Add list to the middle of ArrayList using addAll() method.
         */
        logger.info(LoggerManager.SCENARIO, 3, "started");
        arrayList = scenario.getArrayList(WORK_FILE_NAME);
        scenario.addWithAddAll(arrayList, additionList);
        logger.info(LoggerManager.SCENARIO, 3, "finished");
        /*
         *  Scenario #3 END.
         */

        /*
         *  Scenario #4:
         *  Add list to the middle of LinkedList using addAll() method.
         */
        logger.info(LoggerManager.SCENARIO, 4, "started");
        linkedList = scenario.getLinkedList(WORK_FILE_NAME);
        scenario.addWithAddAll(linkedList, additionList);
        logger.info(LoggerManager.SCENARIO, 4, "finished");
        /*
         *  Scenario #4 END.
         */

        /*
         *  Scenario #5:
         *  Add list to the and of ArrayList.
         */
        logger.info(LoggerManager.SCENARIO, 5, "started");
        arrayList = scenario.getArrayList(WORK_FILE_NAME);
        scenario.addToEnd(arrayList, additionList);
        logger.info(LoggerManager.SCENARIO, 5, "finished");
        /*
         *  Scenario #5 END.
         */

        /*
         *  Scenario #6:
         *  Add list to the end of LinkedList.
         */
        logger.info(LoggerManager.SCENARIO, 6, "started");
        linkedList = scenario.getLinkedList(WORK_FILE_NAME);
        scenario.addToEnd(linkedList, additionList);
        logger.info(LoggerManager.SCENARIO, 6, "finished");
        /*
         *  Scenario #6 END.
         */

        logger.info(LoggerManager.FINISHING_MESSAGE);
    }
}
