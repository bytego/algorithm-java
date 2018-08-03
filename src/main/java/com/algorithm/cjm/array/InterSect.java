package com.algorithm.cjm.array;

import java.util.*;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 */
public class InterSect {


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 2, 1, 0};
        int[] nums2 = {2, 2, 0, 343, 1, 0};

        int[] rs = intersect(nums1 , nums2);

        for (int i = 0 ; i < rs.length; i++){
            System.out.println(rs[i]);
        }

    }

    /**
     * 给定两个数组，写一个方法来计算它们的交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums1.length ; i++){

            if(map.get(nums1[i]) != null){
                Integer temp = map.get(nums1[i]);
                map.put(nums1[i], temp++);
            }else {
                map.put(nums1[i], 1);
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums2.length; i++){

            Integer count = map.get(nums2[i]);
            if(count != null && count > 0){
                map.put(nums2[i], count--);
                res.add(nums2[i]);
            }
        }

        int[] ints = new int[res.size()];

        for(int i = 0 ; i < res.size() ; i++){
            ints[i] = res.get(i);
        }

        return ints;
    }

}
