package com.algorithm.lzr.array;

import java.util.Arrays;

/**
 * 找出那个只出现了一次的元素
 * 给定一个非空整数数组, 除了某个元素只出现一次以外, 其余每个元素均出现两次
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author lzr
 * @date 2018/8/7
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] array1 = {0, 17, 2, 1, 1, 17, 2};
        int i1 = singleNumber1(array1);
        System.out.println(i1);
        int[] array2 = {0, 17, 2, 1, 1, 17, 2, 4, 5, 5, 4};
        int i2 = singleNumber2(array2);
        System.out.println(i2);
    }

    /**
     * 先排序,在比较相邻两个字符
     *
     * @param array
     * @return
     */
    public static int singleNumber1(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int value = array[array.length - 1];
        for (int i = 1; i < array.length; i += 2) {
            if (array[i] != array[i - 1]) {
                return array[i - 1];
            }
        }
        return value;
    }

    /**
     * 适用位运算来处理
     * 利用异或的两个为相同为0,相异为1的特性处理
     * <p>
     * 如 a=2 =>转成2进制=> a=10  b=2 =>转成2进制=> b=10; 此时a^b=0
     * 如 a=2 =>转成2进制=> a=10  b=3 =>转成2进制=> b=11; 此时a^b=01=1  c=3 =>转成2进制=> c=11, 此时a^b^c=10=2
     *
     * @param array
     * @return
     */
    public static int singleNumber2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //异或
            array[0] ^= array[i];
        }
        return array[0];
    }


}
