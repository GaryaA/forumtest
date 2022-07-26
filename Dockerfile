FROM openjdk:11
ARG JAR_FILE=target/forum-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} forumtest.jar
EXPOSE 8080
CMD java -Xmx512m -jar forumtest.jar
