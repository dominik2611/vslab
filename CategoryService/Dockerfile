FROM openjdk:13

#https://stackoverflow.com/questions/52120845/docker-compose-build-with-maven-that-re-uses-the-maven-repository
# runs maven install within docker container
FROM maven:3.6.2-jdk-13

# image layer
WORKDIR /app
ADD pom.xml /app
RUN mvn verify clean --fail-never

# Image layer: with the application
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8002
ADD ./target/CategoryService-0.0.1-SNAPSHOT.jar /developments/
ENTRYPOINT ["java","-jar","/developments/CategoryService-0.0.1-SNAPSHOT.jar"]



#VOLUME /tmp
#
#EXPOSE 8002
#
#ARG JAR_FILE=target/CategoryService-0.0.1-SNAPSHOT.jar
#
#ADD ${JAR_FILE} CategoryService.jar
#
#ENTRYPOINT ["java","-jar","/CategoryService.jar"]