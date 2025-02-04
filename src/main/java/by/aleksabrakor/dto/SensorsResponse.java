package by.aleksabrakor.dto;

import java.util.List;

public class SensorsResponse {
    List<SensorDto> sensorDtoList;

    public SensorsResponse() {
    }

    public List<SensorDto> getSensorDtoList() {
        return sensorDtoList;
    }

    public void setSensorDtoList(List<SensorDto> sensorDtoList) {
        this.sensorDtoList = sensorDtoList;
    }

    @Override
    public String toString() {
        return "{" +
                 sensorDtoList +
                '}';
    }
}


