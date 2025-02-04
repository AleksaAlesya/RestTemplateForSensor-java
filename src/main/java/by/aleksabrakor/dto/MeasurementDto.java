package by.aleksabrakor.dto;

public class MeasurementDto {
    private Double temperatureValue;
    private Boolean raining;
    private SensorDto sensor;

    public MeasurementDto() {
    }

    public MeasurementDto(Double temperatureValue, Boolean raining, SensorDto sensorDto) {
        this.temperatureValue = temperatureValue;
        this.raining = raining;
        this.sensor = sensorDto;
    }

    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDto getSensor() {
        return sensor;
    }

    public void setSensor(SensorDto sensorDto) {
        this.sensor = sensorDto;
    }

    @Override
    public String toString() {
        return "MeasurementDto{" +
                "temperatureValue=" + temperatureValue +
                ", raining=" + raining +
                ", sensor=" + sensor +
                '}';
    }
}
