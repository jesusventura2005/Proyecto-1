/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author jesus
 */
public class Grafo {

    private NodoGrafo primero;
    private NodoGrafo ultimo;

    public Grafo() {
        primero = null;
        ultimo = null;

    }

    public boolean grafoVacio() {
        return primero == null;
    }

    public boolean existeVertice(Object dato) {
        boolean existe = false;
        if (!grafoVacio()) {
            NodoGrafo temporal = primero;
            while (temporal != null && !existe) {
                if (temporal.dato.toString().equals(dato.toString())) {
                    existe = true;
                }
                temporal = temporal.siguiente;
            }
        }
        return existe;

    }

    public void NuevaArista(Object origen, Object destino) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoGrafo posicion = primero;
            while (!posicion.dato.equals(origen.toString())) {
                posicion = posicion.siguiente;

            }
            posicion.lista.nuevaAdyacencia(destino);

        }

    }

    public void NuevaArista(Object origen, Object destino, float peso) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoGrafo posicion = primero;
            while (!posicion.dato.equals(origen.toString())) {
                posicion = posicion.siguiente;

            }
            posicion.lista.nuevaAdyacencia(destino, peso);

        }

    }

    public void nuevoNodo(Object dato) {
        if (!existeVertice(dato)) {
            NodoGrafo nodo = new NodoGrafo(dato);
            if (grafoVacio()) {
                primero = nodo;
                ultimo = nodo;
            } else {
                if (dato.toString().compareTo(primero.dato.toString()) <= 0) {
                    nodo.siguiente = primero;
                    primero = nodo;
                } else {
                    if (dato.toString().compareTo(primero.dato.toString()) >= 0) {
                        ultimo.siguiente = nodo;
                        ultimo = nodo;
                    } else {

                        NodoGrafo temporal = primero;
                        while (dato.toString().compareTo(temporal.dato.toString()) == 0) {
                            temporal = temporal.siguiente;

                        }
                        nodo.siguiente = temporal.siguiente;
                        temporal.siguiente = nodo;

                    }
                }

            }
        }

    }

    
    
    
   public String toString(){
       String cadena="";
       NodoGrafo temporal = primero;
       while (temporal!=null){
           cadena = cadena + temporal.dato.toString()+"-->" + temporal.lista.toString()+"\n";
           temporal = temporal.siguiente;
       
       }
       return cadena;
   
   }
    
}
