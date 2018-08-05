package com.algorithm.lzr.array;

/**
 * n × n 的二维矩阵 旋转图像
 *
 * @author lzr
 * @date 2018/8/5
 */
public class Rotate {
    public static void main(String[] args) {
        /**
         * 5,  1, 9,11 (1,1)(1,2)(1,3)(1,4)
         * 2,  4, 8,10 (2,1)(2,2)(2,3)(2,4)
         * 13, 3, 6, 7 (3,1)(3,2)(3,3)(3,4)
         * 15,14,12,16 (4,1)(4,2)(4,3)(4,4)
         * 转成
         * 15,13, 2, 5 (1,1)(1,2)(1,3)(1,4)
         * 14, 3, 4, 1 (2,1)(2,2)(2,3)(2,4)
         * 12, 6, 8, 9 (3,1)(3,2)(3,3)(3,4)
         * 16, 7,10,11 (4,1)(4,2)(4,3)(4,4)
         */
        int[][] matrix = {{1, 2}, {3, 4}};
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotate(matrix);
        System.out.print("得到旋转后的矩阵\n");
        print(matrix);
    }

    /**
     * 图的各个点为[m][n]
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        //得到二维矩阵的长度
        int length = matrix.length;
        //外层需要循环次数
        int n = length % 2 == 0 ? length / 2 : length / 2 + 1;
        //内层需要循环次数
        int m = length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                //操作一个点相当于操作4个点  对于 (1,1) (1,4) (4,4) (4,1)需要同时移动
                // i=0,j=0 : (1,1) - (1,4);  i=0,j=1 : (1,2) - (2,4)
                int point1 = matrix[i][j];
                // i=0,j=0 : (1,4) - (4,4);  i=0,j=1 : (2,4) - (4,3)
                int point2 = matrix[j][length - 1 - i];
                // i=0,j=0 : (4,4) - (4,1);  i=0,j=1 : (4,3) - (3,1)
                int point3 = matrix[length - 1 - i][length - 1 - j];
                // i=0,j=0 : (4,1) - (1,1);  i=0,j=1 : (3,1) - (1,2)
                int point4 = matrix[length - 1 - j][i];
                matrix[i][j] = point4;
                matrix[j][length - 1 - i] = point1;
                matrix[length - 1 - i][length - 1 - j] = point2;
                matrix[length - 1 - j][i] = point3;
                print(matrix);
                System.out.print("\n");
            }
            //内层循环次数递减
            m--;
        }
    }

    public static void print(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.print("\n");
        }
    }

}

