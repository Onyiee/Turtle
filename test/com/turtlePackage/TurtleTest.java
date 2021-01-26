package com.turtlePackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurtleTest {
    Turtle turtle;
    Pen turtlePen;
    Sketchpad sketchpad;

    @BeforeEach
    void setUp() {
        turtlePen = new Pen();
        turtle = new Turtle(turtlePen);
        sketchpad = new Sketchpad(20, 20);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void turtle_hasAPen(){
        assertNotNull(turtle.getPen());
    }

    @Test
    void turtlePen_canBeSetToDown(){
        turtle.getPen().setPenOrientation(PenOrientation.PEN_DOWN);

        assertEquals(turtle.getPen().getPenOrientation(), PenOrientation.PEN_DOWN);
    }

    @Test
    void turtlePen_CanBeSetToUp(){
        turtle.getPen().setPenOrientation(PenOrientation.PEN_UP);
        assertEquals(turtle.getPen().getPenOrientation() ,PenOrientation.PEN_UP);
    }

    @Test
    void turtle_canTurnRight(){
        //given
        turtle.setCurrentDirection(CurrentDirection.EAST);
        //when
        turtle.turnRight();
        //assert
        assertEquals(CurrentDirection.SOUTH, turtle.getCurrentDirection()) ;

        turtle.turnRight();

        assertEquals(CurrentDirection.WEST, turtle.getCurrentDirection());
    }

    @Test
    void turtle_canTurnLeft(){
        turtle.setCurrentDirection(CurrentDirection.EAST);
        turtle.turnLeft();
        assertEquals(CurrentDirection.NORTH, turtle.getCurrentDirection());
        turtle.turnLeft();
        assertEquals(CurrentDirection.WEST, turtle.getCurrentDirection());
        turtle.turnLeft();
        assertEquals(CurrentDirection.SOUTH, turtle.getCurrentDirection());
        turtle.turnLeft();
        assertEquals(CurrentDirection.EAST,turtle.getCurrentDirection());
    }

    @Test
    void turtleCanMoveEastwardOnSketchPad(){
        turtle.setCurrentDirection(CurrentDirection.EAST);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_UP);
        turtle.setCurrentPosition(new Position(0,0));
        turtle.move(sketchpad,5);
        assertEquals(new Position(0,4), turtle.getCurrentPosition());

        turtle.move(sketchpad,2);
        assertEquals(new Position(0,5),
                turtle.getCurrentPosition());
    }

    @Test
    void turtleCanMoveSouthwardOnSketchPad(){
        turtle.setCurrentDirection(CurrentDirection.SOUTH);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_UP);
        turtle.setCurrentPosition(new Position(0,0));
        turtle.move(sketchpad,5);
        assertEquals(new Position(4,0), turtle.getCurrentPosition());

        turtle.move(sketchpad,2);
        assertEquals(new Position(5,0),
                turtle.getCurrentPosition());
    }

    @Test
    void turtleCanMoveNorthwardOnSketchPad(){
        turtle.setCurrentDirection(CurrentDirection.NORTH);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_UP);
        turtle.setCurrentPosition(new Position(7,0));
        turtle.move(sketchpad,5);
        assertEquals(new Position(3,0), turtle.getCurrentPosition());

        turtle.move(sketchpad,2);
        assertEquals(new Position(2,0),
                turtle.getCurrentPosition());

    }

    @Test
    void turtleCanMoveWestwardOnSketchPad(){
        turtle.setCurrentDirection(CurrentDirection.WEST);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_UP);

        turtle.setCurrentPosition(new Position(0,7));
        turtle.move(sketchpad,5);
        assertEquals(new Position(0,3), turtle.getCurrentPosition());

        turtle.move(sketchpad,2);
        assertEquals(new Position(0,2),
                turtle.getCurrentPosition());

    }

    @Test
    void turtle_canWriteOnSketchPad_whileFacingEast(){
        turtle.setCurrentDirection(CurrentDirection.EAST);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_DOWN);
        Sketchpad sketchpad = new Sketchpad(20,20);
        turtle.setCurrentPosition(new Position(0,0));
        int numberOfMoves = 5;
        turtle.move(sketchpad, numberOfMoves);
        for (int column = 0; column < numberOfMoves; column++){
            assertEquals(1, sketchpad.getFloor()[0][column]);
        }
        assertEquals(new Position(0,4), turtle.getCurrentPosition());
    }

    @Test
    void turtle_canWriteOnSketchPad_whileFacingWest(){
        turtle.setCurrentDirection(CurrentDirection.WEST);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_DOWN);
        turtle.setCurrentPosition(new Position(0, 10));
        int numberOfMoves = 5;
        turtle.move(sketchpad, numberOfMoves);
        for (int column = 10; column > numberOfMoves; column--){
            assertEquals(1, sketchpad.getFloor()[0][column]);
        }
        assertEquals(new Position(0, 6), turtle.getCurrentPosition());
    }

    @Test
    void turtle_canWriteOnSketchPad_whileFacingSouth(){
        turtle.setCurrentDirection(CurrentDirection.SOUTH);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_DOWN);
        turtle.setCurrentPosition(new Position(0, 0));
        int numberOfMoves = 5;
        turtle.move(sketchpad, numberOfMoves);
        for (int rows = 0; rows < numberOfMoves; rows++){
            assertEquals(1, sketchpad.getFloor()[rows][0]);
        }
        assertEquals(new Position(4, 0), turtle.getCurrentPosition());
    }

    @Test
    void turtle_canWriteOnSketch_whileFacingNorth(){
        turtle.setCurrentDirection(CurrentDirection.NORTH);
        turtle.getPen().setPenOrientation(PenOrientation.PEN_DOWN);
        turtle.setCurrentPosition(new Position(10, 0));
        int numberOfMoves = 5;
        turtle.move(sketchpad, numberOfMoves);
        for (int rows = 10; rows > numberOfMoves; rows--){
            assertEquals(1, sketchpad.getFloor()[rows][0]);
        }
        assertEquals(new Position(6, 0),turtle.getCurrentPosition());
    }


}