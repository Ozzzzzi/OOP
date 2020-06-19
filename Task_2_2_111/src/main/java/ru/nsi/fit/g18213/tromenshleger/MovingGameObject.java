package ru.nsi.fit.g18213.tromenshleger;

import javafx.geometry.Point2D;

/**
 * The class represents all the moving objects in the game.
 */
class MovingGameObject extends GameObject {
    private Direction direction;

    MovingGameObject() {}

    MovingGameObject(Point2D position, double bodySize) {
        super(position, bodySize);
    }

    MovingGameObject(Point2D position, double bodySize, Direction direction) {
        super(position, bodySize);
        this.direction = direction;
    }

    Direction getDirection() {
        return direction;
    }
}
