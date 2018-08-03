package com.algorithm.array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 *  向右旋转 1 步: [7,1,2,3,4,5,6]
 *  向右旋转 2 步: [6,7,1,2,3,4,5]
 *  向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class Rotate{

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {

        for(int j = 0; j < k ; j++){

            int temp = 0;

            for(int i = 0; i < nums.length ; i++){

                if(i == 0){
                    temp = nums[nums.length -1];
                }

                int last = nums[i];

                nums[i] = temp;

                temp = last;
            }
        }

        for(int i = 0 ; i < nums.length ;i ++){
            System.out.print(nums[i] + ",");
        }

    }

}
