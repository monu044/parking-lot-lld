package com.mycompany.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.demo.model.vehicle.Vehicle;
import com.mycompany.demo.model.vehicle.VehicleType;
import com.mycompany.demo.module.ParkingLotModule;
import com.mycompany.demo.service.ParkingLot;

public class Driver {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ParkingLotModule());
        ParkingLot parkingLot = injector.getInstance(ParkingLot.class);
        for (int i = 0; i < 20; ++i) {
            Vehicle vehicle = Vehicle.builder()
                    .id(i)
                    .vehicleType(VehicleType.FOUR_WHEELER)
                    .build();
            if (parkingLot.findSlotByVehicle(vehicle)) {
                parkingLot.createBooking(vehicle);
            }
        }
    }
}
