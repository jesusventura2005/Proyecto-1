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

    Object destino;
    float peso;
    Arco siguiente;

    public Arco(Object d) {
        destino = d;
        siguiente = null;

    }

    public Arco(Object d, float p) {
        destino = d;
        peso = p;
        siguiente = null;

    }

    public Object getDestino() {
        return destino;
    }

    public void setDestino(Object destino) {
        this.destino = destino;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Arco getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arco siguiente) {
        this.siguiente = siguiente;
    }

    
    
}
