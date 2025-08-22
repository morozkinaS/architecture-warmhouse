package ru.warmhouse.temperature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class TemperatureController {

    private final Random random = new Random();

    @GetMapping("/temperature")
    public Map<String, Object> getTemperature(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String sensorId) {

        // Определяем location по sensorId, если не задан
        if (location == null || location.isEmpty()) {
            location = switch (sensorId) {
                case "1" -> "Living Room";
                case "2" -> "Bedroom";
                case "3" -> "Kitchen";
                default -> "Unknown";
            };
        }

        // Определяем sensorId по location, если не задан
        if (sensorId == null || sensorId.isEmpty()) {
            sensorId = switch (location) {
                case "Living Room" -> "1";
                case "Bedroom" -> "2";
                case "Kitchen" -> "3";
                default -> "0";
            };
        }

        double temperature = random.nextDouble(15.0, 30.0);

        Map<String, Object> response = new HashMap<>();
        response.put("location", location);
        response.put("sensorId", sensorId);
        response.put("temperature", Math.round(temperature * 10.0) / 10.0); // Округляем до 1 знака
        response.put("timestamp", ZonedDateTime.now());

        return response;
    }
}