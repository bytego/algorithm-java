package com.algorithm.lzr.array;

/**
 * 从排序数组,原地删除重复项,返回一个数组内元素都唯一时的长度
 * 例如{1,1,2,2,3} 需要返回长度3 且数组前3个元素为{1,2,3}
 *
 * @author lzr
 * @date 2018/8/5
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(array);
        System.out.print(length + "\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }

    }

    public static int removeDuplicates(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //记录次数
        int i = 1;
        for (int j = 1; j < array.length; j++) {
            //不相等,更新次数并更新该位置的数据
            if (array[j - 1] != array[j]) {
                array[i++] = array[j];
            }
        }
        return i;
    }
}
