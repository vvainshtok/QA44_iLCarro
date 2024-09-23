package utils;

import java.util.Random;

import static java.lang.Math.round;

public class RandomUtils {
    public static void main(String[] args) {

    }

    static Random random = new Random();

    public static String generateEmail(int length) {
        String[] domains = {"mail.com", "gmail.com", "yahoo.com", "example.com"};
        String domain = domains[random.nextInt(domains.length)];
        return (generateString(length) + "@" + domain);
    }

    public static String generateString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] randomString = new char[length];
        int index = 0;
        int charLength = characters.length();
        for (int i = 0; i < length; i++) {
            index = random.nextInt(charLength);
            randomString[i] = characters.charAt(index);
        }
        return new String(randomString);
    }

    public static Integer generateNumber(int max) {
        return (random.nextInt(max));
    }

    public static String[] generateManufacturerAndModel() {

        String[][] cars = {
                {"Toyota", "Camry", "Corolla", "Prius"},
                {"Honda", "Civic", "Accord", "CR-V"},
                {"Ford", "Mustang", "F-150", "Explorer"},
                {"BMW", "X5", "3 Series", "M4"},
                {"Tesla", "Model S", "Model 3", "Model X"},
                {"Chevrolet", "Silverado", "Malibu", "Impala"}
        };
        int manufacturerNumber = random.nextInt(6);
        String[] res = new String[2];
        res[0] = cars[manufacturerNumber][0];
        res[1] = cars[manufacturerNumber][1+ random.nextInt(3)];
        return res;
    }

    public static FuelType generateFuelType() {
        int index = random.nextInt(5);
        System.out.println(index);
        FuelType res = null;
        switch (index) {
            case 0:
                res = FuelType.DIESEL;
                break;
            case 1:
                res = FuelType.PETROL;
                break;
            case 2:
                res = FuelType.HYBRID;
                break;
            case 3:
                res = FuelType.ELECTRIC;
                break;
            case 4:
                res = FuelType.GAS;
                break;
        }
        return res;
    }


}
