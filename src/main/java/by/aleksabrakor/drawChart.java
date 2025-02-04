package by.aleksabrakor;

import by.aleksabrakor.dto.MeasurementDto;
import by.aleksabrakor.dto.MeasurementsResponse;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class drawChart {
    public static void main(String[] args) {

        drawChart(getMeasurementsValue());

    }

    private static List<Double> getMeasurementsValue() {
        final RestTemplate restTemplate = new RestTemplate();
        final String urlGetMeasurement = "http://localhost:8080/measurements";

        MeasurementsResponse jsonResponse = restTemplate.getForObject(urlGetMeasurement, MeasurementsResponse.class);
        System.out.println(jsonResponse.getMeasurementDtoList().size());

        if (jsonResponse.getMeasurementDtoList() == null) {
            return Collections.emptyList();
        }

        System.out.println("Показания температуры: ");
        return jsonResponse
                .getMeasurementDtoList().stream()
                .map(MeasurementDto::getTemperatureValue)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static void drawChart(List<Double> temperatures) {
        double[] xDate = IntStream.range(0, temperatures.size()).asDoubleStream().toArray();
        double[] yDate = temperatures.stream().mapToDouble(x -> x).toArray();

        XYChart chart = QuickChart.getChart("Temperatures", "X", "Y", "temperature", xDate, yDate);
        new SwingWrapper<>(chart).displayChart();
    }

}
