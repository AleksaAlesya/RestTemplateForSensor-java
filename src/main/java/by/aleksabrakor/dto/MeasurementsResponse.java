package by.aleksabrakor.dto;

import java.util.List;

public class MeasurementsResponse {
    List<MeasurementDto> measurementDtoList;

    public MeasurementsResponse() {
    }

    public List<MeasurementDto> getMeasurementDtoList() {
        return measurementDtoList;
    }

    public void setMeasurementDtoList(List<MeasurementDto> measurementDtoList) {
        this.measurementDtoList = measurementDtoList;
    }

    @Override
    public String toString() {
        return "{" +
                measurementDtoList +
                '}';
    }
}


