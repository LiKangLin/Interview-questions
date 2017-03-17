package QuestionTest;

import java.util.Stack;

/**
 * Created by L_kanglin on 2017/3/15.
 * 编写一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peak)
 * 思路：一个栈作为压入栈，在压入数据时只往这个栈中压入，记为stackPush；
 * 另一个栈只作为弹出栈，在弹出数据时只从这个栈弹出，记为stackPop
 *
 * 两点：
 * (1)如果stackPush要往stackPush中压入数据，那么必须一次性把satckPush中的数据
 *    全部压入
 * (2)如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
 */
public class Test2 {
    public static void main(String[] args){

    }
    public class TwoStackQueue{
        Stack<Integer> stackPush = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();
        public void add(int pushInt){
            stackPush.push(pushInt);
        }
        public int poll(){
            if(stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("queue is empty");
            }else if(stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();

        }

        public int peak(){
            if(stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("queue is empty");
            }else if(stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
