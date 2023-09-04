package model;
import java.util.LinkedList;
public class Logic {
    int result;
    LinkedList<Integer> list_1 = new LinkedList<>();

    public void fillList(LinkedList<Integer> b){
        for (Integer element : b) {
            list_1.add(element);
        }
    }

    public int sumNumbers(){
        result += list_1.getFirst();
        list_1.pop();
        if(list_1.size()!=0){
            sumNumbers();
        }
        return result;
    }

    public void clearList(){
        list_1.clear();
    }
}
