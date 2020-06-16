package com.challenges.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

    TreeNode root;

    public TreeNode insertNodeRecursively(int val){
        return insertNodeRecursively(this.root, val);
    }

    public TreeNode insertNodeRecursively(TreeNode root, int val){

        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(root.val > val) {
            root.left = insertNodeRecursively(root.left, val);

        } else if (root.val < val){

           root.right = insertNodeRecursively(root.right, val);
        }

        return root;
    }

    public TreeNode insertNodeIteratively(int val){


        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        TreeNode curr = root;
        TreeNode prev =  null;


        while(curr != null) {
            prev = curr;
            if(val > curr.val){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        TreeNode childNode = new TreeNode(val);
        if(prev.val > val) {
            prev.left = childNode;
        } else {
            prev.right = childNode;
        }

        return root;
    }

    public void printInorder(TreeNode root){

        if(root == null) {
            return;
        }
        printInorder (root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public void printPostorder(TreeNode root){

        if(root == null) {
            return;
        }

        printPostorder (root.left);
        printPostorder(root.right);
        System.out.println(root.val);
    }

    public void printPreOrder(TreeNode root){

        if(root == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrder (root.left);
        printPreOrder(root.right);
    }

    public void BFS(TreeNode root){

        //FIFO
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode curr = null;
        queue.add(root);

        while(!queue.isEmpty()){

            curr = queue.peek();

            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
            System.out.println(curr.val);
        }

    }


    public void iterativePreOrder(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode current;


        while(!stack.isEmpty()){
            current = stack.pop();
            System.out.println(current.val);
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }

    }

    public void iterativeInOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {

            //traverse to left most node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            //visit node
            current = stack.pop();
            System.out.println(current.val);

            //move to right subtree
            current = current.right;

        }
    }

        public void iterativePostOrder(TreeNode root){

            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> out = new Stack<>();
            TreeNode current;
            stack.push(root);

            while(!stack.isEmpty()){

                current =  stack.pop();
                out.push(current);

                if(current.left != null)
                    stack.push(current.left);

                if(current.right != null)
                    stack.push(current.right);

            }

            while(!out.isEmpty()){
                System.out.println(out.pop().val);
            }
    }

    public static void main(String[] args) {

        BST bst =   new BST();
        bst.root = bst.insertNodeRecursively(20);
        bst.insertNodeRecursively(18);
        bst.insertNodeRecursively(22);
        bst.insertNodeRecursively(17);
        bst.insertNodeRecursively(19);
        bst.insertNodeRecursively(21);
        bst.insertNodeRecursively(25);

        bst.printPostorder(bst.root);

        System.out.println("******");

        bst.iterativePostOrder(bst.root);

    }
}
