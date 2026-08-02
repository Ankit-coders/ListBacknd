FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN apt-get update && apt-get install -y maven

RUN mvn clean package -DskipTests

EXPOSE 8089

ENTRYPOINT ["java","-jar","target/SyncTube-0.0.1-SNAPSHOT.jar"]
