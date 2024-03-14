import DataStructure.Arraylist;
import DataStructure.Linked.CircularDoublyLinkedList;
import DataStructure.Linked.DoublyLinkedList;
import DataStructure.Linked.LinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new CircularDoublyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i));
        }

    }
    private static void timeCheckAverage(int rerunCount, int listCount) {
        Arraylist<Double> javaTimes = new Arraylist<>();
        Arraylist<Double> customTimes = new Arraylist<>();
        for (int i = 0; i < rerunCount; i++) {
            Time time = timeCheck(listCount, false);
            javaTimes.add(time.javaListTime);
            customTimes.add(time.customListTime);
        }
        System.out.println("Average custom time : " + customTimes.getAverage() + "s");
        System.out.println("Average java time : " + javaTimes.getAverage() + "s");
    }
    private static Time timeCheck(int listCount, boolean printDebug) {
        if (printDebug) System.out.println("Starting custom list timer");
        long time = System.currentTimeMillis();
        Arraylist<Integer> list = new Arraylist<>();
        for (int i = 0; i < listCount; i++) {
            list.add((int) (Math.random() * 100));
        }
        //list.remove(9);
        double firstListTime = (System.currentTimeMillis() - time) / 1000d;
        if (printDebug) System.out.println("Custom list took " + firstListTime);
        if (printDebug) System.out.println("Starting java list timer");
        time = System.currentTimeMillis();
        java.util.List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < listCount; i++) {
            ls.add((int) (Math.random() * 100));
        }
        //ls.remove(9);
        double secondListTime = (System.currentTimeMillis() - time) / 1000d;
        if (printDebug) System.out.println("Java list took " + secondListTime);
        return new Time(firstListTime, secondListTime);
    }
}
