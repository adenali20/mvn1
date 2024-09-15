FROM openjdk:17-jdk-alpine
EXPOSE 8081

ADD target/mvn1.jar mvn1.jar
ENTRYPOINT ["java","-jar","/mvn1.jar"]

#FROM maven
#WORKDIR /app
#COPY . .
#
#RUN JAVA_HOME="/usr/lib/jvm/open-jdk"

#RUN mvn install

#EXPOSE 8081

#CMD ["java","-jar","mvn1.0.0.2.jar"]
#LABEL authors="Adesh"
#
#ENTRYPOINT ["top", "-b"]

