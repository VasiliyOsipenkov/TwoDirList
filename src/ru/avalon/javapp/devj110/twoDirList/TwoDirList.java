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

    public void addToHead(Object[] values) {
        for (int i = values.length - 1; i >=0 ; --i) {
            addToHead(values[i]);
        }
    }

    public void addToHead(TwoDirList twoDirList) {//поглощение списка другим списком с добавлением значений второго в начало/конец (два
        if(twoDirList.head == null)//метода) первого списка; после поглощения второй список должен очищаться;
            return;

        if(head.keeps(val)) { //как идея очистки входящего
            removeFromHead();
            return true;
        }// цель перебрать входящий список с конца, попутно добавляя его элементы в голову основного

        ListItem prev = head,
                it = head.next;
        while(it != null) {// пока не переберет до конца
            if(it.keeps(val)) { //ищет элемент, не выполняет блок пока не найдет
                if(it != tail) {//когда нашел если не хвост
                    prev.next = it.next; //обработка удаления, перенос связи со следующим в предыдущий, соответственно потеря связи
                    it.next.previous = prev; // добавим удаление предыдущего значения it на всякий пожарный
                } else {
                    removeFromTail();
                }
                return true; //точка выхода из метода
            }

            prev = it; //часть цикла, если не найден элемент
            it = it.next; //^
        }

        return false;
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

    public void addToTail(Object value) { // 4\12 проверить
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

    public void addToTail(Object[] values){//добавление всех значений заданного массива в конец списка с сохранением порядка —
        for (int i =0; i < values.length; ++i) {//последнее значение массива должно стать последним значением списка
            addToTail(values[i]);
        }

    }


    public Object peekFromTail() { // 5\12 должно подходить
        return tail != null ? tail.value : null;
    }

    public Object removeFromTail() { // 6\12 должно работать
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
            if(it.keeps(val)) { //ищет элемент, не выполняет блок пока не найдет
                if(it != tail) {//когда нашел если не хвост
                    prev.next = it.next; //обработка удаления, перенос связи со следующим в предыдущий, соответственно потеря связи
                    it.next.previous = prev; // добавим удаление предыдущего значения it на всякий пожарный
                } else {
                    removeFromTail();
                }
                return true; //точка выхода из метода
            }

            prev = it; //часть цикла, если не найден элемент
            it = it.next; //^
        }

        return false;
    }// 11\12 условно выполняется

    public TwoDirList reverse() { // 12\12 работает - не трожь!!!!
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
? *добавление всех значений заданной коллекции в начало/конец списка (два метода) с сохранением порядка; коллекция — любой объект, реализующий интерфейс
java.lang.Iterable;
?
? печать всех значений списка в прямом/обратном порядке (два метода);
? *выполнение действия, заданного в параметре метода, для каждого значения списка в
прямом/обратном порядке (два метода).
*/

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
