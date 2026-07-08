package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {

        ArrayList<Integer> numbers = new ArrayList<>(1000000);
        for (int i = 1; i <= 1000000; i++)
            {
            numbers.add(i);
            }
        LinkedList<Integer> list = new LinkedList<>(numbers);
        for (int i = 1; i <= 1000000; i++)
            {
            list.add(i);
            }
    }
    public static void addElementsToBeginning(List<Integer> list, int numberOfElementsToAdd) {
        for (int i = 0; i < numberOfElementsToAdd; i++)
            {
            list.add(0, i);
            }
    }
    public static void addElementsToMiddle(List<Integer> list, int numberOfElementsToAdd) {

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            int middle = list.size() / 2;
            list.add(middle, i);

        }
    }
    public static void addElementsToEnd(List<Integer> list, int numberOfElementsToAdd) {
        for (int i = 0; i < numberOfElementsToAdd; i++ ) {
            list.add(0);
        }
    }

    public static void removeElementsFromBeginning(List<Integer> list, int numberOfElementsToRemove) {
        for (int i = 0; i < numberOfElementsToRemove; i++) {

            list.remove(0);
        }
    }
    public static void removeElementsFromMiddle(List<Integer> list, int numberOfElementsToRemove) {
        for (int i = 0; i < numberOfElementsToRemove; i++) {
            list.remove((list.size() / 2 )- 1);
        }
    }
    public static void removeElementsFromEnd(List<Integer> list, int numberOfElementsToRemove) {
        for (int i = 0; i < numberOfElementsToRemove; i++) {
            list.remove(list.size()- 1);
        }
    }



}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


