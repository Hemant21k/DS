package com.ds.examples;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeTest {

	class Node {

		Node(int data) {
			this.data = data;
		}

		Node left = null;
		Node right = null;
		int data;
	}

	Node root;

	BinaryTreeTest() {
		root = null;
	}

	public void insert(int key) {
		recInsert(root,key);

	}
	
	public Node recInsert(Node node,int key) {
		if(node == null) {
			root = new Node(key);
			return root;
		}
		
		if(key < node.data) {
			if(node.left == null) {
				node.left = new Node(key);
			} else {
				recInsert(node.left,key);
			}
			
		} else {
			if(node.right == null) {
				node.right = new Node(key);
			} else {
				recInsert(node.right,key);
			}
		}
		
		return root;
	}
	
    // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }
    
    void inorderItr() {
    	Deque<Node> stack = new ArrayDeque<Node>();
        Node curr = root;
        
        while(curr !=null || !stack.isEmpty()) {
        	stack.push(curr);
        	if(curr.left != null)
        		curr = curr.left;
        	else {
        		Node temp = stack.pop();
        		System.out.println(temp.data);
        		if(temp.right!=null)
        			curr = temp.right;
        		else
        			curr = stack.peek().right;
        	}
        		
        }
    	
    }
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeTest tree = new BinaryTreeTest();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        //tree.inorder();
        
        //tree.inorderItr();

	}

}
