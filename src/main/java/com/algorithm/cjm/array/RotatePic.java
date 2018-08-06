package com.algorithm.cjm.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。

         将图像顺时针旋转 90 度。

         说明：

         你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

         示例 1:

         给定 matrix =
         [
         [1,2,3],
         [4,5,6],
         [7,8,9]
         ],

         原地旋转输入矩阵，使其变为:
         [
         [7,4,1],
         [8,5,2],
         [9,6,3]
         ]
 */
public class RotatePic {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        new RotatePic().rotate(matrix);
    }

    public void rotate(int[][] matrix) {

        int length= matrix.length;

        //给矩阵以正对角线交换
        for(int i = 0; i < length; i ++){

            for(int j = 0; j < length; j ++){

                if (i + j < length -1){

                    int tempLength = length -1 -i -j;

                    int temp = matrix[i + tempLength][j + tempLength];

                    matrix[i + tempLength][j + tempLength] = matrix[i][j];

                    matrix[i][j] = temp;
                }else {
                    break;
                }
            }
        }

        //第i行与第 n-1-i 行交换
        for(int i = 0; i < length/2; i ++){

            for(int j = 0; j < length; j++){

                int temp = matrix[i][j];

                matrix[i][j] = matrix[length -1 - i][j];

                matrix[length -1 - i][j] = temp;
            }
        }

    }
}
