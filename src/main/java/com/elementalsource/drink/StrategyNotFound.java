package com.elementalsource.drink;

public class StrategyNotFound extends RuntimeException {
    public StrategyNotFound(String message) {
        super(message);
    }
}
