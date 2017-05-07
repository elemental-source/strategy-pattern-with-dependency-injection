# Strategy (and Factory) pattern with dependency injection

Lot of options for how to implement Strategy Pattern with dependency injection using Spring.

### Problem

Given an enum, we need follow a determined flux in application and to return always the same object type.

We would like of a dynamic and uncoupled solution (obviously). 

The exciting part of the history is that [each strategy is a Bean](https://github.com/elemental-source/strategy-pattern-with-dependency-injection/tree/master/src/main/java/com/elementalsource/drink/strategy/impl) (the project uses Spring).

### Solution

We think about use Strategy Design Pattern.

For this reason, we have built several strategies with the objective can choose dynamicly the Bean.

[See the options.](https://github.com/elemental-source/strategy-pattern-with-dependency-injection/tree/master/src/main/java/com/elementalsource/drink/factory/impl)

Which is the best implementation? Some suggestion?

:metal:
