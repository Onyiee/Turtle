package com.turtlePackage;

public class Sketchpad {
    private char[][] floor;

    public Sketchpad(int numberOfRows, int numberOfColumns) {
        floor = new char[numberOfRows][numberOfColumns];
    }

    public char[][] getFloor() {
        return floor;
    }

    public void displayFloor() {
        prepareFloor();
        for (int row = 0; row < floor.length; row++) {
            for (int column = 0; column < floor[row].length; column++) {
                System.out.print(floor[row][column] + " ");
            }
            System.out.println();
        }
    }

    private void prepareFloor() {
        for (int row = 0; row < floor.length; row++) {
            for (int column = 0; column < floor[row].length; column++) {
                if (floor[row][column] == 1) {
                    floor[row][column] = '*';
                } else {
                    floor[row][column] = ' ';
                }
            }
        }
    }
}
