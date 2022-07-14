package com.imran.registry.strategyregistry;

import com.imran.strategies.BinarySearchTreeStrategy;
import com.imran.strategies.Strategy;

public interface StrategyRegistry {
    BinarySearchTreeStrategy getBinarySearchTreeStrategy(Strategy strategy);
    void addStrategy(Strategy strategy, BinarySearchTreeStrategy binarySearchTreeStrategy);
    void removeStrategy(Strategy strategy);
}
