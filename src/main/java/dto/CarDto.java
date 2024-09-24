package dto;

import lombok.*;
import utils.FuelType;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDto {

    private String serialNumber;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
//    private FuelType fuel;
    private int seats;
    private String carClass;
    private double pricePerDay;
    private String about;
    private String city; // location

}
