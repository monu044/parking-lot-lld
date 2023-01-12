package com.mycompany.demo.model.gate;

import com.google.inject.Inject;
import com.mycompany.demo.factory.ParkingManagerFactory;
import com.mycompany.demo.factory.ParkingStrategyFactory;
import com.mycompany.demo.manager.ParkingSpotManager;
import com.mycompany.demo.model.Ticket;
import com.mycompany.demo.model.parking.ParkingSpot;
import com.mycompany.demo.model.vehicle.Vehicle;
import com.mycompany.demo.strategy.parking.ParkingStrategy;
import com.mycompany.demo.strategy.parking.ParkingStrategyType;
import lombok.*;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Inject))
@Getter
@Setter
@Builder
@ToString
public class EntranceGate {
    private ParkingManagerFactory managerFactory;
    private ParkingStrategyFactory strategyFactory;

    public Ticket createBooking(Vehicle vehicle, ParkingStrategyType parkingStrategyType) {
        ParkingSpotManager manager = managerFactory.getManagerByVehicleType(vehicle.getVehicleType());
        ParkingStrategy strategy = strategyFactory.getParkingStrategyByType(parkingStrategyType);
        Optional<ParkingSpot> parkingSpot = manager.findParkingSpot(vehicle.getVehicleType(), strategy);
        System.out.println("Found a slot : " + parkingSpot.get().getId());
        manager.park(parkingSpot.get(), vehicle);
        return Ticket.builder()
                .id(1)
                .bookedAt(System.currentTimeMillis())
                .pricingStrategyType(parkingSpot.get().getPricingStrategyType())
                .vehicle(vehicle)
                .spot(parkingSpot.get())
                .build();
    }

    public Boolean slotAvailable(Vehicle vehicle) {
        return managerFactory.getManagerByVehicleType(vehicle.getVehicleType()).getSlotsAvailable();
    }

}
