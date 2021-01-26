package com.turtlePackage;

public class Position {
    private int rowPosition;
    private int columnPosition;

    public Position(int rowPosition, int columnPosition) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public void setColumnPosition(int columnPosition) {
        this.columnPosition = columnPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj.getClass() == this.getClass()) {
            Position comparedObject = (Position) obj;
            boolean isSameCoordinate = comparedObject.getColumnPosition() == this.getColumnPosition()
                    && comparedObject.getRowPosition() == this.getRowPosition();
            if (isSameCoordinate) {
                isEqual = true;
            }
        }
        return isEqual;
    }
}
