#docker rm - f dev-postgres
#docker run --name dev-postgres -p 5432:5432 -e POSTGRES_PASSWORD=admin -d postgres:14
#docker exec dev-postgres psql -U postgres -c"CREATE DATABASE family" postgres

#build FamilyApp
# Fetching latest version of Java
FROM openjdk:13-jdk-alpine
# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/family-app.jar /app

# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "family-app.jar"]

