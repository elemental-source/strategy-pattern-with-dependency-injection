package com.elementalsource.drink.factory;

import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import com.google.common.collect.ImmutableList;

public class DrinkingStrategyFactoryTest {

    private static final DrinkingStrategyFactoryTest INSTANCE = new DrinkingStrategyFactoryTest();

    private DrinkingStrategyFactoryTest() {
    }

    public static DrinkingStrategyFactoryTest getInstance() {
        return INSTANCE;
    }

    public void shouldCreateStrategy(final DrinkingStrategyFactory factory) {
        // given
        final Iterable<BeerType> beerTypes = ImmutableList.copyOf(BeerType.values());

        // when..then
        beerTypes.forEach(beerType -> shouldCreateStrategy(factory, beerType));
    }

    private void shouldCreateStrategy(final DrinkingStrategyFactory factory, final BeerType beerType) {
        // when
        final DrinkingStrategy drinkingStrategy = factory.create(beerType);

        // then
        drinkingStrategy.toTaste();
    }

}
