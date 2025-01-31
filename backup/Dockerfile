
FROM  maven:3.9.9-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests



FROM  maven:3.9.9-eclipse-temurin-21-alpine
COPY --FROM=build /target/*.jar eugeneapp.jar
ENTRYPOINT ["java","-jar","/eugeneapp.jar"]
EXPOSE 8080

