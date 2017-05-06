package com.elementalsource.drink.strategy.impl;

import com.elementalsource.drink.strategy.DrinkingStrategy;
import org.springframework.stereotype.Component;

@Component
public class DrinkingStrategyWheatBeer implements DrinkingStrategy {

    public String toTaste() {
        return "Drinking wheat beer";
    }
}
