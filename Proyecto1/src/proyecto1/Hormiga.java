/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author drali
 */
public class Hormiga {

    private ListaSimple camino; 
    private float seleccion;  
    private float alpha;  
    private float beta;  
    private Grafo grafo; 

    public Hormiga(ListaSimple camino, float seleccion, float alpha, float beta, Grafo grafo) {
        this.camino = camino;
        this.seleccion = seleccion;
        this.alpha = alpha;
        this.beta = beta;
        this.grafo = grafo;
    }
    
    public Hormiga() {
        this.camino = null;
        this.seleccion = 0;
        this.alpha = 0;
        this.beta = 0;
        this.grafo = null;
    }

    public boolean NodoVisitado(NodoGrafo nodo) { 
        boolean visitado = false; 
        Nodo aux = getCamino().getpFirst(); 
        while (nodo.getDato() != aux.getInfo()) {
            if (nodo.getDato() == aux.getInfo()) { 
                visitado = true;
            }else{ 
                break; 
            } 
        break;
        }
        return visitado; 
    } 
 
    public void BuscarCamino(Grafo grafo) {
        
        
        
    }

    public ListaSimple getCamino() {
        return camino;
    }

    public void setCamino(ListaSimple camino) {
        this.camino = camino;
    }

    public float getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(float seleccion) {
        this.seleccion = seleccion;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    
}
