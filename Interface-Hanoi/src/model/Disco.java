package model;
import java.awt.*;
public class ModeloRectangulo {
    private int x;
    private int y;
    private Color color;
    private int width;
    private int height;

    public ModeloRectangulo(int x, int y, Color color, int width, int height) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
