/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Esta clase define una lista simple implementada utilizando nodos enlazados.
 * @author Carlos De Freitas
 * @version 16/02/2024
 */
public class ListaSimple {
    
    private Nodo pFirst; 
    private Nodo pLast; 
    private int size; 

    /**
     * Constructor de la clase ListaSimple que inicializa la lista con un primer nodo, un último nodo y un tamaño.
     * @param pFirst El primer nodo de la lista.
     * @param pLast El último nodo de la lista.
     * @param size El tamaño inicial de la lista.
     */
    public ListaSimple(Nodo pFirst, Nodo pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = size;
    }
    
    /**
     * Constructor alternativo de la clase ListaSimple que crea una lista vacía.
     */
    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    /**
     * Método que verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean EsVacia(){ 
        return (getpFirst() == null);               
    }
    
    /**
     * Método que verifica si la lista contiene un elemento dado.
     * @param elemento El elemento a buscar en la lista.
     * @return true si la lista contiene el elemento, false en caso contrario.
     */
    public boolean contains(Object elemento) {
        Nodo actual = pFirst;
        while (actual != null) {
            if (actual.getInfo().equals(elemento)) {
                return true;
            }
            actual = actual.getpNext();
        }
        return false;
    }

    /**
     * Método para insertar un elemento al final de la lista.
     * @param x El elemento a insertar.
     */
    public void InsertAtTheEnd(Object x){ 
        Nodo nuevo = new Nodo(x);
        if (this.EsVacia()){ 
            setpFirst(pLast = nuevo); 
        }else { 
            Nodo aux = pLast; 
            aux.setpNext(nuevo);
            pLast = nuevo;    
        }
        size++; 
    }
    
    /**
     * Método para eliminar un elemento de la lista.
     * @param elemento El elemento a eliminar.
     */
    public void RemoveElement(Object elemento) {
        // Verificar si la lista está vacía
        if (EsVacia()) {
            return;
        }
        
        // Caso especial: si el primer nodo contiene el elemento
        if (pFirst.getInfo().equals(elemento)) {
            pFirst = pFirst.getpNext();
            size--;
            if (pFirst == null) {
                pLast = null; // Si el primer nodo es el único nodo en la lista, pLast también debe ser null
            }
            return;
        }
        
        // Buscar el nodo que contiene el elemento y el nodo anterior
        Nodo prev = pFirst;
        Nodo current = pFirst.getpNext();
        while (current != null) {
            if (current.getInfo().equals(elemento)) {
                prev.setpNext(current.getpNext());
                size--;
                if (current == pLast) {
                    pLast = prev; // Si el nodo eliminado era el último, actualizamos pLast
                }
                return;
            }
            prev = current;
            current = current.getpNext();
        }
        
        // Si no se encontró el elemento, no se hace nada
    }
    
    /**
     * Método para imprimir la lista de hormigas.
     * @return Una cadena que representa la lista de hormigas y sus caminos.
     */
    public String ImprimirListadeHormigas(){ 
        StringBuilder cadena = new StringBuilder();
        int contador = 1;
        Nodo aux = this.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            Nodo aux1 = hormiga.getCamino().getpFirst();
            cadena.append("Hormiga ").append(contador).append(": ");
            while (aux1 != null) {
                cadena.append(aux1.getInfo());
                if(aux1.getpNext() != null)
                    cadena.append(", ");
                aux1 = aux1.getpNext();
            }
            cadena.append("\n");
            aux = aux.getpNext();
            contador ++;
        }
        return cadena.toString();
    }

    
    /**
     * Método para vaciar la lista, eliminando todos sus elementos.
     */
    public void vaciar(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Método para obtener el primer nodo de la lista.
     * @return El primer nodo de la lista.
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Método para establecer el primer nodo de la lista.
     * @param pFirst El nuevo primer nodo de la lista.
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Método para obtener el último nodo de la lista.
     * @return El último nodo de la lista.
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * Método para establecer el último nodo de la lista.
     * @param pLast El nuevo último nodo de la lista.
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * Método para obtener el tamaño de la lista.
     * @return El tamaño de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Método para establecer el tamaño de la lista.
     * @param size El nuevo tamaño de la lista.
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
}

