/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author jesus
 */
public class NodoGrafo {
    Object dato;
    ListaAdyacencia lista;
    NodoGrafo siguiente;
    
    public NodoGrafo(Object x){
        dato = x;
        lista = new ListaAdyacencia(); 
        siguiente = null;

}

    public NodoGrafo(Object dato, ListaAdyacencia lista, NodoGrafo siguiente) {
        this.dato = dato;
        this.lista = lista;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public ListaAdyacencia getLista() {
        return lista;
    }

    public void setLista(ListaAdyacencia lista) {
        this.lista = lista;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}