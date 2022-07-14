package com.imran.commadline;

import com.imran.controller.BinarySearchTreeController;

import java.util.Arrays;
import java.util.List;

public class DeleteCommand implements CommandLine{

    private BinarySearchTreeController binarySearchTreeController;

    public DeleteCommand(BinarySearchTreeController binarySearchTreeController) {
        this.binarySearchTreeController = binarySearchTreeController;
    }

    @Override
    public boolean parse(String input) {
        if(input==null || input.isEmpty()) return false;
        List<String> tokens = Arrays.asList(input.split(" "));

        if(tokens.size()!=6 || !tokens.get(0).equalsIgnoreCase(CommandLineConstant.DELETE)
                || !tokens.get(1).equalsIgnoreCase(CommandLineConstant.FROM)
                || !tokens.get(2).equalsIgnoreCase(CommandLineConstant.TREE)
                || !tokens.get(4).equalsIgnoreCase(CommandLineConstant.VALUE))
            return false;

        return true;
    }

    @Override
    public boolean execute(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));
        binarySearchTreeController.deleteNodeInTreeById(tokens.get(3),Integer.parseInt(tokens.get(5)));
        return true;
    }
}
//    0    1    2   3   4   5
//DELETE FROM TREE T1 VALUE 3;
