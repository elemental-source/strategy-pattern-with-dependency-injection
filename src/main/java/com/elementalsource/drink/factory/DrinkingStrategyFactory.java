package com.elementalsource.drink.factory;

import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;

public interface DrinkingStrategyFactory {

    DrinkingStrategy create(final BeerType beerType);

}
