package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.factory.DrinkingStrategyFactory;
import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

// Class solution
@Component
public class DrinkingStrategyFactoryApproachByClass implements DrinkingStrategyFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public DrinkingStrategyFactoryApproachByClass(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public DrinkingStrategy create(final BeerType beerType) {
        checkNotNull(beerType, "beerType cannot be null");
        return applicationContext.getBean(beerType.getDrinkingStrategy());
    }

}
