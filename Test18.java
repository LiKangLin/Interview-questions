package QuestionTest;


import java.util.Scanner;

/**
 * Created by L_kanglin on 2017/4/16.
 * 链表与数组排序的不同在于，数组里通过下标交换的开销是O(1)的，而链表是O(n)的。所以，直接照搬数组的快速排序到链表，速度会很慢。

 但是链表有一个优点，就是把元素移动到尾部，时间是O(1)的。

 思路如下：

 将链表的第一个元素设置为pivot，遍历之后的n-1个元素，如果该元素的值大于pivot，则将其放在链表末尾（O(1)时间）。遍历所需时间是O(n)的。遍历之后，数组分为三个部分：【pivot】【比pivot小的元素】【比pivot大的元素】，将pivot插入后两部分中间，得到：【比pivot小的元素】【pivot】【比pivot大的元素】，此时，就可以对前后两部分进行递归了。算法复杂度为O（nlog(n)）。

 注意：quick_sort的三个参数分别为：start_pre,指向第一个元素的Node（即start_pre.next=start），len是链表的长度，end是尾指针（注意，end.next不一定为null）
 */
public class Test18 {
    public static void print(ListNode node, int len){
        ListNode temp = node;
        for (int i = 0; i < len-1; i ++){
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public static void quiksort(ListNode start_pre, int len, ListNode end){
        if (len <= 1)
            return;
        ListNode start = start_pre.next;
        int pivot_val = start.val;
        int split_position = 0;

        ListNode temp0 = start;
        ListNode temp1 = start.next;
        for (int i = 1; i < len; i ++){
            if (temp1.val > pivot_val){ //放到链表末尾
                if (temp1 != end){
                    temp0.next = temp1.next;
                    temp1.next = end.next;
                    end.next = temp1;
                    end = temp1;
                    temp1 = temp0.next;
                }
            }
            else{
                temp1 = temp1.next;
                temp0 = temp0.next;

                split_position ++;
            }
        }
        ListNode pivot_node = start;
        if (temp0 != start){
            start_pre.next = pivot_node.next;
            temp0.next = pivot_node;
            pivot_node.next = temp1;
        }
        quiksort(start_pre, split_position, temp0);
        quiksort(pivot_node, len - split_position - 1, end);
    }

    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String[] arr=str.split(",");

     //   3,6,10,7,9,8,1,2,11,17,15,13,12
        int [] array=new int[arr.length];
        int len = array.length;
        for(int i=0;i<array.length;i++){
            array[i]=Integer.parseInt(arr[i]);
        }
        //int [] array = random_order_array(len);
        //int [] array = {0, 3, 2, 8, 6, 9, 7, 5, 1, 4 };
        //int [] array = {3, 2, 8, 6, 9, 7, 5, 1, 4  };
        ListNode start = new ListNode(array[0]);
        ListNode temp = start;
        //放入链表中
        for (int i = 1; i < array.length; i ++){
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        ListNode end = start;
        for (int i = 0; i < len - 1; i ++){
            end = end.next;
        }
        ListNode start_pre = new ListNode(-1);
        start_pre.next = start;

        quiksort(start_pre, len, end);
        print(start_pre.next, len);
    }
    public static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
}

}
