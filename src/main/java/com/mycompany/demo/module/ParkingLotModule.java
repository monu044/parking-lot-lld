package com.mycompany.demo.module;

import com.google.common.collect.ImmutableMap;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mycompany.demo.manager.ParkingSpotManager;
import com.mycompany.demo.model.parking.ParkingSpot;
import com.mycompany.demo.model.vehicle.VehicleType;
import com.mycompany.demo.strategy.parking.ParkingStrategy;
import com.mycompany.demo.strategy.parking.ParkingStrategyType;
import com.mycompany.demo.strategy.pricing.PricingStrategy;
import com.mycompany.demo.strategy.pricing.PricingStrategyType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingLotModule extends AbstractModule {

    @Provides
    @Singleton
    private Map<VehicleType, ParkingSpotManager> getParkingManagerMap(ParkingSpotManager parkingSpotManager) {
        return new ImmutableMap.Builder<VehicleType, ParkingSpotManager>()
                .put(VehicleType.TWO_WHEELER, parkingSpotManager)
                .put(VehicleType.FOUR_WHEELER, parkingSpotManager)
                .build();
    }

    @Provides
    @Singleton
    private Map<ParkingStrategyType, ParkingStrategy> getParkingStratagyMap(ParkingStrategy parkingStrategy) {
        return new ImmutableMap.Builder<ParkingStrategyType, ParkingStrategy>()
                .put(ParkingStrategyType.DEFAULT, parkingStrategy)
                .put(ParkingStrategyType.ADVANCED, parkingStrategy)
                .build();
    }

    @Provides
    @Singleton
    private Map<PricingStrategyType, PricingStrategy> getPricingtratagyMap(PricingStrategy pricingStrategy) {
        return new ImmutableMap.Builder<PricingStrategyType, PricingStrategy>()
                .put(PricingStrategyType.FIXED, pricingStrategy)
                .put(PricingStrategyType.MINUTES, pricingStrategy)
                .put(PricingStrategyType.HOURLY, pricingStrategy)
                .build();
    }
    
    @Provides
    private Boolean getSlots() {
        return Boolean.TRUE;
    }

    @Provides
    @Singleton
    private List<ParkingSpot> getParkingSpots() {
        return IntStream.range(1, 10)
                .mapToObj(i -> ParkingSpot.builder()
                        .id(i)
                        .empty(true)
                        .pricingStrategyType(PricingStrategyType.FIXED)
                        .vehicle(null)
                        .build())
                .collect(Collectors.toList());
    }
}
