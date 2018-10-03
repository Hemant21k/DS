package com.ds.examples;
// non-recursive java program for inorder traversal
import java.util.Stack;
 
/* Class containing left and right child of
current node and key value*/
class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
/* Class to print the inorder traversal */

