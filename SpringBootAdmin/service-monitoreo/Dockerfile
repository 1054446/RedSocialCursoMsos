FROM 'openjdk:8u151-jre-slim'
MAINTAINER srcu
USER root

# Set TimeZone
ENV TZ=America/Mexico_City


# Copies everything over to Docker environment
ARG JAR_FILE=target/monitoreo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} //
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Uses port which is used by the actual application
EXPOSE 8090

# Set ENTRYPOINT
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=devlocal", "monitoreo-0.0.1-SNAPSHOT.jar", "--server.port=8090"]
