FROM amazoncorretto:17-alpine-jdk
MAINTAINER boladodacopa.tk
COPY teams.jar teams.jar
ENTRYPOINT ["java","-jar","/teams.jar"]