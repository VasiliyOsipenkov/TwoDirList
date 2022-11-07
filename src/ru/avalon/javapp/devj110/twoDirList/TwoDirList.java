package ru.avalon.javapp.devj110.twoDirList;

public class TwoDirList {

    private ListItem head;
    private ListItem tail;

    public TwoDirList() {
    }

    private TwoDirList(ListItem head, ListItem tail) {
        this.head = head;
        this.tail = tail;
    }

    public void addToHead(Object value) { // 1\12 ������������� ���� ����� �������, ���������� ���� �� ��� ������� ������ �� ������ ��������
        if(head != null) {
            ListItem nh = new ListItem(value);
            nh.previous = null;
            nh.next = head;
            head = nh;
        } else {
            head = new ListItem(value);
            head.previous = null;
            head.next = null;
            tail = head;
        }
    }

    public Object peekFromHead() { // 2\12 ������������ ��������
        return head != null ? head.value : null;
    }

    public Object removeFromHead() { // 3\12 ������ ��������, �� ���������!!!!!
        if(head == null)
            return null;

        Object res = head.value;
        if(head != tail) {
            head = head.next;
            head.next.previous = null;
        } else {
            head = tail = null;
        }
        return res;
    }

    public void addToTail(Object value) { // 4\12 �� ��������� ���������� ��������
        if(tail != null) {
            tail.next = new ListItem(value);
            tail = tail.next;
        } else {
            head = tail = new ListItem(value);
        }
    }

    public Object peekFromTail() { // 5\12 ������ ���������
        return tail != null ? tail.value : null;
    }

    public Object removeFromTail() { // 6\12 �� ��������� ���������� ��������
        if(tail == null)
            return null;

        Object res = tail.value;
        if(head != tail) {
            ListItem nt = head;
            while(nt.next != tail)
                nt = nt.next;
            nt.next = null;
            tail = nt;
        } else {
            head = tail = null;
        }
        return res;
    }

    public boolean isEmpty() { // 7\12 ������ ��������
        return head == null;
    }

    public boolean contains(Object val) {// 8\12 ���������� �������� �� ������, ������ ��������
        ListItem it = head;
        while(it != null) {
            if(it.keeps(val))
                return true;

            it = it.next;
        }
        return false;
    }

    public void printAll() {// 9\12 ���������� �� ������, ������ ��������
        ListItem it = head;
        while(it != null) {
            System.out.println(it.value);
            it = it.next;
        }
        System.out.println();
    }

    public boolean remove(Object val) {// 10\12 ��������� ������, ������� ���� ������� ������, ���������� � ������� ������, �� ��������� ���������� ��������
        if(head == null)
            return false;

        if(head.keeps(val)) {
            removeFromHead();
            return true;
        }

        ListItem prev = head,
                it = head.next;
        while(it != null) {// ���� �� ��������� �� �����
            if(it.keeps(val)) {
                if(it != tail) {
                    prev.next = it.next;
                } else {
                    removeFromTail();
                }
                return true;
            }

            prev = it;
            it = it.next;
        }

        return false;
    }// 11\12 ������� �����������

    public TwoDirList reverse() { // 12\12 ����������, �� ����� ���������� � ������ ������������� ����������� ��������
        if(head == null)
            return new TwoDirList();

        ListItem newTail = new ListItem(head.value),
                newHead = newTail,
                it = head;
        while(it.next != null) {
            it = it.next;
            ListItem nh = new ListItem(it.value);
            nh.next = newHead;
            newHead = nh;
        }

        return new TwoDirList(newHead, newTail);
    }

    private static class ListItem { //�������� ���������� �������
        Object value;
        ListItem previous;
        ListItem next;

        ListItem(Object value) {
            this.value = value;
        }

        boolean keeps(Object val) { // ������� ���� �������� ���� � ������� ����, ��� �������� �� ���� � ������������ ��������
            return value == null && val == null
                    || value != null && value.equals(val);
        }
    }
}
