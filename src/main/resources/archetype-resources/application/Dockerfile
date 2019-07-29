FROM harbor.dfocus.co/base/openjdk:8u131

MAINTAINER baozi

ARG JAR_FILE
ADD ./target/$JAR_FILE app.jar

VOLUME /tmp

ENTRYPOINT java ${JAVA_OPTS} -jar  app.jar