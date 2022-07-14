package com.imran.commadline;

import com.imran.controller.BinarySearchTreeController;
import com.imran.strategies.Strategy;

import java.util.Arrays;
import java.util.List;

public class InsertNodeCommand implements CommandLine{

    private BinarySearchTreeController binarySearchTreeController;

    public InsertNodeCommand(BinarySearchTreeController binarySearchTreeController) {
        this.binarySearchTreeController = binarySearchTreeController;
    }

    @Override
    public boolean parse(String input) {
        if(input==null || input.isEmpty()) return false;
        List<String> tokens = Arrays.asList(input.split(" "));

        if(tokens.size()!=6 || !tokens.get(0).equalsIgnoreCase(CommandLineConstant.INSERT)
                || !tokens.get(1).equalsIgnoreCase(CommandLineConstant.INTO)
                || !tokens.get(2).equalsIgnoreCase(CommandLineConstant.TREE)
                || !tokens.get(4).equalsIgnoreCase(CommandLineConstant.VALUE))
            return false;

        return true;
    }

    @Override
    public boolean execute(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));

        binarySearchTreeController.insertNodeInTreeById(tokens.get(3),Integer.parseInt(tokens.get(5)));

        return true;
    }
}
//  0       1   2   3   4    5
// INSERT INTO TREE T1 VALUE 3;
