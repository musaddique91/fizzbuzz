FROM openjdk:11

#setup user
RUN addgroup -S fizzbuzz && adduser -S fizzbuzz -G fizzbuzz
USER fizzbuzz:fizzbuzz

#setup entry
ARG JAR_FILE=build/libs/fizzbuzz-0.0.1-SNAPSHOT.jar
RUN echo $JAR_FILE
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]