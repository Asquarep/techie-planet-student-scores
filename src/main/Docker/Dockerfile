FROM openjdk:17-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} students-scores-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "students-scores-0.0.1-SNAPSHOT.jar"]