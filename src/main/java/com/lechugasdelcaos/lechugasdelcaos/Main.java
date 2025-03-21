package com.lechugasdelcaos.lechugasdelcaos;

import com.lechugasdelcaos.lechugasdelcaos.models.Character;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.HashMap;


public class Main extends Application {
    private GraphicsContext graphics;
    private Group root;
    private Canvas canvas;
    private Scene scene;
    private final int x = 0;
    private Character character;
    public static boolean arriba;
    public static boolean abajo;
    public static boolean izquierda;
    public static boolean derecha;
    public static HashMap<String, Image> imagenes;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        inicializarComponentes();
        gestionEventos();
        stage.setScene(scene);
        stage.setTitle("Lechugas del Caos");
        stage.show();
        cicloJuego();
    }

    public void cicloJuego(){
        long tiempoInicial = System.nanoTime();
        AnimationTimer animationtimer = new AnimationTimer() {

            //Este metodo se ejecuta aproximadamente 60FPS
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual - tiempoInicial) / 1000000000.0;
                System.out.println(t);
                actualizarEstado();
                pintar();

            }
        };

        animationtimer.start();
    }

    public void actualizarEstado(){
        character.move();
    }

    public void inicializarComponentes(){
        imagenes = new HashMap<String, Image>();
        cargarImagenes();
        character= new Character(20,40,3,"images");
        root = new Group();
        canvas = new Canvas(800,600);
        scene = new Scene(root, 800,600);
        root.getChildren().add(canvas);
        graphics = canvas.getGraphicsContext2D();
    }

    public void cargarImagenes(){
        imagenes.put("images", new Image("images.png"));
        imagenes.put("background", new Image("background.jpg"));
    }

    public void pintar(){
        //graphics.fillRect(0,0,100,100);
        graphics.drawImage(imagenes.get("background"),0,0);
        character.pintar(graphics);

    }

    public void gestionEventos(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                switch (evento.getCode().toString()){
                    case "RIGHT":
                        derecha = true;
                        break;
                    case  "LEFT":
                        izquierda = true;
                        break;
                    case "UP":
                        arriba = true;
                        break;
                   case "DOWN":
                        abajo = true;
                        break;
                    case "SPACE":
                        character.setNameImage("images1.png");
                        character.setSpeed(10);
                        break;
                }

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            //Este metodo se ecuta cuando se suelta una tecla
            @Override
            public void handle(KeyEvent evento) {
                switch (evento.getCode().toString()){
                    case "RIGHT":
                        derecha = false;
                        break;
                    case  "LEFT":
                        izquierda = false;
                        break;
                    case "UP":
                        arriba = false;
                        break;
                    case "DOWN":
                        abajo = false;
                        break;
                    case "SPACE":
                        character.setNameImage("images.png");
                        character.setSpeed(5);
                        break;
                }
            }
        });
    }



}