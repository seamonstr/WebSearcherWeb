FROM openjdk:11-jdk
RUN mkdir -p /usr/local/GoogleSearcherWeb
WORKDIR /usr/local/GoogleSearcherWeb

ARG JAR_FILE=foo
ADD target/${JAR_FILE} /usr/local/GoogleSearcherWeb/service.jar

EXPOSE 8080
ADD src/main/docker/run.sh run.sh

RUN chmod +x run.sh
CMD ./run.sh
