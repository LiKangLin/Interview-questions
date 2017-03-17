package QuestionTest;

/**
 * Created by L_kanglin on 2017/3/17.
 *环形单链表的约瑟夫问题
 */
/*
* 题目描述：据说著名犹太历史学家Josephus有过以下故事：
* 在罗马人占领乔塔帕特后，39个犹太人与Josephus及他的
* 朋友躲到洞中，39个犹太人决定宁愿死也不要被敌人抓到，
* 于是决定了一个自杀方式，41个人排成一个圆圈，由第一
* 个人开始报数，报数到3的人就自杀，然后再由下一个人
* 重新报1，报数到3的人再自杀，这样依次下去，知道剩下
* 最后一个人时，那个人可以自由选择自己的命运。这就是
* 著名的约瑟夫问题。现在请用单向唤醒链表描述该结构并
* 呈现整个自杀过程。
* 输入为一个环形单向链表的头结点head和报数的值m。
* 返回：最后生存下来的节点，且这个节点自己组成环形单
* 向链表，其它节点都删掉
* */

/*
* 思路：
* (1)如果链表为空或者链表的节点数为1，或者m的值小于1，
*    则不用调整就直接返回。
* (2)在环形链表中遍历某个节点，不断转圈，不断让每个节点报数。
* (3)当报数到达m时，就删除当前报数的节点。
* (4)删除节点后，别忘了还要把剩下的节点继续连接成环状，继续转
*    圈报数，继续删除。
* (5)不停的删除，直到环形链表中只剩一个节点，过程结束。
*
* */

/**
 * 每删除一个掉一个节点，都需要遍历m次，一共需要删除的节点数为n-1，
 * 所以此时的时间复杂度为O(nxm)
 *
 * **/
public class Test10 {
    public class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value=data;
        }
    }
    public Node josephusKilll(Node head,int m){
        if (head==null || head.next==head || m<1){
            return head;
        }
        Node last = head;

        /*将last设置为最后一个节点*/
        while(last.next !=head){
            last=last.next;
        }

        int count=0;

        //循环的条件
        while(head != last){
            count++;
            //满m减去当前节点
            if(count==m){
                last.next=head.next;
                count=0;
            }else{
                //如果没满m则删去当前节点
                last=last.next;
            }
            head=last.next;
        }
        return head;
    }
}
