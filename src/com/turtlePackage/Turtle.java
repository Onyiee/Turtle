package com.turtlePackage;

public class Turtle {

    private Pen pen;
    private CurrentDirection currentDirection;
    private Position currentPosition;

    public Turtle(Pen pen) {
        this.pen = pen;
        this.currentDirection = CurrentDirection.EAST;
        currentPosition = new Position(0, 0);
    }

    public Pen getPen() {
        return pen;
    }

    public CurrentDirection getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(CurrentDirection currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void turnRight() {
        switch (currentDirection) {
            case EAST:
                setCurrentDirection(CurrentDirection.SOUTH);
                break;
            case WEST:
                setCurrentDirection(CurrentDirection.NORTH);
                break;
            case NORTH:
                setCurrentDirection(CurrentDirection.EAST);
                break;
            case SOUTH:
                setCurrentDirection(CurrentDirection.WEST);
                break;
        }
    }

    public void turnLeft() {
        switch (currentDirection) {
            case EAST:
                setCurrentDirection(CurrentDirection.NORTH);
                break;
            case WEST:
                setCurrentDirection(CurrentDirection.SOUTH);
                break;
            case NORTH:
                setCurrentDirection(CurrentDirection.WEST);
                break;
            case SOUTH:
                setCurrentDirection(CurrentDirection.EAST);
                break;
        }
    }

    public void move(Sketchpad sketchpad, int numberOfMoves) {
        numberOfMoves -= 1;
        Position currentPosition = getCurrentPosition();
        int currentColumn = currentPosition.getColumnPosition();
        int currentRow = currentPosition.getRowPosition();
        switch (getPen().getPenOrientation()) {
            case PEN_UP: {
                moveWithPenUp(numberOfMoves);
                break;
            }
            case PEN_DOWN: {
                int[][] floor = sketchpad.getFloor();
                switch (currentDirection){
                    case EAST: {
                        int positionAfterLoop = numberOfMoves + currentColumn;
                        for (int column = currentColumn; column <= positionAfterLoop; column++){
                            floor[currentRow][column] = 1;
                        }
                        currentPosition.setColumnPosition(positionAfterLoop);
                        break;
                    }
                    case WEST:{
                        int positionAfterLoop = currentColumn - numberOfMoves;
                        for (int column = currentColumn; column >= positionAfterLoop; column--){
                            floor[currentRow][column] = 1;
                        }
                        currentPosition.setColumnPosition(positionAfterLoop);
                        break;
                    }
                    case SOUTH:{
                        int positionAfterLoop = numberOfMoves + currentColumn;
                        for (int row = currentRow; row <= positionAfterLoop; row++){
                            floor[row][currentColumn] = 1;
                        }
                        currentPosition.setRowPosition(positionAfterLoop);
                        break;
                    }
                    case NORTH:{
                        int positionAfterLoop = currentRow - numberOfMoves;
                        for (int row = currentRow; row >= positionAfterLoop; row--){
                            floor[row][currentColumn] = 1;
                        }
                        currentPosition.setRowPosition(positionAfterLoop);
                        break;
                    }
                }

            }
        }

    }



    public void setCurrentPosition(Position position) {
        currentPosition = position;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    private void moveWithPenUp(int numberOfMoves) {
        Position currentPosition = getCurrentPosition();
        int currentColumn = currentPosition.getColumnPosition();
        int currentRow = currentPosition.getRowPosition();

        switch (currentDirection) {
            case EAST: {
                currentPosition.setColumnPosition
                        (currentColumn + numberOfMoves);
                break;
            }
            case SOUTH: {
                currentPosition.setRowPosition
                        (currentRow + numberOfMoves);
                break;
            }
            case NORTH: {
                currentPosition.setRowPosition
                        (currentRow - numberOfMoves);
                break;
            }
            case WEST: {
                currentPosition.setColumnPosition
                        (currentColumn - numberOfMoves);
                break;
            }
        }

    }
}
