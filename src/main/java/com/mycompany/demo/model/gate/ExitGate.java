package com.mycompany.demo.model.gate;

import com.google.inject.Inject;
import com.mycompany.demo.factory.ParkingManagerFactory;
import com.mycompany.demo.factory.PricingStrategyFactory;
import com.mycompany.demo.manager.ParkingSpotManager;
import com.mycompany.demo.model.Ticket;
import com.mycompany.demo.strategy.pricing.PricingStrategy;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Inject))
@Getter
@Setter
@ToString
public class ExitGate {

    private ParkingManagerFactory managerFactory;
    private PricingStrategyFactory pricingStrategyFactory;

    public void unParkAndCollectMoney(Ticket ticket) {
        ParkingSpotManager manager = managerFactory.getManagerByVehicleType(ticket.getVehicle().getVehicleType());
        PricingStrategy strategy = pricingStrategyFactory.getPricingStrategyByType(ticket.getPricingStrategyType());
        manager.unPark(ticket.getSpot());
        strategy.calculate(ticket);
        System.out.println();
    }
}
