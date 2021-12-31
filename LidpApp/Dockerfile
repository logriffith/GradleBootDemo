FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} lidp.jar
ENTRYPOINT ["java", "-jar", "/lidp.jar"]