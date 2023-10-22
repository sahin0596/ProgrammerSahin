FROM alpine:3.11.2
COPY build/libs/Organization-0.0.1-SNAPSHOT.jar /app/Organization.jar
CMD ["java", "-jar", "/app/Organization.jar"]