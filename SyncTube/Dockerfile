FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8089

ENTRYPOINT ["java","-jar","target/SyncTube-0.0.1-SNAPSHOT.jar"]
