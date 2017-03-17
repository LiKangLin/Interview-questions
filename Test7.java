package QuestionTest;

import java.util.Stack;

/**
 * Created by L_kanglin on 2017/3/17.
 * 问题描述：反转单向链表
 * 要求：如果链表长度为N，时间复杂度为O(N)
 *额外空间复杂度要求为O(1)
 */

/*
* 思路：借助辅助空间栈，但此时额外空间复杂度为N，
* 不满足要求,所以通过移位
* **/
public class Test7 {
    public static void main(String[] args){

    }
    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }
    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }


}
