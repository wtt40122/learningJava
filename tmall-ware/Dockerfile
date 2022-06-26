FROM maven

WORKDIR /app

COPY pom.xml .

COPY src .

RUN mvn clean package -Dmaven.test.skip=true

RUN pwd && ls -l

RUN cp /app/target/*.jar /app/app.jar
RUN ls -l

ENTRYPOINT ["executable"]


