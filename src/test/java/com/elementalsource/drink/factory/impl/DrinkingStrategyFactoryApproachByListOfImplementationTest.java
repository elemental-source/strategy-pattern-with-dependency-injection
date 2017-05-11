package com.elementalsource.drink.factory.impl;

import com.elementalsource.drink.factory.DrinkingStrategyFactoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrinkingStrategyFactoryApproachByListOfImplementationTest {

    @Autowired
    private DrinkingStrategyFactoryApproachByListOfImplementation factory;

    @Test
    public void shouldCreateStrategy() {
        DrinkingStrategyFactoryTest.getInstance().shouldCreateStrategy(factory);
    }

}
