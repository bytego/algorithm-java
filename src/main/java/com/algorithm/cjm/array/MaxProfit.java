package com.algorithm.cjm.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] nums = new int[]{7,1,5,5,3,6,4};

//        int[] nums = new int[]{1,7,5,3,6,4};

//        int[] nums = new int[]{1,2,3,4,5,6,7};

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {

        int length = prices.length;

        int finalAmount = 0;

        boolean ishas = false;

        for(int i = 0; i < length ; i++){

            if(i + 1 == length){

                if(ishas == true){
                    finalAmount += prices[i];
                }
                break;
            }
            if(prices[i] > prices[i + 1] && ishas == true) {

                ishas = false;
                finalAmount += prices[i];

            } else if(prices[i] < prices[i + 1] && ishas == false){

                ishas = true;
                finalAmount -= prices[i];
            }
        }

        return finalAmount;
    }

}
