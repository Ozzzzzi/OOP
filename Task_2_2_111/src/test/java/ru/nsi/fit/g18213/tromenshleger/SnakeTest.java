package ru.nsi.fit.g18213.tromenshleger;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SnakeTest {
    private Snake snake;
    private Point2D head;
    private Point2D tail;

    @BeforeEach
    void setUp() {
        head = new Point2D(1, 0);
        tail = new Point2D(0, 0);
        snake = new Snake(head, tail, 1);
        snake.setDirection(Direction.DOWN);
    }

    @Test
    void snakeShouldCollideWithItself() {
        snake = new Snake(new Point2D(0, 0), tail, 25);

        assertTrue(snake.doesCollideWithItself());
    }

    @Test
    void snakeShouldHaveCorrectHeadDirection() {
        snake.move();
        assertEquals(Direction.DOWN, snake.getHead().getDirection());
    }

    @Test
    void snakeShouldHaveCorrectBodyDirection() {
        snake.setDirection(Direction.UP);
        snake.move();
        snake.move();
        assertEquals(Direction.UP, snake.getBody(1).getDirection());
    }

    @Test
    void snakeShouldHaveCorrectDirection() {
        assertEquals(Direction.DOWN, snake.getDirection());
    }

    @Test
    void snakeShouldBeInTheCorrectPosition() {
        assertEquals(head, snake.getHead().getPosition());
        assertEquals(tail, snake.getBody(1).getPosition());
    }

    @Test
    void snakeMovesToTheRight_ShouldHaveCorrectPosition() {
        snake.setDirection(Direction.RIGHT);
        snake.move();

        assertEquals(new Point2D(2, 0), snake.getHead().getPosition());
        assertEquals(new Point2D(1, 0), snake.getBody(1).getPosition());
    }

    @Test
    void snakeShouldHaveCorrectSize() {
        assertEquals(2, snake.getSize());
    }

    @Test
    void snakeGrows_ShouldHaveCorrectNumberOfSegments() {
        IntStream.rangeClosed(1, 30).forEach(i -> snake.addSegment());

        assertEquals(32, snake.getSize());
    }
}
