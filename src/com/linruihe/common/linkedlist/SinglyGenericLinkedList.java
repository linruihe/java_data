package com.linruihe.common.linkedlist;

/**
 * 单向链表
 */
public class SinglyGenericLinkedList<T> {

    private Node head = null;

    //获取链表长度
    public int length(){
        int count = 0;
        if (head == null) {
            return count;
        }
        Node q = head;
        while (q != null){
            count++;
            q = q.next;
        }
        return count;
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

    //从链表头部插入节点
    public void insertToHead(T value){
        Node node = new Node(value,null);
        if (head == null) {
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    //从链表尾部插入节点
    public void insertToTail(T value){
        Node node = new Node(value,null);
        if (head == null) {
            head = node;
        }else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            node.next = q.next;
            q.next = node;
        }
    }

    //从指定位置插入
    public void inserToIndex(int index,T value){
        checkIndex(index);
        int count = 0;
        Node q = head;
        while (q != null){
            if (count == index) {
                insertBefore(q,value);
                return;
            }
            q = q.next;
            count++;
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

    //获取当前链表的尾节点
    private Node getTailNode(){
        Node p = head;
        if (head == null){
            return null;
        }
        while (p.next != null){
            p = p.next;
        }
        return p;
    }

    public T getTailValue(){
        Node node = getTailNode();
        if (node != null) {
            return (T) node.data;
        }
        return null;
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
            if (q.equals(p)){
                //在找到的节点后插入一个节点
                insertAfter(q,value);
                return;
            }
            q = q.next;
        }
    }

    //检查下标合法性
    private void checkIndex(int index){
        int count = length();
        if (index < 0 || index > count){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    //根据节点删除节点
    public void deleteByNode(Node node){
        if (node == null || head == null) {
            return;
        }
        Node q = head;
        if (node.equals(head)){
            head = head.next != null ? head.next : null;
            return;
        }
        while (q.next != null && q.next != node){
            q = q.next;
        }
        if (q.next == null) {
            return;
        }
        Node p = q.next;
        q.next = p.next;
    }

    //根据节点的值删除节点
    public void deleteByNode(T value){
        if (head == null) {
            return;
        }
        Node q = head;
        while (q.next != null && q.next.data != value){
            q = q.next;
        }
        if (q.next == null) {
            return;
        }
        Node p = q.next;
        q.next = p.next;
    }

    public T deleteTail(){
        Node delete = getTailNode();
        if (delete != null) {
            deleteByNode(delete);
            return (T) delete.data;
        }
        return null;
    }

    public T deleteHead(){
        if (head != null) {
            Node node = head;
            head = head.next;
            return (T) node.data;
        }
        return null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    //打印链表的所有值
    public void printAll(){
        if (head == null) {
            return;
        }
        Node q = head;
        System.out.print(q.data + " ");
        while (q.next != null){
            q = q.next;
            System.out.print(q.data + " ");
        }
        System.out.println();
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

    public static void main(String[] args) {
        SinglyGenericLinkedList linkedList = new SinglyGenericLinkedList();
        linkedList.insertToHead(1);
        linkedList.insertToTail(3);
        linkedList.inserToIndex(0,2);
        System.out.println(linkedList.length());
        System.out.println(linkedList.findToIndex(3));
        linkedList.printAll();
        linkedList.deleteByNode(3);
        System.out.println(linkedList.findToValue(1));
        linkedList.printAll();
    }
}
