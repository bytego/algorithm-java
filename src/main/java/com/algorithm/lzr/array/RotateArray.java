package com.algorithm.lzr.array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 *
 * @author lzr
 * @date 2018/8/6
 */
public class RotateArray {

    public static void main(String[] args) {
        //int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] array1 = {1, 2, 3, 4,5,6};
        rotateArray1(array1, 2);
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i] + ",");
        }
        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {1, 2, 3};
        rotateArray2(array2, 1);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i] + ",");
        }
    }

    /**
     * 方法1 使用规律的方式
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     * @param array
     * @param k
     */
    public static void rotateArray1(int[] array, int k) {
        //数组长度
        int length = array.length;
        //当位移量k为0,或者是length的倍数时,相当于没操作,不变化
        if (k % length == 0){
            return;
        }
        //位移量k 假如k>length,那么k=k-length
        k = k % length;
        //m为实际需要移动次数  假如是length为6,k=4 实际只需要移动m=2
        int m = k < length / 2 ? k : length - k;
        //暂存变量
        int temp = 0;
        //如果length%m==0代表 代表m为length的公约数
        if (length % m != 0) {
            for (int j = 0; j < length; ) {
                if (j == 0) {
                    temp = array[length - k];
                }
                int current = array[j];
                array[j] = temp;
                temp = current;
                if (j + k > length) {
                    j = (j + k) % length;
                } else {
                    j += k;
                }
            }
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = i; j < length; ) {
                    if (j == i) {
                        if (k - i > 0) {
                            temp = array[length - (k - i)];
                        }
                    }
                    int current = array[j];
                    array[j] = temp;
                    temp = current;
                    //由于公约数的存在可能会是数组 i 代表起始位置 j代表运行循环变量 length-k代表要放在i的值
                    //例如{1,2,3,4,5,6}的长度length=6 假设k=2; 当i=0,j=6-2+0=4需要结束循环 循环时执行array[0],array[2],array[4],即{1,3,5}变为{5,1,3}
                    //例如{1,2,3,4,5,6}的长度length=6 假设k=2; 当i=1,j=6-2+1=5需要结束循环 循环时执行array[1],array[3],array[5],即{2,4,6}变为{6,2,4}
                    //array变成{5,6,1,2,3,4}
                    if (j == length - k + i) {
                        break;
                    }
                    if (j + k > length) {
                        j = (j + k) % length;
                    } else {
                        j += k;
                    }
                }
            }
        }

    }

    /**
     * 方法2 使用旋转的方式
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * <p>
     * k将[1,2,3,4,5,6,7] 分成 [1,2,3,4] [5,6,7]
     * [1,2,3,4]对称反转[4,3,2,1],  [5,6,7]对称反转[7,6,5]  得到[4,3,2,1,7,6,5]
     * [4,3,2,1,7,6,5] 反转得到 [5,6,7,1,2,3,4]
     *
     * @param array
     * @param k
     */
    public static void rotateArray2(int[] array, int k) {
        if (array.length == 0) {
            return;
        }
        k = k % array.length;
        //旋转前半段
        reverseArray(array, 0, array.length - k - 1);
        //旋转后半段
        reverseArray(array, array.length - k, array.length - 1);
        //整体旋转
        reverseArray(array, 0, array.length - 1);
    }

    /**
     * 对数组进行对称旋转
     *
     * @param array
     * @param start
     * @param end
     */
    public static void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
