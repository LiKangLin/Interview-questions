package QuestionTest;

import java.util.Scanner;

/**
 * Created by L_kanglin on 2017/3/21.
 * 问题描述：统计字符串
 * 如输入：aabbcc
 * 输出：2a2b2c
 */
public class Test11 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        if(str==null || str.equals(" ")){
            return ;
        }
        char[] chs =str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num=1;
        for(int i=1;i<chs.length;i++){
            if(chs[i]!=chs[i-1]){
                res=concat(res,String.valueOf(num),String.valueOf(chs[i]));
                num=1;
            }else{
                num++;
            }
        }
        System.out.println(concat(res,String.valueOf(num),""));
    }

    public static String concat(String s1, String s2, String s3){
        return s1+s2+s3;
    }
}
