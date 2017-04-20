package QuestionTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by L_kanglin on 2017/4/10.
 * 二叉树的层次遍历，也就是二叉树的广度优先遍历，使用队列来实现
 * 主要是让LinkedList实现Deque接口，将每一个结点装入到队列中，然后利用队列的pop弹出，获取该结点的值
 * 而二叉树的深度优先遍历就是分三种：先序，后序、中序
 */
public class Test15 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode t = deque.pop();
            list.add(t.val);
            if(t.left != null) deque.add(t.left);
            if(t.right != null) deque.add(t.right);
        }
        return list;
    }
}
