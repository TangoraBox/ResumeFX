FROM adoptopenjdk:15-hotspot-focal
RUN apt-get update
RUN apt-get -y install xorg gtk2-engines libasound2 libgtk2.0-0
COPY resume-fx-jpro /resume-fx-jpro
WORKDIR /resume-fx-jpro