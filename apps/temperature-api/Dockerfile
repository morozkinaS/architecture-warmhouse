# Stage 1: Сборка проекта с помощью Maven
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Копируем pom.xml и исходники
COPY pom.xml .
COPY src ./src

# Собираем JAR (пропускаем тесты для скорости)
RUN mvn clean package -DskipTests


# Stage 2: Запуск приложения
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Копируем JAR из первого этапа
COPY --from=builder /app/target/temperature-api-*.jar /app/temperature-api.jar

EXPOSE 8081

ENV SERVER_PORT=8081

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app/temperature-api.jar"]
