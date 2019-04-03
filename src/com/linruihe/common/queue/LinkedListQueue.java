package com.linruihe.common.queue;

import com.linruihe.common.linkedlist.SinglyGenericLinkedList;

/**
 * 单向链表实现的栈
 * @param <T>
 */
public class LinkedListQueue<T> {

    private SinglyGenericLinkedList<T> array = null;

    public void add(T value){
        if (array == null) {
            array = new SinglyGenericLinkedList<>();
        }
        array.insertToTail(value);
    }

    public T poll(){
        if (array == null) {
            return null;
        }
        return array.deleteHead();
    }

    public int size(){
        return array.length();
    }

    public void printAll(){
        array.printAll();
    }

    //栈是否为空
    public boolean isEmpty(){
        return array.isEmpty();
    }

    //栈是否已经满
    public boolean isFull(){
        return false;
    }

    //获取栈顶元素
    public T getPeek(){
        return array.findToValue(0);
    }

    public static void main(String[] args) {
        LinkedListQueue stack = new LinkedListQueue();
        for (int i = 0; i < 20; i++) {
            stack.add(i);
        }
        System.out.println(stack.poll());
        stack.printAll();
        System.out.println(stack.size());
        System.out.print("[");
        while (!stack.isEmpty()){
            System.out.print(stack.poll()+",");
        }
        System.out.println("]");
    }
}
