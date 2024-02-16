/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author drali
 */
public class ListaSimple {
    
    private Nodo pFirst; 
    private Nodo pLast; 
    private int size; 

    public ListaSimple(Nodo pFirst, Nodo pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = size;
    }
    
    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    public boolean EsVacia(){ 
        return (getpFirst() == null);               
    }
    
    public void InsertAtTheEnd(Object x){ 
        Nodo nuevo = new Nodo(x);
        if (this.EsVacia()){ 
            setpFirst(pLast = nuevo); 
        }else { 
            Nodo aux = pLast; 
            aux.setpNext(nuevo);
            pLast = nuevo;    
        }
        this.size = size++; 
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void vaciar(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
}

