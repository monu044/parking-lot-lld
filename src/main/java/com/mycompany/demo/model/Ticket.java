package com.mycompany.demo.model;

import com.mycompany.demo.model.parking.ParkingSpot;
import com.mycompany.demo.model.vehicle.Vehicle;
import com.mycompany.demo.strategy.pricing.PricingStrategyType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Ticket {
    private Integer id;
    private ParkingSpot spot;
    private Long bookedAt;
    private Vehicle vehicle;
    private PricingStrategyType pricingStrategyType;
}
