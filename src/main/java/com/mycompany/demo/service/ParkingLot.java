package com.mycompany.demo.service;

import com.google.inject.Inject;
import com.mycompany.demo.model.Ticket;
import com.mycompany.demo.model.gate.EntranceGate;
import com.mycompany.demo.model.gate.ExitGate;
import com.mycompany.demo.model.vehicle.Vehicle;
import com.mycompany.demo.strategy.parking.ParkingStrategyType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Inject))
@Getter
@Setter
@Builder
public class ParkingLot {

    private EntranceGate entranceGate;

    private ExitGate exitGate;

    public Ticket createBooking(Vehicle vehicle) {
        return entranceGate.createBooking(vehicle, ParkingStrategyType.getStrategyByType("1"));
    }

    public void unPark(Ticket ticket) {
        exitGate.unParkAndCollectMoney(ticket);
    }

    public Boolean findSlotByVehicle(Vehicle vehicle) {
        Boolean slots = entranceGate.slotAvailable(vehicle);
        if (slots) {
            System.out.println("Slots are present");
        }
        else {
            System.out.println("We are at capacity");
        }
        return slots;
    }
}
