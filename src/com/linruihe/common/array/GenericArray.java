package com.linruihe.common.array;

public class GenericArray<T> {

    private T[] data;
    private int count;

    public GenericArray(int count){
        data = (T[]) new Object[count];
        count = 0;
    }

    public GenericArray(){
        this(10);
    }

    //获取当前数组元素个数
    public int count(){
        return count;
    }

    //获取当前数据容量
    public int length(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //获取指定位置元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    //设置指定位置元素
    public void set(int index,T t){
        checkIndex(index);
        data[index] = t;
    }

    //判断是否存在该元素
    public boolean contains(T t){
        for (int i = 0; i < count; i++) {
            if (data[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    //获取指定元素的下标，不存在返回-1
    public int findIndex(T t){
        for (int i = 0; i < count; i++) {
            if (data[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    //在index位置插入数据
    public void add(int index,T t){
        checkIndex(index);
        if (count == data.length){
            resize(2 * data.length);
        }
        //将数据往后移动一位
        for (int i = count; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = t;
        count++;
    }

    //从数组头部插入数据
    public void addFirst(T t){
        add(0,t);
    }

    //从数组尾部插入数据
    public void addLast(T t){
        add(count,t);
    }

    //删除index位置元素并返回
    public T remove(int index){
        checkIndexForRemove(index);
        T t = data[index];
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        count--;
        data[count] = null;
        return t;
    }

    //删除指定元素
    public void removeElement(T t){
        int index = findIndex(t);
        if (index >= 0) {
            remove(index);
        }
    }

    //删除数组第一个元素
    public T removeFirst(){
        return remove(0);
    }

    //删除数组中最后一个元素
    public T removeLast(){
        return remove(count - 1);
    }

    //数组扩容
    private void resize(int capacity) {
        //创建新数组
        T[] newData = (T[]) new Object[capacity];
        //进行数据迁移
        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //检查下标合法性
    private void checkIndex(int index){
        if (index < 0 || index > count){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    //检查下标合法性
    private void checkIndexForRemove(int index){
        if (index < 0 || index >= count){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d, capacity = %d \n", count, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < count; i++) {
            stringBuilder.append(data[i]);
            if (i != count - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
