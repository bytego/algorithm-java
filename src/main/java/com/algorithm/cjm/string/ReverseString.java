package com.algorithm.cjm.string;

/**
 *
     请编写一个函数，其功能是将输入的字符串反转过来。

     示例：

     输入：s = "hello"
     返回："olleh"
 */
public class ReverseString {

    public String reverseString(String s) {

        char[] chars = s.toCharArray();

        int i = 0;
        for(char c : chars){

            if(i < chars.length/2){
                char temp = chars[i];

                chars[i] = chars[chars.length -1 -i];

                chars[chars.length -1 -i] = temp;

                i ++;
            }else {
                break;
            }
        }

        s = String.valueOf(chars);

        return s;
    }
}
