/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Esta clase define objetos Nodo que se utilizan en estructuras de datos como listas enlazadas.
 * @author Carlos De Freitas
 * @version 16/02/2024
 */
public class Nodo {
    
    private Nodo pNext; 
    private Object info;

    /**
     * Constructor de la clase Nodo.
     * @param pNext El siguiente nodo en la estructura.
     * @param info La información que se almacenará en este nodo.
     */
    public Nodo(Nodo pNext, Object info) {
        this.pNext = pNext;
        this.info = info;
    }
    
    /**
     * Constructor alternativo de la clase Nodo que no especifica un siguiente nodo.
     * @param info La información que se almacenará en este nodo.
     */
    public Nodo(Object info) {
        this.pNext = null;
        this.info = info;
    }

    /**
     * Método para obtener el siguiente nodo.
     * @return El siguiente nodo en la estructura.
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * Método para establecer el siguiente nodo.
     * @param pNext El siguiente nodo en la estructura.
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    /**
     * Método para obtener la información almacenada en este nodo.
     * @return La información almacenada en este nodo.
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Método para establecer la información almacenada en este nodo.
     * @param info La información que se almacenará en este nodo.
     */
    public void setInfo(Object info) {
        this.info = info;
    }
   
}
