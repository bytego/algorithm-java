package com.algorithm.cjm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {


    public static void main(String[] args) {
        int[] print = new int[]{9,9,9,9,9,9,9,9,9,9};
        int[] ints = plusOne(print);

        for(Integer integer : ints){
            System.out.print(integer + "");
        }
    }

    public static int[] plusOne(int[] digits) {

        int length = digits.length;

        List<Integer> list = new ArrayList<>();
        boolean isPlusOne = true;
        for(int i = length -1; i >= 0 ; i --){

            if(isPlusOne){
                if(digits[i] == 9){
                    list.add(0);
                    isPlusOne = true;
                }else {
                    list.add(digits[i] + 1);
                    isPlusOne =false;
                }
            }else {
                list.add(digits[i]);
            }
        }

        if(isPlusOne){
            list.add(1);
        }

        int[] res = new int[list.size()];
        int resSize = list.size();
        for(Integer inter : list){
            res[--resSize] = inter;
        }

        return res;

    }
}
