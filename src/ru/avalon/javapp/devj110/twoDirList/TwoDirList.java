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

    public void addToHead(Object value) {
        if(head != null) {
            ListItem nh = new ListItem(value);
            nh.previous = null;
            head.previous = nh;
            nh.next = head;
            head = nh;
        } else {
            head = new ListItem(value);
            head.previous = null;
            head.next = null;
            tail = head;
        }
    }

    public void addToHead(Object[] values) {
        for (int i = values.length - 1; i >=0 ; --i) {
            addToHead(values[i]);
        }
    }

    public void addToHead(TwoDirList twoDirList) {
        if(twoDirList.head == null)
            return;
        ListItem it = twoDirList.tail;
        while(it != null) {
            addToHead(it.value);
            twoDirList.remove(it.value);
            it = it.previous;
        }
    }




    public Object peekFromHead() {
        return head != null ? head.value : null;
    }

    public Object removeFromHead() {
        if(head == null)
            return null;

        Object res = head.value;
        if(head != tail) {
            head = head.next;
            head.previous = null;
        } else {
            head = tail = null;
        }
        return res;
    }

    public void addToTail(Object value) {
        if(tail != null) {
            tail.next = new ListItem(value);
            tail.next.previous = tail;
            tail = tail.next;
        } else {
            head = new ListItem(value);
            head.previous = null;
            head.next = null;
            tail = head;
        }
    }

    public void addToTail(Object[] values){
        for (int i =0; i < values.length; ++i) {
            addToTail(values[i]);
        }

    }

    public void addToTail(TwoDirList twoDirList) {
        if(twoDirList.head == null)
            return;
        ListItem it = twoDirList.head;
        while(it != null) {
            addToTail(it.value);
            twoDirList.remove(it.value);
            it = it.next;
        }
    }


    public Object peekFromTail() {
        return tail != null ? tail.value : null;
    }

    public Object removeFromTail() {
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

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object val) {
        ListItem it = head;
        while(it != null) {
            if(it.keeps(val))
                return true;

            it = it.next;
        }
        return false;
    }

    public void printAll() {
        ListItem it = head;
        while(it != null) {
            System.out.println(it.value);
            it = it.next;
        }
        System.out.println();
    }

    public void printAllReverse() {
        ListItem it = tail;
        while(it != null) {
            System.out.println(it.value);
            it = it.previous;
        }
        System.out.println();
    }

    public boolean remove(Object val) {
        if(head == null)
            return false;

        if(head.keeps(val)) {
            removeFromHead();
            return true;
        }

        ListItem prev = head,
                it = head.next;
        while(it != null) {
            if(it.keeps(val)) {
                if(it != tail) {
                    prev.next = it.next;
                    it.next.previous = prev;
                } else {
                    removeFromTail();
                }
                return true;
            }

            prev = it;
            it = it.next;
        }

        return false;
    }

    public TwoDirList reverse() {
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

    /*
? *добавление всех значений заданной коллекции в начало/конец списка (два метода) с сохранением пор€дка; коллекци€ Ч любой объект, реализующий интерфейс
java.lang.Iterable;
*/

    private static class ListItem {
        Object value;
        ListItem previous;
        ListItem next;

        ListItem(Object value) {
            this.value = value;
        }

        boolean keeps(Object val) {
            return value == null && val == null
                    || value != null && value.equals(val);
        }
    }
}
