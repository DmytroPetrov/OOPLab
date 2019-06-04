package ua.lpnuai.oop.petrov04;



import java.io.Serializable;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<Object>, Serializable {
    private static final long serialVersionUID = 1L;
    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public Iterator<Object> iterator() {
        return new ListIterator();
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /*private class Node <T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            next = null;
        }
    }*/

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void Insert( T data){
        Node<T> node = new Node(data);
        this.size++;
//        node.next = head;
//        head = node;

        if (tail == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void print(){
        Node head = this.head;

        while (head != null){
            System.out.println(head.data.toString());
            head = head.next;
        }
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        Node head = this.head;
        String string = "";
        while (head != null){

            string += head.data.toString() +"\n";
            head = head.next;
        }

        return string;
    }

    public Object[] toArray(){
        Node head = this.head;
        Object[] array = new Object[size];

        for (int i = 0; i < this.size; i++, head = head.next) {
            array[i] = (Object) head.data;
        }

        return array;
    }

    public void delete(T d){
        Node t = head;
        int found = 0;
        // to check if first number is d
        if(t.data == d){
            found = 1;
            size--;
            head = head.next;
        }
        // to check other than first number
        else{
            Node t1 = head;
            while(t != null){
                if(t.data == d){
                    found = 1;
                    break;
                }
                size--;
                t1 = t;
                t = t.next;
            }
            if(found == 1){
                t1.next = t.next;
            }
        }
        if(found == 0){
            System.out.println("Element not found in linked list");
        }
    }

    public boolean find(T find){
        Node head = this.head;

        while (head != null){
            if (find.toString() == head.toString())
                return true;
            head = head.next;
        }
        return false;
    }

    class ListIterator implements Iterator<Object>{

        private Node current;

        public ListIterator(){
            current = null;
        }

        @Override
        public boolean hasNext() {
            if (current == null)
                return true;
            return current.next != null;
        }

        @Override
        public Object next() {
            if (current == null)
            {
                current = head;
                return (T) current.data;
            }
            current = current.next;
            return (T) current.data;
        }
    }

}

