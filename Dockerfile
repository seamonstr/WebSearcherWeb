FROM openjdk:11-jdk
RUN mkdir -p /usr/local/WebSearcherWeb
WORKDIR /usr/local/WebSearcherWeb

ARG JAR_FILE=foo
ADD target/${JAR_FILE} /usr/local/WebSearcherWeb/service.jar

EXPOSE 8080
ADD src/main/docker/run.sh run.sh

RUN chmod +x run.sh
CMD ./run.sh
