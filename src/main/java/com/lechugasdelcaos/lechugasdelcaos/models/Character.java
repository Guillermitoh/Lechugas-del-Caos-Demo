package com.lechugasdelcaos.lechugasdelcaos.models;

import com.lechugasdelcaos.lechugasdelcaos.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Character extends ObjetoJuego {
    private int vidas;

    public Character(int x, int y, String nameImage, int speed, int vidas) {
        super(x, y, nameImage, speed);
        this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }


    //Se ejecuta x cada iteracion del cliclo de juego
    @Override
    public void pintar(GraphicsContext graphics){
        graphics.drawImage(Main.imagenes.get(nameImage), x, y);
    }

    //Se ejecuta x cada iteracion del cliclo de juego
    @Override
    public void move() {
        if(x > 800)
            x=-273;
        if (Main.derecha) //Mover hacia la derecha
            x += speed;
        if (Main.izquierda) //Mover hacia la izquierda
            x -= speed;
        if (Main.arriba) //Mover hacia la arriba
            y -= speed;
        if (Main.abajo) //Mover hacia la abajo
            y += speed;
    }
}
