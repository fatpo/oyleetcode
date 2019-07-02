package tree;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by ouyang on 2019/7/2.
 */
public class Leetcode94_BinaryTreeInorderTraversal {
    private List<Integer> res = new ArrayList<>();


    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null){
            return res;
        }

        Boolean isPush = true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curNode = stack.peek();

            // 左：压栈
            if (curNode.left != null && isPush){
                stack.push(curNode.left);
                isPush = true;
                continue;
            }


            // 根：无左孩子的 或者 由左孩子弹回来的，出栈ß
            if(curNode.left == null || !isPush){
                isPush = false;
                res.add(stack.pop().val);
                continue;
            }

            // 右：判断右节点不为空，则压栈
            if (curNode.right != null){
                stack.push(curNode.right);
                isPush = true;
                continue;
            }
        }

        return res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null){
            return res;
        }
        helper(root);

        return res;
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}




