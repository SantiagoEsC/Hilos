import javax.swing.*;

import javafx.scene.control.Button;

import java.awt.Color;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana 
        JFrame frame = new JFrame("Reproductor de música");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el botón 
        JButton startButton = new JButton("Reproducir");
        startButton.setBackground(Color.blue);
        startButton.addActionListener(e -> {
            // Crear los hilos
            for (int i = 0; i < 4; i++) {
                Thread thread = new Thread(new Reproductor(i));
                thread.start();
            }
        });


        // Agregar el botón
        frame.add(startButton);
        frame.setVisible(true);
    }
}