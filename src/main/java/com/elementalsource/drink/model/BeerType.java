package com.elementalsource.drink.model;

import com.elementalsource.drink.strategy.DrinkingStrategy;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyAle;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyLager;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyWheatBeer;
import com.google.common.base.CaseFormat;

public enum BeerType {

    ALE("Ale", DrinkingStrategyAle.class),

    LAGER("Lager", DrinkingStrategyLager.class) {
        // you can change default resolution of name to a specific enum
        @Override
        protected String resolveName() {
            return "drinkingStrategyLager";
        }
    },

    WHEAT_BEER("WheatBeer", DrinkingStrategyWheatBeer.class);

    private static final String BASE_NAME = "drinkingStrategy";

    private final String description;
    private final Class<? extends DrinkingStrategy> drinkingStrategy;
    private final String strategyName;

    BeerType(String description, Class<? extends DrinkingStrategy> drinkingStrategy) {
        this.description = description;
        this.drinkingStrategy = drinkingStrategy;
        this.strategyName = resolveName();
    }

    protected String resolveName() {
        return BASE_NAME.concat(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name()));
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
