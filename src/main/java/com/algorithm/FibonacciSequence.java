package com.algorithm;

/**
 * 斐波那契数列
 * 现有一组数列
 * 1,1,2,3,5,8,13,21...n
 * 求第n个数列的值
 */
public class FibonacciSequence {


    public static void main(String[] args) {

        System.out.println(fn(20));
    }

    /**
     * 求fn(n)
     * @param n
     * @return
     */
    private static int fn(int n){

        if(n == 0 || n == 1){
            System.out.println(1);
            return 1;
        }

        int result = fn(n-1) + fn(n - 2);

        System.out.println(result);

        return result;
    }

    /**
     * 判断fn(n) 是否溢出
     * @param n
     * @return
     */
//    private static boolean isOverFlow(int n){
//
//        return fn(n- 1) + fn( n-2 ) > 100;
//    }


}
