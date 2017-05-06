package com.elementalsource.drink.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeerTypeTest {

    @Test
    public void shouldGiveAleStrategyName() {
        // given
        final BeerType beerType = BeerType.ALE;

        // when
        final String strategyName = beerType.getStrategyName();

        // then
        assertEquals("drinkingStrategyAle",strategyName);
    }

    @Test
    public void shouldGiveLagerStrategyName() {
        // given
        final BeerType beerType = BeerType.LAGER;

        // when
        final String strategyName = beerType.getStrategyName();

        // then
        assertEquals("drinkingStrategyLager",strategyName);
    }

    @Test
    public void shouldGiveWheatBeerStrategyName() {
        // given
        final BeerType beerType = BeerType.WHEAT_BEER;

        // when
        final String strategyName = beerType.getStrategyName();

        // then
        assertEquals("drinkingStrategyWheatBeer",strategyName);
    }

}
