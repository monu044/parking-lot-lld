package com.mycompany.demo.manager;

import com.google.inject.Inject;
import com.mycompany.demo.model.parking.ParkingSpot;
import com.mycompany.demo.model.vehicle.Vehicle;
import com.mycompany.demo.model.vehicle.VehicleType;
import com.mycompany.demo.strategy.parking.ParkingStrategy;
import lombok.*;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Inject))
@Getter
@Setter
@Builder
public class ParkingSpotManager {

    private List<ParkingSpot> parkingSpots;

    private Boolean slotsAvailable;

    public Optional<ParkingSpot> findParkingSpot(VehicleType vehicleType, ParkingStrategy parkingStrategy) {
        return parkingStrategy.findSpot(parkingSpots);
    }

    public void park(ParkingSpot spot, Vehicle vehicle) {
        parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.getId().equals(spot.getId()))
                .forEach(parkingSpot -> {
                    parkingSpot.setEmpty(false);
                    parkingSpot.setVehicle(vehicle);
                });
        slotsAvailable = parkingSpots.stream()
                .anyMatch(parkingSpot -> parkingSpot.getEmpty().equals(Boolean.TRUE));
    }

    public void unPark(ParkingSpot spot) {
        parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.getId().equals(spot.getId()))
                .forEach(parkingSpot -> {
                    parkingSpot.setEmpty(true);
                    parkingSpot.setVehicle(null);
                });
        slotsAvailable = true;
    }
}
