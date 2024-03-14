package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import turtle.Direction;
import turtle.Turtle;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {

        private Turtle turtle;

        @BeforeEach
        void  setUp(){
            turtle = new Turtle();
        }

        @Test
        public void testThatPenIsDown() {
            assertFalse(turtle.isPenUp());
        }

        @Test
        public void testThatPenIsUp() {
            assertFalse(turtle.isPenUp());
            turtle.penUp();
            assertTrue(turtle.isPenUp());
        }

        @Test
        void penCanBeDown() {
            assertFalse(turtle.isPenUp());
            turtle.penUp();
            assertTrue(turtle.isPenUp());
            turtle.penDown();
            assertFalse(turtle.isPenUp());
        }

        @Test
        void ThatCurrentDirectionIsEast() {
             assertSame(turtle.getCurrentDirection(), Direction.EAST);
        }

        @Test
        void testThatTurtleCanTurnLeft() {
            turtle.turnLeft();
            assertSame(turtle.getCurrentDirection(),Direction.NORTH);

        }

        @Test
        void testThatTurtleCanTurnRight() {
            turtle.turnLeft();
            assertSame(turtle.getCurrentDirection(),Direction.NORTH);
            turtle.turnRight();
            assertSame(turtle.getCurrentDirection(),Direction.WEST);
        }
    }

