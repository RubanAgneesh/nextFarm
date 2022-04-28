FROM openjdk:11

MAINTAINER Loganathan <Logu@piraiinfo.com>

VOLUME /tmp

EXPOSE 8084

ARG JAR_FILE=target/documends-0.0.1.jar

ADD ${JAR_FILE} documends-0.0.1.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/documends-0.0.1.jar","--spring.config.location=file:/opt/application.yml"]