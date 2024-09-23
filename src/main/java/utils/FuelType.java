package utils;

public enum FuelType {

    DIESEL("Diesel"),
    PETROL("Petrol"),
    HYBRID("Hybrid"),
    GAS("Gas"),
    ELECTRIC("Electric");

    private final String text;

    FuelType (String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
