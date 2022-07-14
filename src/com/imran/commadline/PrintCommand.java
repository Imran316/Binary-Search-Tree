package com.imran.commadline;

import com.imran.controller.BinarySearchTreeController;

import java.util.Arrays;
import java.util.List;

public class PrintCommand implements CommandLine{

    private BinarySearchTreeController binarySearchTreeController;

    public PrintCommand(BinarySearchTreeController binarySearchTreeController) {
        this.binarySearchTreeController = binarySearchTreeController;
    }

    @Override
    public boolean parse(String input) {
        if(input==null || input.isEmpty()) return false;
        List<String> tokens = Arrays.asList(input.split(" "));

        if(tokens.size()!=3 || !tokens.get(0).equalsIgnoreCase(CommandLineConstant.PRINT)
                || !tokens.get(1).equalsIgnoreCase(CommandLineConstant.TREE))
            return false;

        return true;
    }

    @Override
    public boolean execute(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));
        binarySearchTreeController.printTreeById(tokens.get(2));
        return true;
    }
}
//    0    1    2
// PRINT TREE T1;
