package com.imran.registry.strategyregistry;

import com.imran.strategies.BinarySearchTreeStrategy;
import com.imran.strategies.Strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyRegistryImpl implements StrategyRegistry{
    Map<Strategy,BinarySearchTreeStrategy> strategyMap = new HashMap<>();
    @Override
    public BinarySearchTreeStrategy getBinarySearchTreeStrategy(Strategy strategy) {
        return strategyMap.getOrDefault(strategy,null);
    }

    @Override
    public void addStrategy(Strategy strategy, BinarySearchTreeStrategy binarySearchTreeStrategy) {
        strategyMap.put(strategy,binarySearchTreeStrategy);
    }

    @Override
    public void removeStrategy(Strategy strategy) {
        strategyMap.remove(strategy);
    }
}
