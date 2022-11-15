package ru.avalon.javapp.devj110.twoDirList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TwoDirList lst = new TwoDirList();
        lst.addToHead("111");
        lst.addToTail("222");
        lst.addToTail("333");
        lst.addToHead("AAA");
        lst.printAll();
        lst.reverse();
        lst.printAll();

        System.out.println();

        lst.remove("111");
        lst.printAll();

        /*
        lst.removeFromTail();
        lst.printAll();

        Object[] start = {
                "DDD",
                "CCC",
                "BBB"
        };

        lst.addToHead(start); // добавление массива в начало списка
        lst.printAll();
         */

        Object[] end = {
                "444",
                "555",
                "666"
        };

        /*
        ArrayList<String> startArr = new ArrayList<String>(); //добавление коллекции в начало списка
        startArr.add("DDD");
        startArr.add("CCC");
        startArr.add("BBB");
        lst.addToHead(startArr);
        //lst.printAll();

        ArrayList<String> endArr = new ArrayList<String>(); //добавление коллекции в конец списка
        endArr.add("444");
        endArr.add("555");
        endArr.add("666");
        lst.addToTail(endArr);
        lst.printAll();

        lst.printAllReverse(); //печать в обратном порядке*/

        /*
        TwoDirList lst1 = new TwoDirList(); //поглощение списка с добавлением в начало
        lst1.addToHead(start);
        lst.addToHead(lst1);
        lst.printAll();
        lst1.printAll();

        TwoDirList lst2 = new TwoDirList(); //поглощение списка с добавлением в конец
        lst2.addToHead(end);
        lst.addToTail(lst2);
        lst.printAll();
        lst2.printAll();
        */
        /*
        lst.addToTail(end);// добавление массива в конец списка
        lst.printAll();
         */
        /*
        TwoDirList rev = lst.reverse();
        rev.printAll();
        */
        /*
        lst.removeFromHead();
        lst.removeFromTail();
        lst.printAll();

        System.out.println(lst.contains("222"));
        System.out.println(lst.contains(222));
        System.out.println();

        lst.addToHead(222);
        System.out.println(lst.contains(222));
        System.out.println(lst.contains(222L)); // false?

        lst.remove(222);*/
    }
}
