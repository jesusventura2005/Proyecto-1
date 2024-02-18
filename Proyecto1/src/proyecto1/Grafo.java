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

    public void eliminarNodo(Object dato) {
        NodoGrafo anterior = null;
        NodoGrafo actual = primero;

        // Buscar el nodo a eliminar
        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        // Si se encontró el nodo, eliminarlo
        if (actual != null) {
            if (anterior == null) {
                primero = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            // Liberar la lista de adyacencia del nodo
            actual.setLista(null);
        }
    }

    public void eliminarAristasPorCiudad(Object ciudad) {
        NodoGrafo temporal = primero;

        // Eliminar aristas donde la ciudad sea el origen o destino
        while (temporal != null) {
            ListaAdyacencia lista = temporal.getLista();
            lista.eliminarAristasPorCiudad(ciudad);
            temporal = temporal.getSiguiente();
        }
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
        if (this.primero != null) {
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
    public NodoGrafo obtenerNodo(Object dato) {
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
    
        // Agregar ciudades
        sb.append("ciudad\n");
        NodoGrafo temporal = primero;
        while (temporal != null) {
            sb.append(temporal.getDato()).append("\n");
            temporal = temporal.getSiguiente();
        }

        // Agregar aristas
        sb.append("aristas\n");
        temporal = primero;
        ListaSimple aristasAgregadas = new ListaSimple();
        while (temporal != null) {
            String origen = temporal.getDato().toString();
            ListaAdyacencia lista = temporal.getLista();
            Arco arco = lista.getPrimero();
            while (arco != null) {
                String destino = arco.getDestino().toString();
                float peso = arco.getDistancia();
                String aristaActual = origen + "," + destino + "," + peso;
                String aristaReversa = destino + "," + origen + "," + peso;
                // Verificar si ya se ha agregado esta arista o su reverso
                if (!aristasAgregadas.contains(aristaActual) && !aristasAgregadas.contains(aristaReversa)) {
                    sb.append(aristaActual).append("\n");
                    aristasAgregadas.InsertAtTheEnd(aristaActual);
                }
                arco = arco.getSiguiente();
            }
            temporal = temporal.getSiguiente();
        }

        return sb.toString();
            
    }
    
    /*
    public void crearGrafoVisual(){
        
        if (!grafoVacio()) {
            NodoGrafo temporal = primero; 
            ListaSimple aristasAgregadas = new ListaSimple(); // Lista para rastrear las aristas agregadas

            while (temporal != null) { 
                grafoVisible.addNode((String) temporal.getDato());
                temporal = temporal.getSiguiente();
            }

            temporal = primero;
            while (temporal != null) {
                Arco Arcoaux = temporal.getLista().getPrimero(); 
                while (Arcoaux != null) {
                    // Verificar si la arista ya ha sido agregada
                    if (!aristasAgregadas.contains(Arcoaux)) {
                        grafoVisible.addEdge(Float.toString(Arcoaux.getDistancia()), (String) temporal.getDato(), (String) Arcoaux.getDestino());
                        aristasAgregadas.InsertAtTheEnd(Arcoaux); // Agregar la arista a la lista de aristas agregadas
                    }
                    Arcoaux = Arcoaux.getSiguiente();
                } 
                temporal = temporal.getSiguiente();
            }
        }
    }
    */
    /*
    public void crearGrafoVisual(){
        if (!grafoVacio()) {
            NodoGrafo temporal = primero; 
            ListaSimple ciudadesVisitadas = new ListaSimple(); // Lista para rastrear las aristas agregadas
            int idArista = 1; // Identificador inicial para las aristas

            while (temporal != null) {
                grafoVisible.addNode((String) temporal.getDato());
                temporal = temporal.getSiguiente();
            }

            temporal = primero;
            while (temporal != null) {
                Arco Arcoaux = temporal.getLista().getPrimero(); 
                while (Arcoaux != null) {
                    // Construir un identificador único para la arista
                    String idUnico = Float.toString(Arcoaux.getDistancia()) + "_" + Integer.toString(idArista);

                    // Verificar si la arista ya ha sido agregada
                    if (!ciudadesVisitadas.contains((String) Arcoaux.getDestino())) {
                        grafoVisible.addEdge(idUnico, (String) temporal.getDato(), (String) Arcoaux.getDestino());
                        idArista++; // Incrementar el identificador para la próxima arista
                    }
                    
                    Arcoaux = Arcoaux.getSiguiente();
                }
                ciudadesVisitadas.InsertAtTheEnd((String) temporal.getDato()); // Agregar la ciudad a la lista de ciudades visitadas
                temporal = temporal.getSiguiente();
            }
        }
    }

    */
}
