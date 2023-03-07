import java.io.File;
import javax.sound.sampled.*;

public class Reproductor implements Runnable {
    private final int id;

    public Reproductor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hilo n° " + id + " iniciado");

        // Si es el último hilo, reproducir la canción
        if (id == 3) {
            try {
                // Obtener el archivo de la canción
                File file = new File("Musica/cancion.wav");

                // Crear un objeto AudioInputStream y reproducirlo
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                

                // Esperar a que termine la canción 
                while (clip.isOpen()) {
                    Thread.sleep(200);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Si no se llega al ultimo hilo se genera un numero aleatorio
            try {
                Thread.sleep((long) (Math.random() * 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hilo n° " + id + " terminado");
    }
}
