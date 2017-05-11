package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.factory.DrinkingStrategyFactory;
import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.function.Function.identity;

// List of implementations
@Component
public class DrinkingStrategyFactoryApproachByListOfImplementation implements DrinkingStrategyFactory {

    private final Map<BeerType, DrinkingStrategy> drinkingStrategies;

    @Autowired
    public DrinkingStrategyFactoryApproachByListOfImplementation(final List<DrinkingStrategy> drinkingStrategyList) {
        this.drinkingStrategies =
                drinkingStrategyList
                        .stream()
                        .collect(Collectors.toMap(DrinkingStrategy::getBeerType, identity()));
    }


    @Override
    public DrinkingStrategy create(final BeerType beerType) {
        checkNotNull(beerType, "beerType cannot be null");

        return drinkingStrategies.get(beerType);
    }

}
