package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.factory.DrinkingStrategyFactory;
import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

// Magic type solution
@Component
public class DrinkingStrategyFactoryApproachByMagicType implements DrinkingStrategyFactory {

    private final ApplicationContext applicationContext;
    private final Map<BeerType, String> beansName;

    @Autowired
    public DrinkingStrategyFactoryApproachByMagicType(final ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;

        final ImmutableMap.Builder<BeerType, String> builder = ImmutableMap.builder();
        for (final BeerType beerType : BeerType.values()) {
            builder.put(beerType, beerType.getStrategyName());
        }

        this.beansName = builder.build();
    }

    @Override
    public DrinkingStrategy create(final BeerType beerType) {
        checkNotNull(beerType, "beerType cannot be null");
        return applicationContext.getBean(beansName.get(beerType), DrinkingStrategy.class);
    }

}
