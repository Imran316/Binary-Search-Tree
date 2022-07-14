package com.imran.repository;

import com.imran.model.BinarySearchTree;

public interface BinarySearchTreeRepository {
    BinarySearchTree save(BinarySearchTree binarySearchTree);
    void deleteById(String id);
    BinarySearchTree findById(String id);
}
