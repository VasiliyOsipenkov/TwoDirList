package ru.avalon.javapp.devj110.twoDirList;

public class Main {

    public static void main(String[] args) {
        TwoDirList lst = new TwoDirList();
        lst.addToHead("111");
        lst.addToTail("222");
        lst.addToTail("333");
        lst.addToHead("AAA");
        lst.printAll();

        TwoDirList rev = lst.reverse();
        rev.printAll();

        /*lst.removeFromHead();
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
