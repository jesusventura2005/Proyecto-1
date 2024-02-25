/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import Ventanas.Ventana1;

/**
 * Clase principal que inicia la aplicación.
 * Esta clase contiene el método `main`, que es el punto de entrada de la aplicación.
 * @author Daniel Fariña
 * @version 18/02/2024
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        
        // Configuración para utilizar la interfaz de usuario Swing en GraphStream
        System.setProperty("org.graphstream.ui", "swing");
        // Crear una instancia de la ventana principal (Ventana1) y hacerla visible
        Ventana1 ventana = new Ventana1();
        ventana.setVisible(true);

        
    }
    
}