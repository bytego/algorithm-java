package com.algorithm.cjm;

/**
 * 求第n个质数的值
 * 质数定义为大于1的自然数，除了1和它本身以外不再有其他因数
 */
public class PrimeNumber {

    /**
     * 求第n个质数
     * @param n
     * @return
     */
    private static int fn(int n){

        int count = 0;
        for(int i = 1; i < Integer.MAX_VALUE ; i++){
            if(isPN(i)){
                count ++;
            }

            if(count == n + 1){
                return i;
            }
        }

        return 0;
    }

    /**
     * 判断一个数是否为质数
     * @param n
     * @return
     */
    private static boolean isPN(int n){

        int i,j;

        //质数必须大于1
        if(n <= 1){
            return false;
        }

        for(i = 2; i < n ; i++){

            for(j = 2; j < n ; j++){

                //能过被1和他本身做因数分解除外
                if(n == i * j){
                    return false;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {

        //求前20的质数
        for(int i = 0; i < 100; i++){
            System.out.println(fn(i));
        }
    }

}
