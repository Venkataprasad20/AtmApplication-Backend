# ================================
# Stage 1: Build AtmApplication
# ================================
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml first (better Docker caching)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build Spring Boot JAR
RUN mvn clean package -DskipTests


# ================================
# Stage 2: Run AtmApplication
# ================================
FROM eclipse-temurin:17-jre

# Working directory for runtime
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar AtmApplication.jar

# Expose application port
EXPOSE 8080

# Run the Spring Boot ATM application
ENTRYPOINT ["java", "-jar", "AtmApplication.jar"]
