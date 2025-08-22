FROM eclipse-temurin:17-jre-alpine

COPY target/temperature-api-*.jar /app/temperature-api.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/temperature-api.jar"]

ENV SERVER_PORT=8081