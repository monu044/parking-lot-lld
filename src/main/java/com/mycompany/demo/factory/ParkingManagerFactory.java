package com.mycompany.demo.factory;

import com.google.inject.Inject;
import com.mycompany.demo.manager.ParkingSpotManager;
import com.mycompany.demo.model.vehicle.VehicleType;
import lombok.AllArgsConstructor;

import java.util.Map;
@AllArgsConstructor(onConstructor = @__(@Inject))
public class ParkingManagerFactory {
    private Map<VehicleType, ParkingSpotManager> parkingSpotManagerMap;

    public ParkingSpotManager getManagerByVehicleType(VehicleType vehicleType) {
        return parkingSpotManagerMap.get(vehicleType);
    }
}
