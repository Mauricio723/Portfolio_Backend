FROM amazoncorretto:8-alpine-jdk
MAINTAINER mauricio72
COPY target/BackPortfolio-0.0.1-SNAPSHOT.jar BackPortfolio01.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/BackPortfolio01.jar"]
       

