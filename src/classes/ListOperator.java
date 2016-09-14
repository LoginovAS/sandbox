package classes;

import java.util.*;

/**
 * Created by aloginov on 13.09.16.
 */
public class ListOperator {

    private long total;

    List list;

    public ListOperator(){ }

    public void insertIntoList(List<String> list, Collection<String> strings, int index){
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            list.add(index, iterator.next());
        }
    }

    public Long getTotalChars(List<String> list){
        total = 0;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            total += iterator.next().length();
        }

        return total;
    }
}
