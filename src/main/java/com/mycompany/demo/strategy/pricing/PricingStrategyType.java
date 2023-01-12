package com.mycompany.demo.strategy.pricing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum PricingStrategyType {
    FIXED("0"),
    HOURLY("1"),
    MINUTES("2");

    String value;

    public static Map<String, PricingStrategyType> strategyTypeMap;

    PricingStrategyType(String value){
        this.value = value;
    }

    public static PricingStrategyType getStrategyByType(String type) {
        if (null == strategyTypeMap) {
            initialise();
        }
        return strategyTypeMap.get(type);
    }

    private static void initialise() {
        strategyTypeMap = Collections.unmodifiableMap(Arrays.stream(PricingStrategyType.values())
                .collect(Collectors.toMap(pricingStrategyType -> (pricingStrategyType.value), Function.identity())));
    }
}
