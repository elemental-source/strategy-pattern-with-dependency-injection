package com.elementalsource.drink.strategy.impl;

import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import org.springframework.stereotype.Component;

@Component
public class DrinkingStrategyLager implements DrinkingStrategy {

    public String toTaste() {
        return "Drinking lager";
    }

    public BeerType getBeerType() {
        return BeerType.LAGER;
    }

}
