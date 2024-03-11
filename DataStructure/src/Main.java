import DataStructure.List;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new List<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        ints.add(5);
        while (ints.hasNext()) {
            System.out.println(ints.getLast());
            ints.remove(ints.getLast());
        }
        ints.printDebug();
    }
}
