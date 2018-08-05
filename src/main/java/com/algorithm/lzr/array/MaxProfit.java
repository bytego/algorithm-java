package com.algorithm.lzr.array;

/**
 * 买卖股票的最佳时机
 *
 * @author lzr
 * @date 2018/8/5
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 2, 1, 0, 0, 1};
        int price = maxProfit(array);
        System.out.print(price);
    }

    /**
     * array[i]代表买入 array[i+1]代表卖出
     * 如果array[i+1]-array[i]>0,就是盈利
     *
     * @param array 股票价格价格变化
     * @return  累计值
     */
    public static int maxProfit(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int value = 0;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length && array[i + 1] > array[i]) {
                value += array[i + 1] - array[i];
            }
        }
        return value;
    }
}
