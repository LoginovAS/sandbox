package org.sbx.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.managers.FileManager;
import org.sbx.managers.LoggerManager;

import java.util.*;

/**
 * Created by aloginov on 13.09.16.
 */
public class ListOperator {

    private static final Logger logger = LogManager.getLogger(ListOperator.class);

    private long total;

    private List<String> list;

    public ListOperator(List<String> list){
        this.total = 0;
        this.list = list;
    }

    public List<String> get(){
        return list;
    }

    @Deprecated
    public List<String> get(String fileName){
        loadFromFile(fileName);
        return list;
    }

    public <T extends List<String>>void insertIntoList(T strings, int index){
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext())
            list.add(index, iterator.next());
        logger.debug(LoggerManager.LIST_INSERTED, "middle");
    }

    public <T extends List<String>> void insertIntoList(T strings){
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext())
            list.add(iterator.next());
        logger.debug(LoggerManager.LIST_INSERTED, "end");
    }

    public <T extends List<String>>void addAllIntoList(T strings, int index){
        list.addAll(index, strings);
        logger.debug(LoggerManager.LIST_INSERTED, "middle");
    }

    public void writeToFile(String fileName){
        FileManager file = new FileManager(fileName);
        file.openFileForOutput(false);
        file.writeListToFile(this.list);
        logger.info(LoggerManager.LIST_WROTE);
    }

    public void loadFromFile(String fileName){
        FileManager file = new FileManager(fileName);
        file.openFileForInput();
        file.readFileToList(list);
        if (!list.isEmpty())
            logger.info(LoggerManager.LIST_LOADED);
        else
            logger.error(LoggerManager.LIST_NOT_LOADED);
    }

    public Long getTotalChars(){
        total = 0;
        Iterator<String> iterator = this.list.iterator();
        while (iterator.hasNext()){
            total += iterator.next().length();
        }

        return total;
    }
}
