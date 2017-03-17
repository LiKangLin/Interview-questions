package QuestionTest;

import java.util.Stack;

/**
 * Created by L_kanglin on 2017/3/15.
 * 用一个栈实现另一个栈
 * 问题描述：一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只许申请一个栈，除此之外，可以申请新的变量，但不能申请额外的数据结构，如何完
 * 成排序
 */

/*
* 解题思路：将要排序的栈记为stack，申请的辅助栈记为help。在stack上执行pop操作，弹出
* 的元素记为cur
* (1)如果cur小于或等于help的栈顶元素，则将cur直接压入help
* (2)如果cur大于help的栈顶元素，则将help的元素逐一弹出，逐一压入stack，直到cur小于
* 或等于help的栈顶元素，再将cur压入help
* **/
public class Test3 {
    public static void main(String[] args){
        int [] aa={3,5,1,2,4};
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<aa.length;i++){
            stack.push(aa[i]);
        }
        sortStackByStack(stack);
        while(!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }
    }
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty()&&help.peek()>cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        //此时help中保存的就是从栈顶到底是从小到大，全部push到stack中即可
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
