package com.imran;

import com.imran.commadline.*;
import com.imran.controller.BinarySearchTreeController;
import com.imran.registry.commandregistry.CommandRegistry;
import com.imran.registry.commandregistry.CommandRegistryImpl;
import com.imran.registry.strategyregistry.StrategyRegistry;
import com.imran.registry.strategyregistry.StrategyRegistryImpl;
import com.imran.repository.InMemoryBinarySearchTreeRepository;
import com.imran.service.BinarySearchTreeService;
import com.imran.strategies.AVLTreeStrategy;
import com.imran.strategies.BSTStrategy;
import com.imran.strategies.Strategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StrategyRegistry strategyRegistry = new StrategyRegistryImpl();
        strategyRegistry.addStrategy(Strategy.AVL_BST,new AVLTreeStrategy());
        strategyRegistry.addStrategy(Strategy.SIMPLE_BST,new BSTStrategy());

        BinarySearchTreeService binarySearchTreeService = new BinarySearchTreeService(
                new InMemoryBinarySearchTreeRepository(),
                strategyRegistry
                );

        BinarySearchTreeController binarySearchTreeController = new BinarySearchTreeController(binarySearchTreeService);

        CommandRegistry commandRegistry = new CommandRegistryImpl();

        commandRegistry.addCommand(new CreateTreeCommand(binarySearchTreeController));
        commandRegistry.addCommand(new DeleteCommand(binarySearchTreeController));
        commandRegistry.addCommand(new InsertNodeCommand(binarySearchTreeController));
        commandRegistry.addCommand(new PrintCommand(binarySearchTreeController));
        commandRegistry.addCommand(new SearchCommand(binarySearchTreeController));

        Scanner scanner = new Scanner(System.in);

        String input = "NA";
        while(!input.equalsIgnoreCase("QUIT"))
        {
            input = scanner.nextLine();
            commandRegistry.executeCommandForInput(input);
        }
    }
}
/*
    CREATE TREE T1 USING AVL
    DELETE FROM TREE T1 VALUE 3
    INSERT INTO TREE T1 VALUE 3
    PRINT TREE T1
    SELECT 3 FROM TREE T1
*/
