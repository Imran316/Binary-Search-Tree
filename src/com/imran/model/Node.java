package com.imran.model;

public class Node {
    public int data;
    public int height;
    public Node left,right;

    public Node()
    {
        data = 0;
        height = 1;
        left=right=null;
    }

    public Node(int data)
    {
        this.height = 1;
        this.data = data;
        left = right = null;
    }
}
