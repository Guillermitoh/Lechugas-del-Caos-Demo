package com.lechugasdelcaos.lechugasdelcaos.models;

import javafx.scene.canvas.GraphicsContext;

public abstract class ObjetoJuego {
    protected int x;
    protected int y;
    protected String nameImage;
    protected int speed = 5;

    public ObjetoJuego(int x, int y, String nameImage, int speed) {
        this.x = x;
        this.y = y;
        this.nameImage = nameImage;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void pintar(GraphicsContext graphics);

    public abstract void move();
}
