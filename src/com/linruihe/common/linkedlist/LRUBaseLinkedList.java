package com.linruihe.common.linkedlist;

import java.util.Scanner;

/**
 * 基于单链表LRU算法（java）
 *
 */
public class LRUBaseLinkedList<T> {

    //默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;
    //头结点
    private Node<T> headNode;
    //链表长度
    private Integer length;
    //链表容量
    private Integer capacity;

    public LRUBaseLinkedList(){
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseLinkedList(Integer capacity){
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    private Node findPreNode(T data){
        Node head = headNode;
        while (head.getNext() != null){
            if (data.equals(head.getNext().getElement())){
                return head;
            }
            head = head.getNext();
        }
        return null;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 是否已满
     * @return
     */
    public boolean isFull() {
        return length == capacity;
    }

    /**
     * 添加元素
     * @param data
     */
    public void add(T data) {
        //查看是否存在这个值
        Node node = findPreNode(data);
        if (node == null) {
            if (isFull()){
                //删除最后一个
                deleteElemAtEnd();
            }
            //最前面添加一个
            insertNodeHead(data);
        }else {
            //删除指定的节点
            deleteElemOptim(node);
            //在最前面添加一个节点
            insertNodeHead(data);
        }
    }

    /**
     * 在链表头部插入节点
     * @param data
     */
    private void insertNodeHead(T data){
        Node node = headNode.getNext();
        headNode.setNext(new Node(data,node));
        length++;
    }

    /**
     * 删除节点之后的节点
     * @param preNode
     */
    private void deleteElemOptim(Node preNode){
        Node node = preNode.getNext();
        preNode.setNext(node.getNext());
        length--;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        Node ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        Node tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        Node node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class Node<T> {

        private T element;

        private Node next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
