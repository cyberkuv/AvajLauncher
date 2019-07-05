#!/usr/bin/env bash
find . -name "*.java" > sources.txt
javac ./src/za.WeThinkCode.avaj/Tower.java \
      ./src/za.WeThinkCode.avaj/WeatherTower.java \
      ./src/za.WeThinkCode.avaj/Flyable.java \
      ./src/za.WeThinkCode.avaj/Coordinates.java \
      ./src/za.WeThinkCode.avaj/WeatherProvider.java \
      ./src/za.WeThinkCode.avaj/Aircraft.java \
      ./src/za.WeThinkCode.avaj/FileWrite.java \
      ./src/za.WeThinkCode.avaj/Balloon.java \
      ./src/za.WeThinkCode.avaj/Helicopter.java \
      ./src/za.WeThinkCode.avaj/JetPlane.java \
      ./src/za.WeThinkCode.avaj/AircraftFactory.java \
      ./src/za.WeThinkCode.avaj/Simulator.java