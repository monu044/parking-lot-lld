package com.mycompany.demo.model.vehicle;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Vehicle {
    private Integer id;
    private VehicleType vehicleType;
}
