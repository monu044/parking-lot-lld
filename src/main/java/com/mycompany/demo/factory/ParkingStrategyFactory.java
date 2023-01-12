package com.mycompany.demo.factory;

import com.google.inject.Inject;
import com.mycompany.demo.strategy.parking.ParkingStrategy;
import com.mycompany.demo.strategy.parking.ParkingStrategyType;
import lombok.AllArgsConstructor;

import java.util.Map;
@AllArgsConstructor(onConstructor = @__(@Inject))
public class ParkingStrategyFactory {

    private Map<ParkingStrategyType, ParkingStrategy> parkingStrategyMap;

    public ParkingStrategy getParkingStrategyByType(ParkingStrategyType parkingStrategyType) {
        return parkingStrategyMap.get(parkingStrategyType);
    }
}
