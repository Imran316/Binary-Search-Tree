package com.imran.service;

import com.imran.model.BinarySearchTree;
import com.imran.registry.strategyregistry.StrategyRegistry;
import com.imran.repository.BinarySearchTreeRepository;
import com.imran.strategies.BinarySearchTreeStrategy;
import com.imran.strategies.Strategy;

public class BinarySearchTreeService {
    private BinarySearchTreeRepository binarySearchTreeRepository;
    private StrategyRegistry strategyRegistry;

    public BinarySearchTreeService(BinarySearchTreeRepository binarySearchTreeRepository, StrategyRegistry strategyRegistry) {
        this.binarySearchTreeRepository = binarySearchTreeRepository;
        this.strategyRegistry = strategyRegistry;
    }

    public BinarySearchTree createTree(String id, Strategy bstStrategy)
    {
        BinarySearchTreeStrategy binarySearchTreeStrategy = strategyRegistry.getBinarySearchTreeStrategy(bstStrategy);
        if(binarySearchTreeStrategy == null)
            return null;
        BinarySearchTree binarySearchTree = new BinarySearchTree(id,binarySearchTreeStrategy);
        return binarySearchTreeRepository.save(binarySearchTree);
    }

    public boolean insertNodeInTreeById(String id, int value)
    {
        BinarySearchTree binarySearchTree = binarySearchTreeRepository.findById(id);
        if(binarySearchTree == null)
            return false;
        binarySearchTree.insert(value);
        binarySearchTreeRepository.save(binarySearchTree);
        return true;
    }

    public boolean deleteNodeInTreeById(String id, int value)
    {
        BinarySearchTree binarySearchTree = binarySearchTreeRepository.findById(id);
        if(binarySearchTree == null)
            return false;
        binarySearchTree.delete(value);
        binarySearchTreeRepository.save(binarySearchTree);
        return true;
    }

    public boolean searchNodeInTreeById(String id, int value)
    {
        BinarySearchTree binarySearchTree = binarySearchTreeRepository.findById(id);
        if(binarySearchTree == null)
            return false;
        return binarySearchTree.search(value);
    }

    public boolean printTreeById(String id)
    {
        BinarySearchTree binarySearchTree = binarySearchTreeRepository.findById(id);
        if(binarySearchTree == null)
            return false;
        binarySearchTree.printTree();
        return true;
    }
}
