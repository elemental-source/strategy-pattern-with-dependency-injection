package com.elementalsource.drink.strategy;

import com.elementalsource.drink.model.BeerType;

public interface DrinkingStrategy {

    String toTaste();

    BeerType getBeerType();

}
