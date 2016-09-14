package classes;

import java.util.*;
import java.io.File;

/**
 * Created by aloginov on 13.09.16.
 */
public class ListOperator {

    private long total;

    private List<String> list;

    public ListOperator(){ }

    public ListOperator(List<String> list){
        this.list = list;
    }

    public List<String> getList(){
        return list;
    }

    public List<String> getList(String fileName){
        getFromFile(fileName);
        return list;
    }

    public void insertIntoList(List<String> strings, int index){
        System.out.println(list == strings);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            list.add(index, iterator.next());
        }
    }

    public void writeToFile(String fileName){
        FileManager file = new FileManager(fileName);
        file.openFileForOutput();
        file.writeListToFile(this.list);
        file.close();
    }

    public void getFromFile(String fileName){
        FileManager file = new FileManager(fileName);
        file.openFileForInput();
        file.readFileToList(list);
        file.close();
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
