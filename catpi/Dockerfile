FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD catp@123
ENV MYSQL_DATABASE CATAPI_DATABASE
ENV MYSQL_USER CATAPI_USER
ENV MYSQL_PASSWORD AC_CATAPI_USER
ADD 01-CREATE_TABLES.sql /docker-entrypoint-initdb.d
EXPOSE 3306

FROM maven:3.5.2-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY setting.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml -s /usr/src/app/setting.xml clean package -X  -Dmaven.test.skip=true

FROM openjdk:8
COPY --from=build /usr/src/app/target/catpi-1.1.jar /usr/app/catpi-1.1.jar 
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/catpi-1.1.jar"]