FROM ubuntu:20.04
RUN apt-get update
RUN apt-get upgrade -y
WORKDIR /app
RUN apt-get install -y openjdk-17-jre
RUN apt-get install -y openjdk-17-jdk
RUN apt-get install -y snapd snap
CMD ["snap", "install", "kotlin", "--channel=1.6/stable"]
COPY ./src/main app/src/main
COPY build.gradle.kts app/build.gradle.kts
EXPOSE 8080
EXPOSE 8001

COPY ./build/libs/flux-0.0.1-SNAPSHOT.jar /bin/runner/run.jar
WORKDIR /bin/runner
CMD ["java", "-jar", "run.jar"]