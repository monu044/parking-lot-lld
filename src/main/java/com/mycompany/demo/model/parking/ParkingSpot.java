package com.mycompany.demo.model.parking;

import com.mycompany.demo.model.vehicle.Vehicle;
import com.mycompany.demo.strategy.pricing.PricingStrategyType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ParkingSpot {
    private Integer id;
    private Boolean empty;
    private Vehicle vehicle;
    private PricingStrategyType pricingStrategyType;
}
