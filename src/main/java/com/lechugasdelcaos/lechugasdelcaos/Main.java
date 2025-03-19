package com.lechugasdelcaos.lechugasdelcaos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
    private GraphicsContext graphics;
    private Group root;
    private Canvas canvas;
    private Scene scene;
    private int x = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        inicializarComponentes();
        gestionEventos();
        pintar();
        stage.setScene(scene);
        stage.setTitle("Lechugas del Caos");
        stage.show();
    }

    public void inicializarComponentes(){
        root = new Group();
        canvas = new Canvas(800,600);
        scene = new Scene(root, 800,600);
        root.getChildren().add(canvas);
        graphics = canvas.getGraphicsContext2D();
    }

    public void pintar(){
        graphics.fillRect(0,0,100,100);
        graphics.drawImage(new Image("images.png"),x,0);
    }

    public void gestionEventos(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                switch (evento.getCode().toString()){
                    case "RIGHT":
                        x += 10;
                        System.out.println("SE presiona la tecla " + evento.getCode());
                        System.out.println("X: " + x);
                        break;
                }

            }
        });
    }



}