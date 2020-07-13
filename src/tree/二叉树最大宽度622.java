package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
* 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入:

           1
         /   \
        3     2
       / \     \
      5   3     9

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


执行结果：通过
显示详情
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了100.00%的用户

* */

public class 二叉树最大宽度622 {

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Node {
    TreeNode root;
    int level;
    int pos;

    Node(TreeNode root, int level, int pos) {
        this.root = root;
        this.level = level;
        this.pos = pos;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Node> queue = new LinkedList<>();
        int curLevel = 1;
        int leftPos = 1;
        queue.offer(new Node(root, curLevel, leftPos));
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            if (t.level != curLevel) {
                curLevel = t.level;
                leftPos = t.pos;
            }
            ans = Math.max(ans, t.pos - leftPos + 1);
            if (t.root.left != null) {
                queue.offer(new Node(t.root.left, curLevel + 1, 2 * t.pos));
            }
            if (t.root.right != null) {
                queue.offer(new Node(t.root.right, curLevel + 1, 2 * t.pos + 1));
            }
        }
        return ans;
    }
}