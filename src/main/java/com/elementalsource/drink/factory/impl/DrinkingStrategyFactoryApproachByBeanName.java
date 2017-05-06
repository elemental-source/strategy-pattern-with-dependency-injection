package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.factory.DrinkingStrategyFactory;
import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

// Bean name solution
@Component
public class DrinkingStrategyFactoryApproachByBeanName implements DrinkingStrategyFactory {

    private final ApplicationContext applicationContext;
    private final StrategyNameResolver strategyNameResolver;

    @Autowired
    public DrinkingStrategyFactoryApproachByBeanName(ApplicationContext applicationContext, StrategyNameResolver strategyNameResolver) {
        this.applicationContext = applicationContext;
        this.strategyNameResolver = strategyNameResolver;
    }

    @Override
    public DrinkingStrategy create(final BeerType beerType) {
        checkNotNull(beerType, "beerType cannot be null");
        return applicationContext.getBean(strategyNameResolver.getBeanNameBy(beerType), DrinkingStrategy.class);
    }

}
