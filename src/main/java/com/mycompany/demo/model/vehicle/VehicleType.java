package com.mycompany.demo.model.vehicle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum VehicleType {
    TWO_WHEELER("TWO_WHEELER"),
    FOUR_WHEELER("FOUR_WHEELER");

    String value;

    VehicleType(String type) {
        this.value = type;
    }

    private static Map<String, VehicleType> vehicleTypeMap;

    public static VehicleType getVehicleByType(String type) {
        if (null == vehicleTypeMap) {
            initialise();
        }
        return vehicleTypeMap.get(type);
    }

    private static void initialise() {
        vehicleTypeMap = Collections.unmodifiableMap(Arrays.stream(VehicleType.values())
                .collect(Collectors.toMap(vehicleType -> (vehicleType.value), Function.identity())));
    }
}
