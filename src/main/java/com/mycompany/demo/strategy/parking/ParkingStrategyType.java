package com.mycompany.demo.strategy.parking;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ParkingStrategyType {
    DEFAULT("1"),
    ADVANCED("2");

    String value;

    public static Map<String, ParkingStrategyType> strategyTypeMap;

    ParkingStrategyType(String value){
        this.value = value;
    }

    public static ParkingStrategyType getStrategyByType(String type) {
        if (null == strategyTypeMap) {
            initialise();
        }
        return strategyTypeMap.get(type);
    }

    private static void initialise() {
        strategyTypeMap = Collections.unmodifiableMap(Arrays.stream(ParkingStrategyType.values())
                .collect(Collectors.toMap(parkingStrategyType -> (parkingStrategyType.value), Function.identity())));
    }
}
