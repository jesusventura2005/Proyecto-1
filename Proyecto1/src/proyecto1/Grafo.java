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

    public NodoGrafo getPrimero() {
        return primero;
    }

    public NodoGrafo getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoGrafo primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoGrafo ultimo) {
        this.ultimo = ultimo;
    }

    public boolean grafoVacio() {
        return primero == null;
    }

    public boolean existeVertice(Object dato) {
        boolean existe = false;
        if (!grafoVacio()) {
            NodoGrafo temporal = primero;
            while (temporal != null && !existe) {
                if (temporal.getDato().toString().equals(dato.toString())) {
                    existe = true;
                }
                temporal = temporal.getSiguiente();
            }
        }
        return existe;

    }
    
    public Arco obtenerArcoEntreNodos(Object nodoOrigen, Object nodoDestino) {
        // Obtener el nodo origen
        NodoGrafo nodo = obtenerNodo(nodoOrigen);
        if (nodo != null) {
            // Recorrer la lista de adyacencia del nodo origen
            Arco arco = nodo.getLista().getPrimero();
            while (arco != null) {
                // Verificar si el destino del arco coincide con el nodo destino
                if (arco.getDestino().equals(nodoDestino)) {
                    // Se encontró el arco que conecta los nodos
                    return arco;
                }
                // Avanzar al siguiente arco
                arco = arco.getSiguiente();
            }
        }
        // Si no se encuentra el arco, devolver null
        return null;
    }


    public void NuevaArista(Object origen, Object destino) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoGrafo nodoOrigen = obtenerNodo(origen);
            NodoGrafo nodoDestino = obtenerNodo(destino);
            nodoOrigen.getLista().nuevaAdyacencia(destino);
            nodoDestino.getLista().nuevaAdyacencia(origen);
        }
    }

    
    public void NuevaArista(Object origen, Object destino, float distancia, float feromonas) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoGrafo nodoOrigen = obtenerNodo(origen);
            NodoGrafo nodoDestino = obtenerNodo(destino);
            nodoOrigen.getLista().nuevaAdyacencia(destino, distancia, feromonas);
            nodoDestino.getLista().nuevaAdyacencia(origen, distancia, feromonas);
        }
    }
    
    
    public int contarVertices() {
        int count = 0;
        if (this.primero != null){
            count++;
            NodoGrafo temporal = primero;
            while (temporal.getSiguiente() != null) {
                count++;
                temporal = temporal.getSiguiente();
            }    
        }
        return count;
    }

    // Método auxiliar para obtener el nodo correspondiente a un vértice
    private NodoGrafo obtenerNodo(Object dato) {
        NodoGrafo temporal = primero;
        while (temporal != null) {
            if (temporal.getDato().equals(dato)) {
                return temporal;
            }
            temporal = temporal.getSiguiente();
        }
        return null; // Si no se encuentra el nodo, devolver null
    }


    public void nuevoNodo(Object dato) {
        if (!existeVertice(dato)) {
            NodoGrafo nodo = new NodoGrafo(dato);
            if (grafoVacio()) {
                primero = nodo;
                ultimo = nodo;
            } else {
                ultimo.setSiguiente(nodo);
                ultimo = nodo;
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodoGrafo temporal = primero;

        while (temporal != null) {
            sb.append(temporal.getDato()).append("-->");
            ListaAdyacencia lista = temporal.getLista();
            Arco arco = lista.getPrimero();
            boolean primero = true; // Variable para controlar si es el primer arco del nodo

            // Agregar los arcos del vértice actual al StringBuilder
            while (arco != null) {
                if (!primero) {
                    sb.append(" ; ");
                }
                sb.append(arco.getDestino()).append("(").append(arco.getDistancia()).append(",").append(arco.getFeromonas()).append(",").append(arco.getVisibilidad()).append(")");
                primero = false;
                arco = arco.getSiguiente();
            }
            sb.append("\n");
            temporal = temporal.getSiguiente();
        }
        return sb.toString();
    }

}