FROM gradle:8.6.0-jdk17

COPY . .

RUN gradle build

EXPOSE 8080

ENTRYPOINT ["java","-jar","build/libs/market-0.0.1-SNAPSHOT.jar"]