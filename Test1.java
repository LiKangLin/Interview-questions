package QuestionTest;

import java.util.Stack;

/**
 * Created by L_kanglin on 2017/3/15.
 * 问题描述：设计一个特殊功能的栈，在实现栈的基本功能的
 * 基础上，再实现返回栈中最小元素的操作。
 * 要求1：pop、push、getMin操作的时间复杂度都是O(1)
 *     2:设计的栈类型可以使用现成的栈结构
 * 思路：在设计上我们使用两个栈，一个栈用来保存当前栈中的元素，其功能
 * 和一个正常的栈的没有区别，这个栈记为stackData；另一个用于保存每一
 * 步的最小值，这个栈记为stackMin
 *
 */
public class Test1 {
    public static void main(String[] args){

    }
    public class myStack{
        Stack<Integer> stackData = new Stack<Integer>();
        Stack<Integer> stackMin  = new Stack<Integer>();

        public void push(int newNum){
            if(stackMin.isEmpty()){
                stackMin.push(newNum);
            }else if(newNum<this.getMin()){
                stackMin.push(newNum);
            }
            stackData.push(newNum);

        }

        public int pop(){
            if(stackMin.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            int value= stackData.pop();
            if(value==this.getMin()){
                stackMin.pop();
            }
            return value;
        }

        public int getMin(){
            if(stackMin.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return stackMin.peek();
        }
    }
}

