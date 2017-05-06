package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.model.BeerType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StrategyNameResolverTest {

    @InjectMocks
    private StrategyNameResolver strategyNameResolver;

    @Test
    public void shouldConvertTypeToBeanNameAle() {
        // given
        final BeerType beerType = BeerType.ALE;

        // when
        final String result = strategyNameResolver.getBeanNameBy(beerType);

        // then
        assertEquals("drinkingStrategyAle", result);
    }

    @Test
    public void shouldConvertTypeToBeanNameWheatBeer() {
        // given
        final BeerType beerType = BeerType.WHEAT_BEER;

        // when
        final String result = strategyNameResolver.getBeanNameBy(beerType);

        // then
        assertEquals("drinkingStrategyWheatBeer", result);
    }

}
