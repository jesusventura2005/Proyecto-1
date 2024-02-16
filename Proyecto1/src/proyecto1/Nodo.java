/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author drali
 */
public class Nodo {
    
    private Nodo pNext; 
    private Object info;
//    private ListaAdyacencia Arcos; 

    public Nodo(Nodo pNext, Object info, ListaAdyacencia Arcos ) {
        this.pNext = pNext;
        this.info = info;
//        this.Arcos = Arcos;
    }
    
    public Nodo(Object info) {
        this.pNext = null;
        this.info = info;
//        this.Arcos = null; 
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
    
    
}
