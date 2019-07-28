#FROM harbor.dfocus.co/library/java:1.8
FROM java
MAINTAINER baozi

ARG JAR_FILE
ADD ./target/$JAR_FILE app.jar

VOLUME /tmp

ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]