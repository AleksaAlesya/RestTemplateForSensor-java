package by.aleksabrakor;

import by.aleksabrakor.dto.MeasurementDto;
import by.aleksabrakor.dto.MeasurementsResponse;
import by.aleksabrakor.dto.SensorDto;
import by.aleksabrakor.dto.SensorsResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.random.RandomGenerator;

public class Client {
    public static void main(String[] args) {
        SensorDto sensorDto = new SensorDto("Www1sensor12");

        registrationNewSensor(sensorDto);

        for (int i = 0; i < 50; i++) {
            measurementAdd(
                    Double.valueOf(String.format("%8.2f", RandomGenerator.getDefault().nextDouble(-20.00, 30.00)).replace(',', '.')),
                    RandomGenerator.getDefault().nextBoolean(),
                    sensorDto);
        }

        getRainyDaysCount();

        getMeasurements();

        getSensors();

    }

    private static void registrationNewSensor(SensorDto sensorDto) {
        final String urlSensorRegistration = "http://localhost:8080/sensors/registration";

        makePostRequest(urlSensorRegistration, sensorDto);
    }

    private static void measurementAdd(Double valueDefault, Boolean booleanDefault, SensorDto sensorDto) {
        final String urlMeasurementAdd = "http://localhost:8080/measurements/add";
        MeasurementDto measurement = new MeasurementDto(valueDefault, booleanDefault, sensorDto);

        makePostRequest(urlMeasurementAdd, measurement);

    }

    private static void getRainyDaysCount() {
        final String urlRainyDaysCount = "http://localhost:8080/measurements/rainyDaysCount";

        final RestTemplate restTemplate = new RestTemplate();

        Long jsonResponse = restTemplate.getForObject(urlRainyDaysCount, Long.class);
        System.out.print("Количество дождливых показаний: ");
        System.out.println(jsonResponse);
    }

    private static void getMeasurements() {
        final String urlGetMeasurement = "http://localhost:8080/measurements";

        final RestTemplate restTemplate = new RestTemplate();

        MeasurementsResponse jsonResponse = restTemplate.getForObject(urlGetMeasurement, MeasurementsResponse.class);

        System.out.println("Получены показания сенсоров: ");
        System.out.println(jsonResponse);
    }

    private static void getSensors() {
        final String urlGetSensor = "http://localhost:8080/sensors";

        final RestTemplate restTemplate = new RestTemplate();

        SensorsResponse jsonResponse = restTemplate.getForObject(urlGetSensor, SensorsResponse.class);

        System.out.println("Получен список сенсоров: ");
        System.out.println(jsonResponse);
    }

    private static void makePostRequest(String url, Object object) {
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(object, headers);

        try {
            String result = restTemplate.postForObject(url, request, String.class);
            System.out.println(result + " Успешно отправлено на сервер");
        } catch (HttpClientErrorException e) {
            System.out.println("Ошибка!");
            System.out.println(e.getMessage());
        }
    }

    // метод для получения данных, Object меняем на нужный более конкретный класс, для преобразования json в объект
    private static void makeGetRequest(String url) {
        final RestTemplate restTemplate = new RestTemplate();

        Object result = restTemplate.getForObject(url, Object.class);
        System.out.println(result);
    }
}
