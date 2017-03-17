package QuestionTest;

/**
 * Created by L_kanglin on 2017/3/15.
 * 题目：给定两个有序链表的头指针head1和
 * head2，打印两个链表的公共部分
 */
/*
* 解题思路：由于是有序链表，所以从两个链表的投开始进行如下判断：
* (1)如果head1的值小于head2，则head1往下移动
* (2)如果head2的值小于head1，则head2往下移动
* (3)如果head1和head2的值相等，则打印这个值，
*     然后head1和head2都往下移动
* (4)head1或head2有任何一个移动到null，整个过程停止
* */
public class Test4 {
    public static void main(String[] args){
        int [] aa={1,2,3,4,5};
        int [] bb={1,2,4,5,6};

    }
    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }
    public void printCommonPart(Node head1,Node head2){
        System.out.print("common Part: ");
        while(head1!=null && head2 !=null){
            if(head1.value<head2.value){
                head1=head1.next;
            }else if(head1.value>head2.value){
                head2=head2.next;
            }else{
                System.out.print(head1.value+" ");
                head1=head1.next;
                head2=head2.next;
            }
        }
        System.out.println();
    }



}
