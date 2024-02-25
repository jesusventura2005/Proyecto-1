/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Esta clase define un nodo utilizado en la representación de un grafo.
 * @author Jesus Ventura
 * @version 09/02/2024
 */
public class NodoGrafo {
    private Object dato;
    private ListaAdyacencia lista;
    private NodoGrafo siguiente;
    
    /**
     * Constructor de la clase NodoGrafo.
     * @param x El dato a almacenar en el nodo.
     */
    public NodoGrafo(Object x){
        this.dato = x;
        this.lista = new ListaAdyacencia(); 
        this.siguiente = null;

    }

    /**
     * Constructor de la clase NodoGrafo.
     * @param dato El dato a almacenar en el nodo.
     * @param lista La lista de adyacencia asociada al nodo.
     * @param siguiente El siguiente nodo en la estructura.
     */
    public NodoGrafo(Object dato, ListaAdyacencia lista, NodoGrafo siguiente) {
        this.dato = dato;
        this.lista = lista;
        this.siguiente = siguiente;
    }

    /**
     * Método para obtener el dato almacenado en el nodo.
     * @return El dato almacenado en el nodo.
     */
    public Object getDato() {
        return dato;
    }

    /**
     * Método para establecer el dato almacenado en el nodo.
     * @param dato El nuevo dato a almacenar en el nodo.
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Método para obtener la lista de adyacencia asociada al nodo.
     * @return La lista de adyacencia asociada al nodo.
     */
    public ListaAdyacencia getLista() {
        return lista;
    }

    /**
     * Método para establecer la lista de adyacencia asociada al nodo.
     * @param lista La nueva lista de adyacencia a asociar al nodo.
     */
    public void setLista(ListaAdyacencia lista) {
        this.lista = lista;
    }

    /**
     * Método para obtener el siguiente nodo en la estructura.
     * @return El siguiente nodo en la estructura.
     */
    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    /**
     * Método para establecer el siguiente nodo en la estructura.
     * @param siguiente El nuevo siguiente nodo en la estructura.
     */
    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }

}