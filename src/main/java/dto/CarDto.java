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

    private String manufacturer;
    private String model;
    private Integer year;
    private FuelType fuel;
    private Integer seats;
    private String carClass;
    private String carRegistrationNumber;
    private Integer price;
    private String about;
}
