package com.imran.controller;

import com.imran.model.BinarySearchTree;
import com.imran.service.BinarySearchTreeService;
import com.imran.strategies.Strategy;

public class BinarySearchTreeController {
    private BinarySearchTreeService binarySearchTreeService;

    public BinarySearchTreeController(BinarySearchTreeService binarySearchTreeService) {
        this.binarySearchTreeService = binarySearchTreeService;
    }

    public BinarySearchTree createTree(String id, Strategy bstStrategy)
    {
        return binarySearchTreeService.createTree(id,bstStrategy);
    }

    public boolean insertNodeInTreeById(String id, int value)
    {
        return binarySearchTreeService.insertNodeInTreeById(id,value);
    }

    public boolean deleteNodeInTreeById(String id, int value)
    {
        return binarySearchTreeService.deleteNodeInTreeById(id,value);
    }

    public boolean searchNodeInTreeById(String id, int value)
    {
        if(binarySearchTreeService.searchNodeInTreeById(id,value)) {
            System.out.println(value + " is Found in TREE " + id);
            return true;
        }
        System.out.println("No such value found");
        return false;
    }

    public boolean printTreeById(String id)
    {
        return binarySearchTreeService.printTreeById(id);
    }
}
