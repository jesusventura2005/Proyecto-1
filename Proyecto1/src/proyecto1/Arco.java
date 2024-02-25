/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Esta clase define un arco que conecta dos nodos en un grafo.
 * @author Jesus Ventura
 * @version 09/02/2024
 */
public class Arco implements Cloneable {

    private Object destino;
    private float distancia;
    private float feromonas;
    private float visibilidad;
    private Arco siguiente; 

    /**
     * Constructor de la clase Arco que inicializa el destino del arco y establece el siguiente arco como nulo.
     * @param d El nodo destino del arco.
     */
    public Arco(Object d) {
        this.destino = d;
        this.siguiente = null; 

    }

    /**
     * Constructor de la clase Arco que inicializa el destino, la distancia y las feromonas del arco.
     * Calcula automáticamente la visibilidad basada en la distancia.
     * @param d El nodo destino del arco.
     * @param distancia La distancia entre los nodos conectados por el arco.
     * @param feromonas El nivel de feromonas en el arco.
     */
    public Arco(Object d, float distancia, float feromonas) {
        this.destino = d;
        this.distancia = distancia;
        this.feromonas = feromonas;
        this.visibilidad = 1.0f / distancia;
        this.siguiente = null;
        
    }

    /**
     * Método para obtener el nodo destino del arco.
     * @return El nodo destino del arco.
     */
    public Object getDestino() {
        return destino;
    }

    /**
     * Método para establecer el nodo destino del arco.
     * @param destino El nuevo nodo destino del arco.
     */
    public void setDestino(Object destino) {
        this.destino = destino;
    }

    /**
     * Método para obtener la distancia entre los nodos conectados por el arco.
     * @return La distancia entre los nodos conectados por el arco.
     */
    public float getDistancia() {
        return distancia;
    }

    /**
     * Método para establecer la distancia entre los nodos conectados por el arco.
     * @param distancia La nueva distancia entre los nodos conectados por el arco.
     */
    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    /**
     * Método para obtener el siguiente arco en la estructura.
     * @return El siguiente arco en la estructura.
     */
    public Arco getSiguiente() {
        return siguiente;
    }

    /**
     * Método para establecer el siguiente arco en la estructura.
     * @param siguiente El nuevo siguiente arco en la estructura.
     */
    public void setSiguiente(Arco siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Método para obtener el nivel de feromonas en el arco.
     * @return El nivel de feromonas en el arco.
     */
    public float getFeromonas() {
        return feromonas;
    }

    /**
     * Método para establecer el nivel de feromonas en el arco.
     * @param feromonas El nuevo nivel de feromonas en el arco.
     */
    public void setFeromonas(float feromonas) {
        this.feromonas = feromonas;
    }

    /**
     * Método para obtener la visibilidad del arco.
     * @return La visibilidad del arco.
     */
    public float getVisibilidad() {
        return visibilidad;
    }

    /**
     * Método para establecer la visibilidad del arco.
     * @param visibilidad La nueva visibilidad del arco.
     */
    public void setVisibilidad(float visibilidad) {
        this.visibilidad = visibilidad;
    }
    
    /**
     * Método para clonar un arco.
     * @return Una copia del arco clonado.
     */
    @Override
    public Arco clone() {
        try {
            return (Arco) super.clone();
        } catch (CloneNotSupportedException e) {
            // Manejo de excepción si la clase no es clonable
            return null;
        }
    }
}