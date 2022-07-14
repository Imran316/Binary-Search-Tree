package com.imran.strategies;

import com.imran.model.Node;

public class AVLTreeStrategy implements BinarySearchTreeStrategy{

    @Override
    public Node insert(Node root, int value) {
        if(root == null)
        {
            return new Node(value);
        }
        else if(root.data > value)
            root.left = insert(root.left,value);
        else
            root.right = insert(root.right,value);

        root = balanceTree(root);

        return root;
    }

    @Override
    public Node delete(Node root, int value) {
        if(root == null)
            return null;
        if(root.data == value)
        {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            Node temp = root.left;
            while(temp.right !=null) temp = temp.right;

            root.data = temp.data;

            root.left = delete(root.left,temp.data);
        }
        else if(root.data > value)
            root.left = delete(root.left,value);
        else
            root.right = delete(root.right,value);

        root = balanceTree(root);

        return root;
    }

    @Override
    public boolean search(Node root, int value) {
        Node temp = root;
        while(temp!=null)
        {
            if(temp.data == value) return true;
            else if(temp.data > value) temp = temp.left;
            else temp = temp.right;
        }
        return false;
    }

    @Override
    public int calculateHeight(Node root) {

        if(root == null)
            return 0;
        int leftHeight = root.left!=null?root.left.height:0;
        int rightHeight = root.right!=null?root.right.height:0;

        root.height = Math.max(leftHeight,rightHeight)+1;
        return root.height;
    }

    private int BF(Node root)
    {
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        return leftHeight - rightHeight;
    }

    private Node rotateLeft(Node root)
    {
        Node rightN = root.right;
        Node rigthLeftN = root.right.left;
        rightN.left = root;
        root.right = rigthLeftN;

        calculateHeight(root);
        calculateHeight(rightN);
        return rightN;
    }

    private Node rotateRight(Node root)
    {
        Node leftN = root.left;
        Node leftRightN = root.left.right;
        leftN.right = root;
        root.left = leftRightN;

        calculateHeight(root);
        calculateHeight(leftN);

        return leftN;
    }

    private Node LL(Node root)
    {
        return rotateRight(root);
    }

    private Node RR(Node root)
    {
        return rotateLeft(root);
    }

    private Node LR(Node root)
    {
        root.left = rotateLeft(root.left);
        return rotateRight(root);
    }

    private Node RL(Node root)
    {
        root.right = rotateRight(root.right);
        return rotateLeft(root);
    }

    public Node balanceTree(Node root)
    {
        if(root==null)   return null;

        if(BF(root) > 1)
        {
            if(BF(root.left) > 0)
                root = LL(root);
            else
                root = LR(root);
        }
        else if(BF(root) < -1)
        {
            if(BF(root.right) < 0)
                root = RR(root);
            else
                root = RL(root);
        }

        calculateHeight(root);
        return root;
    }
}
