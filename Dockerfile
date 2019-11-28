FROM openjdk:8-jre-alpine

COPY target/kanban-0.0.1-SNAPSHOT.jar /kanban.jar

EXPOSE 7071

CMD java -jar kanban.jar