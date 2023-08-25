FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/ExcelStatus-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java","-jar","app.war"]

EXPOSE 2222
