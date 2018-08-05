package com.algorithm.cjm.array;

import java.util.*;

/**
 *
 * 给定两个数组，写一个方法来计算它们的交集。

     例如:
     给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
     注意：

     输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     我们可以不考虑输出结果的顺序。
     跟进:

     如果给定的数组已经排好序呢？你将如何优化你的算法？
     如果 nums1 的大小比 nums2 小很多，哪种方法更优？
        第二种更加优化，不需要循环数组更大的数组

     如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class InterSect {


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4, 5, 6, 7, 8};
        int[] nums2 = {1,3,5};

        int[] rs = intersectInSort(nums1 , nums2);

        for (int i = 0 ; i < rs.length; i++){
            System.out.print(rs[i] + ",");
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
                map.put(nums1[i], ++ temp);
            }else {
                map.put(nums1[i], 1);
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums2.length; i++){

            Integer count = map.get(nums2[i]);
            if(count != null && count > 0){
                map.put(nums2[i], --count);
                res.add(nums2[i]);
            }
        }

        int[] ints = new int[res.size()];

        for(int i = 0 ; i < res.size() ; i++){
            ints[i] = res.get(i);
        }

        return ints;
    }

    /**
     * 求数组的交集
     * 假如两个数组是排好序的
     * @return
     */
    public static int[] intersectInSort(int[] nums1, int[] nums2){

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0 , j = 0;

        List<Integer> resList = new ArrayList<>();
        while (i < nums1.length && j < nums2.length){

            if(nums1[i] == nums2[j]){

                resList.add(nums1[i]);

                i ++;
                j ++;

            }else if(nums1[i] > nums2[j]){

                j ++;
            }else if(nums2[j] > nums1[i]){

                i ++;
            }
        }

        int[] arrRes = new int[resList.size()];

        int k = 0;
        for(Integer res : resList){
            arrRes[k++] = res;
        }

        return arrRes;
    }


}
