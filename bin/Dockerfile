FROM openjdk:11

MAINTAINER Loganathan <Logu@piraiinfo.com>

VOLUME /tmp

EXPOSE 8084

ARG JAR_FILE=target/smenu-1.0.jar

ADD ${JAR_FILE} smenu-1.0.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/smenu-1.0.jar","--spring.config.location=file:/opt/application.yml"]