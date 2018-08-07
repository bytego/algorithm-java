package com.algorithm.lzr.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 判断是否重复
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * @author lzr
 * @date 2018/8/7
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 1};
        boolean b1 = containsDuplicate1(array);
        boolean b2 = containsDuplicate2(array);
        boolean b3 = containsDuplicate3(array);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

    /**
     * 判断是否重复
     * 方法1：通过map来判重
     *
     * @param array
     * @return
     */
    public static boolean containsDuplicate1(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        Map map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if (map.get(key) == null) {
                map.put(array[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否重复
     * 方法2：先排序,比较相邻的值
     *
     * @param array
     * @return
     */
    public static boolean containsDuplicate2(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否重复
     * 方法3：当前值与前面的值倒序列比较
     * [1,2,3,1,4,5]
     * 对于array[1],跟array[0]比较
     * 对于array[2],先跟array[1]比较,再跟array[0]比较
     *
     * @param array
     * @return
     */
    public static boolean containsDuplicate3(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                /*
                //原来的代码
                if (array[j] == array[i]) {
                    return true;
                }
                */
                //优化后的代码  加多array[i]>array[j]比较可以有效减少循环次数
                if (array[i] > array[j]) {
                    break;
                } else if (array[j] == array[i]) {
                    return true;
                }
            }
        }
        return false;
    }


}
