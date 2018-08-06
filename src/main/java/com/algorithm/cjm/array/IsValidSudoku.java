package com.algorithm.cjm.array;


/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

     数字 1-9 在每一行只能出现一次。
     数字 1-9 在每一列只能出现一次。
     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


     数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class IsValidSudoku {

    public static void main(String[] args) {

        char[][] board ={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            };

        new IsValidSudoku().isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {

        boolean isflag = true;

        for(int x = 0; x < 3; x++){

            for(int y = 0; y < 3; y++){

                int[] nums = new int[9];
                int k = 0;

                for(int i = 3 * x; i < 3 * x + 3; i++){

                    for(int j = 3 * y; j < 3 * y + 3; j ++){

                        if(board[i][j] != '.'){
                            nums[k++] = board[i][j] - 48;
                        }

                    }
                }

                isflag = isDuplicates(nums);

                if(!isflag){
                    return isflag;
                }
            }
        }

        for(int i = 0 ; i < 9; i ++){

            int[] nums1 = new int[9];
            int[] nums2 = new int[9];
            int k = 0;
            int v = 0;

            for(int j= 0; j < 9; j++){

                if(board[i][j] != '.'){
                    nums1[k++] = board[i][j] - 48;
                }
                if(board[j][i] != '.'){
                    nums2[v++] = board[j][i] - 48;
                }
            }

            isflag = isDuplicates(nums1);

            if(!isflag){
                return isflag;
            }

            isflag = isDuplicates(nums2);

            if(!isflag){
                return isflag;
            }
        }

        return isflag;
    }

    /**
     * 判断数组是否重复
     * @param nums
     * @return
     */
    public boolean isDuplicates(int[] nums){

        for(int i = 0; i < nums.length; i ++){

            for(int j = i + 1 ; j < nums.length; j ++){

                if(nums[i] == nums[j] && nums[i]!= 0){
                    return false;
                }
            }
        }
        return true;
    }

}
