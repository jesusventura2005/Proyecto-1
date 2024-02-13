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
                if (temporal.getDato().toString().equals(dato.toString())) {
                    existe = true;
                }
                temporal = temporal.getSiguiente();
            }
        }
        return existe;

    }

    public void NuevaArista(Object origen, Object destino) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoGrafo posicionOrigen = primero;
            NodoGrafo posicionDestino = primero;
            while (!posicionOrigen.getDato().equals(origen.toString())) {
                posicionOrigen = posicionOrigen.getSiguiente();
            }
            while (!posicionDestino.getDato().equals(destino.toString())) {
                posicionDestino = posicionDestino.getSiguiente();
            }
            posicionOrigen.getLista().nuevaAdyacencia(destino);
            posicionDestino.getLista().nuevaAdyacencia(origen); // Esta línea añade la arista en la dirección opuesta
        }
    }
    
    public void NuevaArista(Object origen, Object destino, float distancia, float feromonas) {
        if (existeVertice(origen) && existeVertice(destino)) {
            // Obtener los nodos correspondientes a los vértices de origen y destino
            NodoGrafo nodoOrigen = obtenerNodo(origen);
            NodoGrafo nodoDestino = obtenerNodo(destino);

            // Agregar la arista desde origen hacia destino con el peso especificado
            nodoOrigen.getLista().nuevaAdyacencia(destino, distancia, feromonas);
            // Agregar la arista desde destino hacia origen con el mismo peso
            nodoDestino.getLista().nuevaAdyacencia(origen, distancia, feromonas);
        }
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
                sb.append(arco.getDestino()).append("(").append(arco.getDistancia()).append(")");
                primero = false;
                arco = arco.getSiguiente();
            }
            sb.append("\n");
            temporal = temporal.getSiguiente();
        }
        return sb.toString();
    }










    
}
