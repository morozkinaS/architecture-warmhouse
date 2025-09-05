package ru.warmhouse.temperature;

public record SensorResponse(
        String sensorId,
        String location,
        double value,
        String unit,
        String status,
        String timestamp,
        String sensorType
) {}
