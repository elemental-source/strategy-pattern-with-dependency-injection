package com.elementalsource.drink.model;

import com.elementalsource.drink.strategy.DrinkingStrategy;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyAle;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyLager;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyWheatBeer;
import com.google.common.base.CaseFormat;

public enum BeerType {

    ALE("Ale", DrinkingStrategyAle.class),
    LAGER("Lager", DrinkingStrategyLager.class),
    WHEAT_BEER("WheatBeer", DrinkingStrategyWheatBeer.class);

    private final String description;
    private final Class<? extends DrinkingStrategy> drinkingStrategy;
    private final String strategyName;

    BeerType(String description, Class<? extends DrinkingStrategy> drinkingStrategy) {
        this.description = description;
        this.drinkingStrategy = drinkingStrategy;
        this.strategyName = resolveName();
    }

    protected String resolveName() {
        return "drinkingStrategy" + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name());
    }

    public String getDescription() {
        return description;
    }

    public Class<? extends DrinkingStrategy> getDrinkingStrategy() {
        return drinkingStrategy;
    }

    public String getStrategyName() {
        return strategyName;
    }
}
