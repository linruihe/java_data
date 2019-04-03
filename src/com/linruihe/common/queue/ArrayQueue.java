package com.linruihe.common.queue;

import com.linruihe.common.array.GenericArray;

/**
 * 数组实现的队列
 * @param <T>
 */
public class ArrayQueue<T> {

    private GenericArray<T> array = null;

    public void add(T value){
        if (array == null) {
            array = new GenericArray<>();
        }
        array.addLast(value);
    }

    public T poll(){
        if (array == null) {
            return null;
        }
        return array.removeFirst();
    }

    public int size(){
        return array.count();
    }

    public void printAll(){
        System.out.println(array.toString());
    }

    //队列是否为空
    public boolean isEmpty(){
        return array.count() == 0;
    }

    //队列是否已经满
    public boolean isFull(){
        return array.count() == array.length();
    }

    //获取队列头部元素
    public T getPeek(){
        return array.get(0);
    }


    public static void main(String[] args) {
        ArrayQueue stack = new ArrayQueue();
        for (int i = 0; i < 20; i++) {
            stack.add(i);
        }
        stack.printAll();
        System.out.println(stack.poll());
        System.out.println(stack.size());
        System.out.print("[");
        while (!stack.isEmpty()){
            System.out.print(stack.poll()+",");
        }
        System.out.println("]");
    }
}
