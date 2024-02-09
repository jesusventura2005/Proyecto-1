/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author jesus
 */
public class ListaAdyacencia{

    Arco primero;
    Arco ultimo;

    public ListaAdyacencia() {
        primero = null;
        ultimo = null;

    }

    public boolean adyacente(Object dato) {
        Arco actual;
        boolean encontrado;
        encontrado = false;
        actual = primero;
        while (actual != null && !dato.toString().equals(actual.destino.toString())) {
            actual = actual.siguiente;
        }
        if (actual != null) {
            encontrado = true;
        }
        return encontrado;
    }

////////////////
    public boolean esvacia() {
        return primero == null;
    }

    public void insertar(Arco nodo, Object destino) {
        if (esvacia()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            if (destino.toString().compareTo(primero.destino.toString()) <= 0) {
                nodo.siguiente = primero;
            } else {
                if (destino.toString().compareTo(primero.destino.toString()) >= 0) {
                    nodo.siguiente = nodo;
                    ultimo = nodo;
                } else {
                    Arco posicion = primero;
                    while (destino.toString().compareTo(posicion.destino.toString()) != 0) {
                        posicion = posicion.siguiente;
                    }
                    
                    nodo.siguiente = posicion.siguiente;
                    posicion.siguiente = nodo;
                }

            }
        }

    }

    /////////////
    public void nuevaAdyacencia(Object destino) {
        if (!adyacente(destino)) {
            Arco nodo = new Arco(destino);
            insertar(nodo, destino);

        }

    }

    /////////////
    public void nuevaAdyacencia(Object destino, float peso) {
        if (!adyacente(destino)) {
            Arco nodo = new Arco(destino, peso);
            insertar(nodo, destino);

        }

    }
    
    
    public String toString(){
        String cadena = "";
        Arco temporal = primero;
        while(temporal != null){
            cadena = cadena + temporal.destino.toString()+" ; ";
            temporal = temporal.siguiente;
        
        }
        
        return  cadena;
        
    
    }
    
    

    public Arco getPrimero() {
        return primero;
    }

    public void setPrimero(Arco primero) {
        this.primero = primero;
    }

    public Arco getUltimo() {
        return ultimo;
    }

    public void setUltimo(Arco ultimo) {
        this.ultimo = ultimo;
    }

    public ListaAdyacencia(Arco primero, Arco ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }
    
    
    
    

}
