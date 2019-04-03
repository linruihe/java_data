package com.linruihe.common.linkedlist;

/**
 * 单向循环链表
 * * 最后的节点的下一个节点为头节点
 * * 注意边界的处理和判断
 */
public class SinglyGenericLoopLinkedList<T> {

    private Node head = null;
    private int size = 0;

    //获取链表长度
    public int length(){
        return size;
    }

    //获取当前链表的尾节点
    private Node getTailNode(){
        Node p = head;
        if (head == null){
            return null;
        }
        while (!p.next.equals(head)){
            p = p.next;
        }
        return p;
    }

    //从链表头部插入节点
    public void insertToHead(T value){
        Node tail = getTailNode();
        Node node = new Node(value,null);
        if (tail != null) {
            node.next = head;
            tail.next = node;
        }else {
            node.next = node;
        }
        head = node;
        size++;
    }

    //从链表尾部插入节点
    public void insertToTail(T value){
        Node tail = getTailNode();
        Node node = new Node(value,null);
        if (tail != null) {
            tail.next = node;
            node.next = head;
        }else {
            node.next = node;
            head = node;
        }
        size++;
    }

    //从指定位置插入
    public void inserToIndex(int index,T value){
        checkIndex(index);
        int count = 0;
        Node q = head;
        if (index == 0) {
            insertToHead(value);
        }else if (index == size) {
            insertToTail(value);
        }else {
            while (q.next != head){
                if (count == index) {
                    break;
                }
                q = q.next;
                count++;
            }
            if (count == index) {
                insertBefore(q,value);
                return;
            }
        }
    }

    //指定节点后插入节点
    private void insertAfter(Node p,T value){
        if (p == null) {
            return;
        }
        Node newNode = new Node(value,null);
        newNode.next = p.next;
        p.next = newNode;
    }

    //指定节点前插入节点
    private void insertBefore(Node p,T value){
        if (p == null) {
            return;
        }
        //找到指定节点的前一个节点
        Node q = head;
        while (q != null) {
            if (p.equals(head)){
                Node newNode = new Node(value,null);
                newNode.next = head;
                head = newNode;
                return;
            }
            if (q.next.equals(p)){
                //在找到的节点后插入一个节点
                insertAfter(q,value);
                return;
            }
            q = q.next;
        }
    }

    //获取指定下标的元素
    public T findToValue(int index){
        checkIndex(index);
        Node q = head;
        int count = 0;
        while (q != null) {
            if (count == index){
                return (T) q.data;
            }
            count++;
            q = q.next;
        }
        return null;
    }

    //获取指定元素的下标
    public int findToIndex(T value){
        if (head == null) {
            return -1;
        }
        Node q = head;
        int count = 0;
        while (q != null){
            if (q.data == value){
                return count;
            }
            count++;
            q = q.next;
        }
        return -1;
    }

    //打印链表的所有值
    public void printAll(){
        if (head == null) {
            return;
        }
        Node q = head;
        System.out.print(q.data + " ");
        while (q.next != head){
            q = q.next;
            System.out.print(q.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyGenericLoopLinkedList linkedList = new SinglyGenericLoopLinkedList();
        System.out.println(linkedList.length());
        for (int i = 0; i < 10; i++) {
            linkedList.insertToHead(i);
        }
        for (int i = 0; i < 10; i++) {
            linkedList.insertToTail(10 + i);
        }

        for (int i = 0; i < 5; i++) {
            linkedList.inserToIndex(i * 2,0);
        }
        linkedList.printAll();
        for (int i = 0; i < 10; i++) {
            System.out.print(linkedList.findToValue(i) + " ");
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print(linkedList.findToIndex(i) + " ");
        }
        System.out.println();
        linkedList.deleteByIndex(5);
        linkedList.printAll();
        linkedList.deleteByValue(0);
        linkedList.printAll();
        //linkedList.insertToTail(5);

        //linkedList.inserToIndex(1,4);
        //linkedList.printAll();
    }

    //检查下标合法性
    private void checkIndex(int index){
        int count = length();
        if (index < 0 || index > count){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    //删除节点后的节点
    private void deleteByAfter(Node p){
        Node nodeDel = p.next;
        if (nodeDel == null) {
            return;
        }
        Node next = nodeDel.next;
        p.next = next;
    }

    //根据节点的值删除节点
    public void deleteByValue(T value){
        if (head == null) {
            return;
        }
        Node q = head;
        if (q.data == value) {
            if (q.next != null) {
                head = q.next;
                q = head;
            }
        }
        while (q.next != head){
            if(q.next.data == value){
                deleteByAfter(q);
            }
            q = q.next;
        }
    }

    //根据节点的值删除节点
    public void deleteByIndex(int index){
        if (head == null) {
            return;
        }
        Node q = head;
        if (index == 0) {
            Node node = q.next;
            head = node;
            return;
        }
        int count = 1;
        //找到需要删除的节点的前一个节点
        while (q.next != head) {
            if (count == index){
                break;
            }
            q = q.next;
            count++;
        }
        deleteByAfter(q);
    }

    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }
}
