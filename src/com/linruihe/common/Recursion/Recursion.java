package com.linruihe.common.Recursion;

/**
 * 将问题分成子问题
 * *1、一个问题的解是几个子问题的解
 * *2、子问题的求解思路和父问题相同
 * *3、存在递归终止条件
 */
public class Recursion {

    /**
     * 1、终止条件
     * 2、拆成子问题
     */
    public int sum(int n){
        if (n == 1) {
            return 1;
        }
        return sum(n-1) + 1;
    }

    public int sum2(int n){
        if (n == 1) {
            return 1;
        }else if(n == 2){
            return 2;
        }
        return sum(n-1) + sum(n-2);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        //System.out.println(recursion.sum(100));
        System.out.println(recursion.sum2(100));
    }
}
