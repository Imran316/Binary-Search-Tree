package com.imran.commadline;

import com.imran.controller.BinarySearchTreeController;
import com.imran.strategies.Strategy;

import java.util.Arrays;
import java.util.List;

public class CreateTreeCommand implements CommandLine{

    private BinarySearchTreeController binarySearchTreeController;

    public CreateTreeCommand(BinarySearchTreeController binarySearchTreeController) {
        this.binarySearchTreeController = binarySearchTreeController;
    }

    @Override
    public boolean parse(String input) {
        if(input==null || input.isEmpty()) return false;
        List<String> tokens = Arrays.asList(input.split(" "));

        if(tokens.size()!=5 || !tokens.get(0).equalsIgnoreCase(CommandLineConstant.CREATE)
            || !tokens.get(1).equalsIgnoreCase(CommandLineConstant.TREE)
            || !tokens.get(3).equalsIgnoreCase(CommandLineConstant.USING))
            return false;

        return true;
    }

    @Override
    public boolean execute(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));

        Strategy bstStrategy = null;
        if(tokens.get(4).equalsIgnoreCase(CommandLineConstant.AVL))
            bstStrategy = Strategy.AVL_BST;
        else if(tokens.get(4).equalsIgnoreCase(CommandLineConstant.SIMPLE))
            bstStrategy = Strategy.SIMPLE_BST;
        binarySearchTreeController.createTree(tokens.get(2),bstStrategy);

        return true;
    }
}
//    0    1    2   3   4
// CREATE TREE T1 USING AVL;
