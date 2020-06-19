package ru.nsi.fit.g18213.tromenshleger;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The class represents an obstacle. If the snake hits the obstacle, the game ends.
 */
class Obstacle extends GameObject {

    Obstacle(Point2D position, double width, double height) {
        super(position, width, height);
    }

    @Override
    void render(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.INDIGO);
        graphicsContext.fillRect(position.getX(), position.getY(), 25, 25);
    }
}
