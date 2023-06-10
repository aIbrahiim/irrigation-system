FROM openjdk:11-jdk

WORKDIR /app

COPY target/irrigation-system.jar .

EXPOSE 8080

CMD ["java", "-jar", "irrigation-system.jar"]
