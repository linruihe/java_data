package com.linruihe.common.linkedlist;

/**
 * 双向链表
 * 主要是边界的处理方式
 */
public class TwoWayLoopLinkedList<T> {

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

    //获取指定元素的下标
    private Node getNodeByIndex(int index){
        if (head == null) {
            return null;
        }
        Node q = head;
        int count = 0;
        while (q != null){
            if (count == index){
                return q;
            }
            count++;
            q = q.next;
        }
        return null;
    }

    //根据值获取节点
    private Node getNodeByValue(T value){
        if (head == null) {
            return null;
        }
        Node q = head;
        while (q != null){
            if (q.data == value){
                return q;
            }
            q = q.next;
        }
        return null;
    }

    //从链表头部插入节点
    public void insertToHead(T value){
        Node node = new Node(value,null,null);
        if (head == null) {
            node.next = node;
            head = node;
        }else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    //从链表尾部插入节点
    public void insertToTail(T value){
        Node node = new Node(value,null,null);
        if (head == null) {
            head = node;
        }else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            node.next = q.next;
            node.pre = q;
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
        Node newNode = new Node(value,null,null);
        Node next = p.next;
        Node pre = p;
        newNode.pre = pre;
        pre.next = newNode;
        if (next != null) {
            newNode.next = next;
            next.pre = newNode;
        }
    }

    //指定节点前插入节点
    private void insertBefore(Node p,T value){
        if (p == null) {
            return;
        }
        //找到指定节点的前一个节点
        Node newNode = new Node(value,null,null);
        Node pre = p.pre;
        Node next = p;
        if (pre != null){
            pre.next = newNode;
            newNode.pre = pre;
        }
        newNode.next = next;
        next.pre = newNode;
        if (p == head) {
            head = newNode;
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
    public void deleteByIndex(int index){
        checkIndex(index);
        if (head == null) {
            return;
        }
        Node p = getNodeByIndex(index);
        if (p != null) {
            deleteByNode((Node) p);
        }
    }

    //删除节点
    private void deleteByNode(Node node){
        Node pre = node.pre;
        Node next = node.next;
        //中间的节点
        if (pre != null && next != null){
            pre.next = next;
            next.pre = pre;
        }else if (pre != null && next == null){
            //尾节点
            pre.next = next;
        }else if (pre == null && next != null){
            //头节点
            next.pre = pre;
            head = next;
        }
    }

    //根据节点的值删除节点
    public void deleteByValue(T value){
        if (head == null) {
            return;
        }
        Node p = getNodeByValue(value);
        if (p != null) {
            deleteByNode(p);
        }
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
        private Node pre;
        private Node next;


        public Node(T data,Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        TwoWayLoopLinkedList linkedList = new TwoWayLoopLinkedList();
        linkedList.length();
        linkedList.printAll();
    }
}
