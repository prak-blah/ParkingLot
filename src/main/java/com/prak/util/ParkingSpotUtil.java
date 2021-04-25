package com.prak.util;

public class ParkingSpotUtil {

    public static boolean isFirstSpotInTheRow(int spotNumber, int numberOfParkingSpotsPerRow) {
        return (spotNumber % numberOfParkingSpotsPerRow == 0);
    }
}
