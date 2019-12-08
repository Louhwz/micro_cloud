FROM openjdk:8
MAINTAINER Louhwz
VOLUME /tmp
ADD ./target/micro_case-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 10021