FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/mongo-0.0.1-SNAPSHOT.jar mongo.jar
ADD target/mongo-0.0.1-SNAPSHOT.jar mongo.jar
ENTRYPOINT ["java","-jar","/mongo.jar"]
