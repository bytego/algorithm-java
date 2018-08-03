package com.algorithm.array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

       removeDuplicates(nums);
    }

    private static int removeDuplicates(int[] nums){

        int length = nums.length;
        for (int i = 1; i < length ; i ++){

            if(nums[i] == nums[i-1]){

                length--;

                for(int j = i; j < nums.length - 1; j++){

                    nums[j] = nums[j + 1];
                }
                i--;
                printArr(nums);
            }
        }


        return length;
    }

    private static void printArr(int[] arrs){

        for(int i = 0 ; i < arrs.length ;i ++){
            System.out.print(arrs[i] + ",");
        }

        System.out.println();
    }

}
