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
    private Arco siguiente;
    private float feromonas; 

    public Arco(Object d, float feromonas) {
        this.destino = d;
        this.siguiente = null;
        this.feromonas = feromonas; 

    }

    public Arco(Object d, float p, float feromonas ) {
        this.destino = d;
        this.distancia = p;
        this.siguiente = null;
        this.feromonas = feromonas; 
        
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

    
    
}
