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

    private Arco primero;
    private Arco ultimo;

    public ListaAdyacencia() {
        this.primero = null;
        this.ultimo = null;

    }

    
    public boolean adyacente(Object dato) {
        Arco actual;
        boolean encontrado;
        encontrado = false;
        actual = primero;
        while (actual != null && !dato.toString().equals(actual.getDestino().toString())) {
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            encontrado = true;
        }
        return encontrado;
    }
    
    
    public Arco buscarArco(Object destino) {
        Arco arcoActual = primero;
        while (arcoActual != null) {
            if (arcoActual.getDestino().equals(destino)) {
                return arcoActual; // Se encontró el arco
            }
            arcoActual = arcoActual.getSiguiente();
        }
        return null; // No se encontró un arco que conecte con el nodo destino
    }


////////////////
    public boolean esvacia() {
        return primero == null;
    }

    public void insertar(Arco nodo) {
        if (esvacia() || Integer.parseInt(nodo.getDestino().toString()) < Integer.parseInt(this.primero.getDestino().toString())) {
            nodo.setSiguiente(this.primero);
            this.primero = nodo;
        } else {
            Arco posicion = this.primero;
            while (posicion.getSiguiente() != null && Integer.parseInt(nodo.getDestino().toString()) > Integer.parseInt(posicion.getSiguiente().getDestino().toString())) {
                posicion = posicion.getSiguiente();
            }
            nodo.setSiguiente(posicion.getSiguiente());
            posicion.setSiguiente(nodo);
        }
    }
    
    public void nuevaAdyacencia(Object destino) {
        if (!adyacente(destino)) {
            Arco nodo = new Arco(destino);
            insertar(nodo);

        }

    }

    public void nuevaAdyacencia(Object destino, float distancia, float feromonas) {
        if (!adyacente(destino)) {
            Arco nodo = new Arco(destino, distancia, feromonas);
            insertar(nodo);

        }

    }
    
    public String toString(){
        String cadena = "";
        Arco temporal = primero;
        while(temporal != null){
            cadena = cadena + temporal.getDestino().toString()+" ; ";
            temporal = temporal.getSiguiente();
        
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