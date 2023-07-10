FROM openjdk:17.0.1-jdk-slim

ENV GROUP_NAME=application \
    USER_NAME=application

RUN groupadd ${GROUP_NAME} && \
    useradd -M -s /bin/sh -g ${GROUP_NAME} ${USER_NAME}

COPY build/libs/authentication-proxy.jar /opt/application/authentication-proxy.jar

ENV CONFIG_FILE = "${CONFIG_FILE}"

USER application

WORKDIR /opt/application

ENTRYPOINT [ "sh", "-c", "java -jar /opt/application/authentication-proxy.jar --spring.config.location=$CONFIG_FILE" ]

