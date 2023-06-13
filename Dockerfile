FROM adoptopenjdk/maven-openjdk11:latest
WORKDIR /app
ENV PORT=8081
EXPOSE ${PORT}
COPY . .
RUN mvn clean package
ENTRYPOINT java -jar target/*.jar
