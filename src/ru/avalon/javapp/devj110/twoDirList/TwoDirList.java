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

    public void addToHead(Object value) { // 1\12 устанавливает нуль перед головой, выставляет нули по обе стороны списка из одного элемента
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

    public Object peekFromHead() { // 2\12 теоритически подходит
        return head != null ? head.value : null;
    }

    public Object removeFromHead() { // 3\12 должно работать, но проверить!!!!!
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

    public void addToTail(Object value) { // 4\12 не добавляет предыдущее значение
        if(tail != null) {
            tail.next = new ListItem(value);
            tail = tail.next;
        } else {
            head = tail = new ListItem(value);
        }
    }

    public Object peekFromTail() { // 5\12 должно подходить
        return tail != null ? tail.value : null;
    }

    public Object removeFromTail() { // 6\12 не учитывает предыдущее значение
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

    public boolean isEmpty() { // 7\12 должно работать
        return head == null;
    }

    public boolean contains(Object val) {// 8\12 перебирает значения от головы, должно работать
        ListItem it = head;
        while(it != null) {
            if(it.keeps(val))
                return true;

            it = it.next;
        }
        return false;
    }

    public void printAll() {// 9\12 перебирает от головы, должно работать
        ListItem it = head;
        while(it != null) {
            System.out.println(it.value);
            it = it.next;
        }
        System.out.println();
    }

    public boolean remove(Object val) {// 10\12 проверяет голову, удаляет если искомый объект, перебирает в сторону головы, не учитывает предыдущее значение
        if(head == null)
            return false;

        if(head.keeps(val)) {
            removeFromHead();
            return true;
        }

        ListItem prev = head,
                it = head.next;
        while(it != null) {// пока не переберет до конца
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
    }// 11\12 условно выполняется

    public TwoDirList reverse() { // 12\12 выполнится, но стоит переделать с учетом использования предыдущего значения
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

    private static class ListItem { //добавлен предыдущий элемент
        Object value;
        ListItem previous;
        ListItem next;

        ListItem(Object value) {
            this.value = value;
        }

        boolean keeps(Object val) { // истинно если значение ноль и искомое ноль, или значение не ноль и эквивалентно искомому
            return value == null && val == null
                    || value != null && value.equals(val);
        }
    }
}
