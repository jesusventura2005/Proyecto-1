/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author jesus
 */
public class Arco {

    private Object destino;
    private float distancia;
    private float feromonas;
    private float visibilidad;
    private Arco siguiente; 

    public Arco(Object d) {
        this.destino = d;
        this.siguiente = null; 

    }

    public Arco(Object d, float distancia, float feromonas, float visibilidad) {
        this.destino = d;
        this.distancia = distancia;
        this.feromonas = feromonas;
        this.visibilidad = visibilidad;
        this.siguiente = null;
        
    }

    public Object getDestino() {
        return destino;
    }

    public void setDestino(Object destino) {
        this.destino = destino;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float peso) {
        this.distancia = peso;
    }

    public Arco getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arco siguiente) {
        this.siguiente = siguiente;
    }

    public float getFeromonas() {
        return feromonas;
    }

    public void setFeromonas(float feromonas) {
        this.feromonas = feromonas;
    }

    public float getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(float visibilidad) {
        this.visibilidad = visibilidad;
    }
    
}