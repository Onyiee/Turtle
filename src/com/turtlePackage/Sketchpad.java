package com.turtlePackage;

public class Sketchpad {
    private int[][] floor;

    public Sketchpad(int numberOfRows, int numberOfColumns){
        floor = new int[numberOfRows][numberOfColumns];
    }

    public int[][] getFloor() {
        return floor;
    }
}
