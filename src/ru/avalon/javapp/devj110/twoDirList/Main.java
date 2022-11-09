package ru.avalon.javapp.devj110.twoDirList;

public class Main {

    public static void main(String[] args) {
        TwoDirList lst = new TwoDirList();
        lst.addToHead("111");
        lst.addToTail("222");
        lst.addToTail("333");
        lst.addToHead("AAA");
        lst.printAll();

        Object[] start = {
                "DDD",
                "CCC",
                "BBB"
        };
        /*
        lst.addToHead(start); // ���������� ������� � ������ ������
        lst.printAll();
         */

        Object[] end = {
                "444",
                "555",
                "666"
        };

        lst.printAllReverse();

        /*
        TwoDirList lst1 = new TwoDirList(); //���������� ������ � ����������� � ������
        lst1.addToHead(start);
        lst.addToHead(lst1);
        lst.printAll();
        lst1.printAll();

        TwoDirList lst2 = new TwoDirList(); //���������� ������ � ����������� � �����
        lst2.addToHead(end);
        lst.addToTail(lst2);
        lst.printAll();
        lst2.printAll();
        */
        /*
        lst.addToTail(end);// ���������� ������� � ����� ������
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
