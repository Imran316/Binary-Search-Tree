package com.imran.commadline;

import com.imran.controller.BinarySearchTreeController;

import java.util.Arrays;
import java.util.List;

public class SearchCommand implements CommandLine{

    private BinarySearchTreeController binarySearchTreeController;

    public SearchCommand(BinarySearchTreeController binarySearchTreeController) {
        this.binarySearchTreeController = binarySearchTreeController;
    }

    @Override
    public boolean parse(String input) {
        if(input==null || input.isEmpty()) return false;
        List<String> tokens = Arrays.asList(input.split(" "));

        if(tokens.size()!=5 || !tokens.get(0).equalsIgnoreCase(CommandLineConstant.SELECT)
                || !tokens.get(2).equalsIgnoreCase(CommandLineConstant.FROM)
                || !tokens.get(3).equalsIgnoreCase(CommandLineConstant.TREE))
            return false;

        return true;
    }

    @Override
    public boolean execute(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));
        binarySearchTreeController.searchNodeInTreeById(tokens.get(4),Integer.parseInt(tokens.get(1)));
        return true;
    }
}
//  0     1   2   3   4
// SELECT 3 FROM TREE T1;
