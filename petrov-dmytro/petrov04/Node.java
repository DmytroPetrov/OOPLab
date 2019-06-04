package ua.lpnuai.oop.petrov04;

import java.io.Serializable;

public class Node<T> implements Serializable {
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static Node ourInstance = new Node();

    public static Node getInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Node ourInstance) {
        Node.ourInstance = ourInstance;
    }

    public Node() {
    }

//    @Override
//    public String toString() {
//        return this.data.toString();
//    }
}
