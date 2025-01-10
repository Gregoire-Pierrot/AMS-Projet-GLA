FROM maven:3.9-eclipse-temurin-17
WORKDIR /app
COPY ./console-app/ /app
CMD ["mvn", "clean", "compile", "exec:java"]