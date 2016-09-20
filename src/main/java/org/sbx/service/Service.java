package org.sbx.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.managers.LoggerManager;
import org.sbx.objects.ListOperator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by aloginov on 14.09.16.
 */
public class Service {

    private static final Logger logger = LogManager.getLogger(Service.class);

    private static final String PROPERTIES_FILE_NAME = "conf/config.properties";
    private static Map propertyMap;

    public static void createInitialFiles(int count, int count_new){

        ListOperator listOperator;

        List<String> strings;

        /*
         *  Main data file creation block.
         */
        strings = new ArrayList<String>(count);

        for (int i = 0; i < count; i++)
            strings.add(new StringCreator(1000).getString());

        listOperator = new ListOperator(strings);
        listOperator.writeToFile((String) propertyMap.get("main.file.name"));
        /*
         *  The end of main data file creation block.
         */

        /*
         *  Additional data file creation block.
         */
        strings = new ArrayList<String>(count_new);

        for (int i = 0; i < count_new; i++)
            strings.add(new StringCreator(1000).getString());

        listOperator = new ListOperator(strings);
        listOperator.writeToFile((String) propertyMap.get("addition.file.name"));
        /*
         *  The end of additional data file creation block.
         */
    }

    private static void loadProperties(){
        /**
         * The method loads properties from file to HashMap
         */
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        String s;
        boolean success = false;

        propertyMap = new HashMap<String, String>();

        try{
            fileInputStream = new FileInputStream(PROPERTIES_FILE_NAME);
            properties.load(fileInputStream);
            Iterator<String> iterator = properties.stringPropertyNames().iterator();
            while (iterator.hasNext()){
                s = iterator.next();
                propertyMap.put(s, properties.getProperty(s));
            }

            if (propertyMap != null)
                success = true;
        } catch (IOException ex) {
            logger.error(ex);
        } finally {
            if (success)
                logger.info(LoggerManager.PROPERTIES_LOADED, PROPERTIES_FILE_NAME);
            else {
                logger.fatal(LoggerManager.PROPERTIES_NOT_LOADED, PROPERTIES_FILE_NAME);
                System.exit(1);
            }
        }

    }

    public static Map<String, String> getProperties(){
        /**
         * The method takes and returns properties as Map.
         */
        loadProperties();
        return propertyMap;
    }
}
