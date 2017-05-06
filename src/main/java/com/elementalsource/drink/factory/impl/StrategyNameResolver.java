package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.model.BeerType;
import com.elementalsource.drink.strategy.DrinkingStrategy;
import com.google.common.base.CaseFormat;
import org.springframework.stereotype.Component;

@Component
class StrategyNameResolver {

    String getBeanNameBy(final BeerType beerType) {
        final String camelCaseClassName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, DrinkingStrategy.class.getSimpleName());

        return camelCaseClassName + beerType.getDescription();
    }

}
