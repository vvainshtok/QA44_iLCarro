package data_provider;

import dto.CarDto;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DPAddCar {

    @DataProvider
    public Iterator<CarDto> addNewCarDPFile_EmptyOrWrongFields() {

        List<CarDto> carList = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/test/resources/car_empty_or_wrong_fields.csv"));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitArray = line.split(",");
                carList.add(CarDto.builder()
                        .city(splitArray[0])
                        .manufacture(splitArray[1])
                        .model(splitArray[2])
                        .year(splitArray[3])
                        .fuel(splitArray[4])
                        .seats(Integer.parseInt(splitArray[5]))
                        .carClass(splitArray[6])
                        .serialNumber(splitArray[7])
                        .pricePerDay(Double.parseDouble(splitArray[8]))
                        .about(splitArray[9])
                        .image(splitArray[10])
                        .build());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return carList.listIterator();
    }
}
