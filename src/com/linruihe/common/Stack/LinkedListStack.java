package com.linruihe.common.Stack;

import com.linruihe.common.linkedlist.SinglyGenericLinkedList;

/**
 * 单向链表实现的栈
 * @param <T>
 */
public class LinkedListStack<T> {

    private SinglyGenericLinkedList<T> array = null;

    public void push(T value){
        if (array == null) {
            array = new SinglyGenericLinkedList<>();
        }
        array.insertToTail(value);
    }

    public T pop(){
        if (array == null) {
            return null;
        }
        return array.deleteTail();
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
        return array.getTailValue();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.size());
        System.out.print("[");
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+",");
        }
        System.out.println("]");
    }
}
