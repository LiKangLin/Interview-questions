package QuestionTest;

/**
 * Created by L_kanglin on 2017/3/17.
 * 反转双向链表
 */
public class Test9 {
    public class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data){
            this.value=data;
        }
    }
    public DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!=null){
            next = head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }
}
