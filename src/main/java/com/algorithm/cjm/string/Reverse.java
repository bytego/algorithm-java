package com.algorithm.cjm.string;

/**
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

     示例 1:

     输入: 123
     输出: 321
     示例 2:

     输入: -123
     输出: -321
     示例 3:

     输入: 120
     输出: 21
     注意:

     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 */
public class Reverse {

    public static void main(String[] args) {

    }

    public int reverse(int x) {

        int length = 0;
        for(int i = 0; i < Integer.MAX_VALUE; i ++){

            if(x < (10 ^ i)){
                length = i;
                break;
            }
        }

        int[] res = new int[length];
        int j = 0;

        for(int i = length -1; i >=0 ; i --){

            res[j] = x/(10 ^ i);
            x = x - res[j] * (10 ^ i);
            j ++;
        }

        int total = 0;
        for(int i = 0; i < length; i ++){


            if(total > 0){
                int max = Integer.MAX_VALUE - total;

                if(res[i] * (10 ^ i) > max){
                    return 0;
                }
            }else {
                int min = Integer.MIN_VALUE - total;
                if(res[i] * (10 ^ i) < min){
                    return 0;
                }
            }

            total += res[i] * (10 ^ i);
        }

        return total;
    }

}
