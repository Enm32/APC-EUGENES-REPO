FROM  maven:3.9.9-eclipse-temurin-21-alpine
COPY  **/target/progress_checker-0.0.1-SNAPSHOT.jar eugeneapp.jar
ENTRYPOINT ["java","-jar","/eugeneapp.jar"]
EXPOSE 8080
