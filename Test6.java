package QuestionTest;

/**
 * Created by L_kanglin on 2017/3/15.
 * 问题描述：在单链表中删除倒数第K个结点
 * 要求：如果链表长度为N，时间复杂度达
 * 到O(n),额外空间复杂度达到O(1)
 */

/*
* 思路：如果链表为空或者K值小于1，这种情
* 况下，参数是无效的，直接返回即可，除此
* 之外，让链表从头开始走到尾，每移动一步，
* 每移动一步，就让K值减1.
* */

/*
* 具体思路：让链表从头开始走到尾，每移动一步，
* 就让K值减小，当链表走到结尾时，如果K值大于0，
* 说明不用调整链表，因为链表根本没有倒数第K个
* 节点，此时将原链表直接返回即可；如果K值等于
* 0，说明链表倒数第K个节点就是头结点，此时直
* 接返回head.next,也就是原链表的第二个节点，
* 让第二个节点作为链表的投返回即可，相当于删
* 除头结点，主要是处理K小于0的情况
*
* 方法如下：重新从头结点开始走，每移动一步，就让K的值加1；
* 当K等于0时，移动停止，移动到的结点就是要删除节点的前一个结点。
*
*
* */
public class Test6 {
    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }

    public Node removeLastKthNode(Node head,int lastKth){
        if(head==null &&lastKth<1){
            return head;
        }
        Node cur=head;
        while(cur !=null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth ==0){
            head=head.next;
        }
        if(lastKth<0){
            cur=head;
            while(++lastKth!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }

}
