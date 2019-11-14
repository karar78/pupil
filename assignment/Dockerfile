FROM openjdk:8
ADD target/docker-pupil.jar docker-pupil.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-pupil.jar"]