package com.imran.strategies;

import com.imran.model.Node;

import java.util.LinkedList;
import java.util.Queue;

public interface BinarySearchTreeStrategy {
    Node insert(Node root, int value);
    Node delete(Node root, int value);
    boolean search(Node root,int value);
    int calculateHeight(Node root);

    default void printTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node node = q.poll();
                System.out.print(node.data+" ");

                if(node.left != null)
                    q.add(node.left);
                if(node.right !=null)
                    q.add(node.right);
            }
            System.out.println("");
        }
    }
}
