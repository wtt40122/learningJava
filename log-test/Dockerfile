FROM openjdk:8-jre
MAINTAINER wangtao29@qq.com
RUN mkdir -p /home/work/log-test/
RUN mkdir -p /home/work/log/log-test/
COPY ./target/log-test-0.0.1-SNAPSHOT.jar /home/work/log-test/log-test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Xms512M","-Xmx512M","-XX:+UseG1GC","-XX:+PrintReferenceGC","-XX:+PrintGCDetails","-XX:+PrintGCDateStamps","-XX:+PrintHeapAtGC","-Xloggc:/home/work/log/log-test/gc.log","/home/work/log-test/log-test-0.0.1-SNAPSHOT.jar"]