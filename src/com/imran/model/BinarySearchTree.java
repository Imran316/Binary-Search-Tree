package com.imran.model;

import com.imran.strategies.BinarySearchTreeStrategy;

public class BinarySearchTree {


    private String id;
    private Node root;
    private BinarySearchTreeStrategy bstStrategy;

    public BinarySearchTree(String id,BinarySearchTreeStrategy bstStrategy)
    {
        this.id = id;
        root = null;
        this.bstStrategy = bstStrategy;
    }

    public void insert(int value)
    {
        root = bstStrategy.insert(root,value);
    }

    public boolean search(int value)
    {
        return bstStrategy.search(root,value);
    }

    public void delete(int value)
    {
        root = bstStrategy.delete(root,value);
    }

    public void printTree()
    {
        bstStrategy.printTree(root);
    }

    public String getId() {
        return id;
    }
}
