FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8089

CMD ["java","-jar","target/SyncTube-0.0.1-SNAPSHOT.jar"]
