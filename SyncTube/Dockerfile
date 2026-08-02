FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN pwd
RUN ls -la
RUN test -f pom.xml && echo "pom.xml found" || echo "pom.xml NOT found"

RUN apt-get update && apt-get install -y maven

RUN mvn -f pom.xml clean package -DskipTests

EXPOSE 8089

CMD ["java","-jar","target/SyncTube-0.0.1-SNAPSHOT.jar"]
