package QuestionTest;

import java.util.Stack;

/**
 * Created by L_kanglin on 2017/3/17.
 */
/*
* 思路：借助辅助空间栈，但此时额外空间复杂度为N，
* 不满足要求,所以通过移位
* **/
public class Test8 {
    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }

    public Node reverseListStack(Node head){
        Stack<Node> stack=new Stack<Node>();
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        return stack.peek();
    }

}
