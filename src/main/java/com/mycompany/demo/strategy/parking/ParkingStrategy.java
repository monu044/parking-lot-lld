package com.mycompany.demo.strategy.parking;

import com.mycompany.demo.model.parking.ParkingSpot;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ParkingStrategy {

    public Optional<ParkingSpot> findSpot(List<ParkingSpot> parkingSpots) {
        return parkingSpots.stream()
                .filter(ParkingSpot::getEmpty)
                .findAny();
    }
}
