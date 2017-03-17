package QuestionTest;

import java.util.Scanner;

/**
 * Created by L_kanglin on 2017/3/15.
 * 求一个整数的所有质数因子
 */
public class Test5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        if(num<=1){
            return;
        }
        while(true){
            for(int i=2;i<=num;i++){
                if(num%i==0){
                    num=num/i;
                    System.out.print(i+" ");
                    break;
                }
            }
        }
    }
}
