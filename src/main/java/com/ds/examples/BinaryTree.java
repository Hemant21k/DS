package com.ds.examples;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


class BinaryTree
{
    Node root;
    void inorder()
    {
        if (root == null)
            return;
 
 
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
 
        // traverse the tree
        while (curr != null || s.size() > 0)
        {
 
            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }
 
            /* Current must be NULL at this point */
            curr = s.pop();
 
            System.out.print(curr.data + " ");
 
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }
 
    void inorderItr() {
    	Deque<Node> stack = new ArrayDeque<Node>();
        Node curr = root;
        
        while(curr!=null || !stack.isEmpty()) {

        	if(curr != null) {
            	stack.push(curr);
        		curr = curr.left;
        	}
        	else {
      		
        		Node temp = stack.pop();
        		System.out.print(temp.data+ " ");
        			curr = temp.right;

        	}
        		
        }
    	
    }
    
    void inorderMorris() {
    	Node curr = root;
    	Node currLft = null;
    	while(curr != null) {
    		if(curr.left!=null) {
    			currLft = curr.left;
    			while(currLft.right!= null && currLft.right!=curr) {
    				currLft = currLft.right;
    			}
    			if(currLft.right!=curr) {
    				currLft.right = curr;
    				curr = curr.left;
    			} else {
    				System.out.println(curr.data);
    				currLft.right = null;
    				curr = curr.right;
    			}
    			
    		} else {
    			System.out.println(curr.data);
    			curr = curr.right;
    		}
    		
    	}
    }
    
    public static void main(String args[])
    {
 
        /* creating a binary tree and entering
        the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
        tree.inorderItr();
        System.out.println("morris way");
        tree.inorderMorris();
    }
}