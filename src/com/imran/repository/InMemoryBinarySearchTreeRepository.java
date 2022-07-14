package com.imran.repository;

import com.imran.model.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;

public class InMemoryBinarySearchTreeRepository implements BinarySearchTreeRepository{

    Map<String,BinarySearchTree> binarySearchTreeMap = new HashMap<>();
    @Override
    public BinarySearchTree save(BinarySearchTree binarySearchTree) {
        binarySearchTreeMap.put(binarySearchTree.getId(),binarySearchTree);
        return binarySearchTreeMap.get(binarySearchTree.getId());
    }

    @Override
    public void deleteById(String id) {
        binarySearchTreeMap.remove(id);
    }

    @Override
    public BinarySearchTree findById(String id) {
        return binarySearchTreeMap.getOrDefault(id,null);
    }
}
