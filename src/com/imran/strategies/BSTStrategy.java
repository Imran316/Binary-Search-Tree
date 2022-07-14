package com.imran.strategies;

import com.imran.model.Node;

public class BSTStrategy implements BinarySearchTreeStrategy{

    @Override
    public Node insert(Node root, int value) {
        if(root == null)
        {
            return new Node(value);
        }
        if(root.data > value)
            root.left = insert(root.left,value);
        else
            root.right = insert(root.right,value);

        calculateHeight(root);
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

            calculateHeight(root);
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

        int leftHeight = root.left!=null?root.left.height:0;
        int rightHeight = root.right!=null?root.right.height:0;

        root.height = Math.max(leftHeight,rightHeight)+1;
        return root.height;
    }
}









