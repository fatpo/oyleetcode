package tree;


/*
*
* 144. Binary Tree Preorder Traversal
Medium

800

40

Favorite

Share
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?


思路1：递归。
思路2：用栈模拟。

*
* */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144_BinaryTreePreorderTraversal {
    private List<Integer> res =new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
            if(root ==null){
                return res;
            }

            helper(root);
            return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root ==null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if(curNode != null){
                res.add(curNode.val);
                stack.add(curNode.right);
                stack.add(curNode.left);
            }
        }

        return res;
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }

        System.out.println(root.val);
        res.add(root.val);
        if (root.left != null){
            preorderTraversal(root.left);
        }
        if (root.right != null){
            preorderTraversal(root.right);
        }
    }

}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



