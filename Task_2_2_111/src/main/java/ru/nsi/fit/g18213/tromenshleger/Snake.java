package ru.nsi.fit.g18213.tromenshleger;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.LinkedList;

/**
 * The class represents a snake that can be moved in 4 directions.
 */
class Snake {
    private final LinkedList<MovingGameObject> body = new LinkedList<>();
    private final int bodySize;
    private MovingGameObject tail;

    private Direction direction = Direction.RIGHT;

    Snake(Point2D head, Point2D tail, int bodySize) {
        this.bodySize = bodySize;

        body.add(new MovingGameObject(head, bodySize));
        body.add(new MovingGameObject(tail, bodySize));
    }

    void move() {
        tail = body.pollLast();

        switch (direction) {
            case UP:
            {
                Point2D newPos = getHead().getPosition().subtract(0, bodySize);
                body.addFirst(new MovingGameObject(newPos, bodySize, direction));
                break;
            }
            case DOWN:
            {
                Point2D newPos = getHead().getPosition().add(0, bodySize);
                body.addFirst(new MovingGameObject(newPos, bodySize, direction));
                break;
            }
            case LEFT:
            {
                Point2D newPos = getHead().getPosition().subtract(bodySize, 0);
                body.addFirst(new MovingGameObject(newPos, bodySize, direction));
                break;
            }
            case RIGHT:
            {
                Point2D newPos = getHead().getPosition().add(bodySize, 0);
                body.addFirst(new MovingGameObject(newPos, bodySize, direction));
                break;
            }
        }
    }

    void addSegment() {
        body.add(new MovingGameObject());
    }

    boolean doesCollideWith(GameObject gameObject) {
        for (int i = 0; i < getSize(); i++) {
            if (gameObject.doesCollideWith(body.get(i))) {
                return true;
            }
        }

        return false;
    }

    boolean doesCollideWithItself() {
        for (int i = 1; i < getSize(); i++) {
            if (getHead().getPosition().equals(getBody(i).getPosition())) {
                return true;
            }
        }

        return false;
    }

    void render(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.DARKGREEN);
        graphicsContext.fillRect(
                getHead().getPosition().getX(), getHead().getPosition().getY(), 25, 25);

        graphicsContext.setFill(Color.DARKGREEN);
        graphicsContext.fillRect(
                getNeck().getPosition().getX(), getNeck().getPosition().getY(), 25, 25);

        if (tail != null) {
            graphicsContext.setFill(Color.DARKSEAGREEN);
            tail.render(graphicsContext);
        }
    }

    MovingGameObject getHead() {
        return body.getFirst();
    }

    MovingGameObject getBody(int index) {
        return body.get(index);
    }

    int getSize() {
        return body.size();
    }

    Direction getDirection() {
        return direction;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }

    private MovingGameObject getNeck() {
        return body.get(1);
    }
}
