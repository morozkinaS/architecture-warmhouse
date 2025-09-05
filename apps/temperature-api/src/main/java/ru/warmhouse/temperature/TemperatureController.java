package ru.warmhouse.temperature;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
public class TemperatureController {

    private final Random random = new Random();

    @GetMapping("/temperature")
    public SensorResponse getTemperature(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String sensorId) {

        // Логика определения location и sensorId
        if (location == null || location.isEmpty()) {
            location = switch (sensorId) {
                case "1" -> "Living Room";
                case "2" -> "Bedroom";
                case "3" -> "Kitchen";
                default -> "Unknown";
            };
        }

        if (sensorId == null || sensorId.isEmpty()) {
            sensorId = switch (location) {
                case "Living Room" -> "1";
                case "Bedroom" -> "2";
                case "Kitchen" -> "3";
                default -> "0";
            };
        }

        double temperature = random.nextDouble(15.0, 30.0);
        double formattedTemp = Math.round(temperature * 10.0) / 10.0;

        SensorResponse response = new SensorResponse(
                sensorId,          // camelCase
                location,
                formattedTemp,
                "°C",
                "active",
                Instant.now().toString(),
                "temperature"      // camelCase
        );

        log.info("Response to call by location: {}", response);
        return response;
    }

    @GetMapping("/temperature/{sensorId}")
    public SensorResponse getTemperatureBySensorId(@PathVariable String sensorId) {

        double temperature = random.nextDouble(15.0, 30.0);
        double formattedTemp = Math.round(temperature * 10.0) / 10.0;

        String location = switch (sensorId) {
            case "1" -> "Living Room";
            case "2" -> "Bedroom";
            case "3" -> "Kitchen";
            default -> "sensor_" + sensorId;
        };

        SensorResponse response = new SensorResponse(
                sensorId,          // camelCase
                location,
                formattedTemp,
                "°C",
                "active",
                Instant.now().toString(),
                "temperature"      // camelCase
        );

        log.info("Response to call by sensorId: {}", response);
        return response;
    }
}