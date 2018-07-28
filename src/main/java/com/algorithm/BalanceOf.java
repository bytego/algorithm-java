package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 求一组数值的和
 */
public class BalanceOf {

    public static void main(String[] args) {

        testMax();
        testMin();
    }

    /**
     * 测试最大值溢出
     */
    private static void testMax(){

        List<Long> trans = new ArrayList<>();

        Long tran1 = Long.MAX_VALUE/2;
        Long tran2 = Long.MAX_VALUE/3;
        Long tran3 = Long.MAX_VALUE/3;

        trans.add(tran1);
        trans.add(tran2);
        trans.add(tran3);

        Long amount = balanceOf(trans);

        System.out.println(amount);
    }

    /**
     * 测试最小值溢出
     */
    private static void testMin(){

        List<Long> trans = new ArrayList<>();

        Long tran1 = Long.MIN_VALUE/2;
        Long tran2 = Long.MIN_VALUE/3;
        Long tran3 = Long.MIN_VALUE/3;

        trans.add(tran1);
        trans.add(tran2);
        trans.add(tran3);

        Long amount = balanceOf(trans);

        System.out.println(amount);
    }

    /**
     * 求一组交易值余额,数值溢出则输出为0
     * @param trans 交易值，数组中值可能为正也可能为负数
     * @return
     */
    private static long balanceOf(List<Long> trans){

        long totalAmount = 0l;

        if(trans == null || trans.size() == 0){
            return totalAmount;
        }

        for(Long tran : trans){

            if(tran == null){
                continue;
            }

            if(tran >= 0){

                //临界值最大金额值
                long tempMaxAmount = Long.MAX_VALUE - tran;
                if(totalAmount > tempMaxAmount){
                    return 0l;
                }

            }else {

                //临界值最小金额
                long tempMinAmount = Long.MIN_VALUE - tran;
                if(totalAmount < tempMinAmount){
                    return 0l;
                }
            }
            totalAmount += tran;
        }

        return totalAmount;
    }

}
