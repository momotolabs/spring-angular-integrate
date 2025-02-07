FROM amazoncorretto:21.0.4-alpine3.19

# Set the working directory in the container
WORKDIR /app

COPY . .

# Instala Maven
RUN apk add --no-cache maven

RUN mvn install:install-file -Dfile=ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar
# Construye el proyecto
RUN mvn clean package -DskipTests

# Expose the port that the application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "target/testatracsi-0.0.1.jar"]