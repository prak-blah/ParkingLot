package com.prak.util;

public class ParkingSpotUtil {

    public static int getRowForParkingSpotNumber(int spotNumber, int numberOfParkingSpotsPerRow) {
        return spotNumber / numberOfParkingSpotsPerRow ;
    }

    public static boolean isFirstSpotInTheRow(int spotNumber, int numberOfParkingSpotsPerRow) {
        return (spotNumber % numberOfParkingSpotsPerRow == 0);
    }
}
