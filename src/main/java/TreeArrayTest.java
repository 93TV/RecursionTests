import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeArrayTest {
    static List<Integer> arrayList;
    static Set<Integer> treeSet;
    static void fillArrayList() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 50000; i++){
            arrayList.add((int)(Math.random()*10000 + 1));
        }
    }

    static void fillTreeSet() {
        treeSet = new TreeSet<>();
        for (int i = 0; i < 50000; i++){
            treeSet.add((int)(Math.random()*10000 + 1));
        }
    }

    static boolean checkArrayList(int x){
        fillArrayList();
        for (int i : arrayList){
            if (i == x) return true;
        }
        return false;
    }

    static boolean checkTreeSet(int x){
        fillTreeSet();
        for (int i : treeSet){
            if (i == x) return true;
        }
        return false;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 50000; i++){
            int randomNumber = (int)(Math.random()*10000 + 1);
            System.out.println("Random number = " + randomNumber);
//            System.out.println("Number is in ArrayList: " + checkArrayList(randomNumber));
            System.out.println("Number is in TreeSet: " + checkTreeSet(randomNumber));
        }

    }


}
