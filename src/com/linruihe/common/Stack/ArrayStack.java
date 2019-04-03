package com.linruihe.common.Stack;

import com.linruihe.common.array.GenericArray;

/**
 * 数组实现的栈
 * 栈：后进先出，先进后出
 * @param <T>
 */
public class ArrayStack<T> {

    private GenericArray<T> array = null;

    public void push(T value){
        if (array == null) {
            array = new GenericArray<>();
        }
        array.addLast(value);
    }

    public T pop(){
        if (array == null) {
            return null;
        }
        return array.removeLast();
    }

    public int size(){
        return array.count();
    }

    public void printAll(){
        System.out.println(array.toString());
    }

    //栈是否为空
    public boolean isEmpty(){
        return array.count() == 0;
    }

    //栈是否已经满
    public boolean isFull(){
        return array.count() == array.length();
    }

    //获取栈顶元素
    public T getPeek(){
        return array.get(array.count());
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
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
