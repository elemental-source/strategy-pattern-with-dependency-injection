package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.StrategyNotFound;
import com.elementalsource.drink.factory.DrinkingStrategyFactory;
import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyAle;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyLager;
import com.elementalsource.drink.strategy.impl.DrinkingStrategyWheatBeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

// Horrible solution :(
@Component
public class DrinkingStrategyFactoryApproachSwitch implements DrinkingStrategyFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkingStrategyFactoryApproachSwitch.class);

    private final DrinkingStrategyAle ale;
    private final DrinkingStrategyLager lager;
    private final DrinkingStrategyWheatBeer wheatBeer;

    @Autowired
    public DrinkingStrategyFactoryApproachSwitch(DrinkingStrategyAle ale, DrinkingStrategyLager lager, DrinkingStrategyWheatBeer wheatBeer) {
        this.ale = ale;
        this.lager = lager;
        this.wheatBeer = wheatBeer;
    }

    @Override
    public DrinkingStrategy create(final BeerType beerType) {
        checkNotNull(beerType, "beerType cannot be null");

        switch (beerType) {
            case ALE:
                return ale;
            case LAGER:
                return lager;
            case WHEAT_BEER:
                return wheatBeer;
            default:
                LOGGER.error("Beer type {} cannot be recognized like a strategy", beerType.name());
                throw new StrategyNotFound("Strategy not recognized");
        }
    }
}
