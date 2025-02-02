# Step 1: Building the application
FROM maven:3.9.5-eclipse-temurin-21 AS builder
WORKDIR /service
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Running the application
FROM eclipse-temurin:21
WORKDIR /service
COPY --from=builder /service/target/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]