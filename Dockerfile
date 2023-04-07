FROM maven:3.8.1-openjdk-17-slim AS build

RUN mkdir /home/iplstats
copy . /home/iplstats
RUN cd /home/iplstats && mvn package
RUN cp /home/iplstats/target/*.jar ipl-stats.jar

ENTRYPOINT [ "java","-jar","ipl-stats.jar" ]

EXPOSE 8090