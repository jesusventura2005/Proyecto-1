/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author jesus
 */
public class Grafo implements Cloneable {

    private NodoGrafo primero;
    private NodoGrafo ultimo;
    private Graph grafoVisible;

    public Grafo() {
        primero = null;
        ultimo = null;
        grafoVisible = new SingleGraph("Grafo");

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

    public Graph getGrafoVisible() {
        return grafoVisible;
    }

    public void setGrafoVisible(Graph grafoVisible) {
        this.grafoVisible = grafoVisible;
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
        NodoGrafo ultimo1 = ultimo;

        // Buscar el nodo a eliminar
        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        // Si se encontró el nodo, eliminarlo
        if (actual != null) {
            if (anterior == null) {
                primero = actual.getSiguiente();
            }
            if (actual == ultimo1) {
                ultimo = anterior;
                ultimo.setSiguiente(null);

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

    public Graph RetornarGrafoVisible(ListaSimple caminoMasOptimo) {
        Graph grafito = new SingleGraph("Grafox");
        String styleSheet
                = "node {"
                + "   text-size: 24;"
                + // Tamaño del texto
                "   text-color: white;"
                + // Color del texto
                "   text-background-mode: plain;"
                + // Modo de fondo para el texto
                "   text-background-color: black;"
                + // Color de fondo para el texto
                "   size: 50px;"
                + // Tamaño del nodo
                "}"
                + "edge {"
                + "   text-size: 16;"
                + // Tamaño del texto
                "   text-color: black;"
                + // Color del texto
                "   text-background-mode: plain;"
                +// Modo de fondo para el texto
                "   text-background-color: white;"
                +// Color de fondo para el texto
                "   size: 5px;"
                + // Grosor de la arista
                "   shape: line;"
                + // Forma de la arista
                "   fill-color: black;"
                + // Color de relleno de la arista
                "}"
                + "edge.red {"
                + // Definición para aristas rojas
                "   fill-color: red;"
                + "}"
                + "edge.blue {"
                + // Definición para aristas azules
                "   fill-color: blue;"
                + "}";
        if (!grafoVacio()) {
            NodoGrafo temporal1 = getPrimero();
            ListaSimple ciudadesVisitadas = new ListaSimple(); // Lista para rastrear las aristas agregadas
            int idArista = 1; // Identificador inicial para las aristas

            while (temporal1 != null) {
                grafito.addNode((String) temporal1.getDato()).setAttribute("ui.label", temporal1.getDato());
                temporal1 = temporal1.getSiguiente();
            }

            temporal1 = getPrimero();
            while (temporal1 != null) {
                Arco Arcoaux = temporal1.getLista().getPrimero();
                while (Arcoaux != null) {
                    // Construir un identificador único para la arista
                    String idUnico = idArista + "- Distancia: " + Float.toString(Arcoaux.getDistancia()) + " - Feromonas: " + Float.toString(Arcoaux.getFeromonas());

                    // Verificar si la arista ya ha sido agregada
                    if (!ciudadesVisitadas.contains((String) Arcoaux.getDestino())) {
                        grafito.addEdge(idUnico, (String) temporal1.getDato(), (String) Arcoaux.getDestino()).setAttribute("ui.label", idUnico);
                        Nodo aux1 = caminoMasOptimo.getpFirst();
                        String origen;
                        String destino;
                        while (aux1.getpNext() != null) {

                            if (Integer.parseInt((String) aux1.getInfo()) > Integer.parseInt((String) aux1.getpNext().getInfo())) {
                                destino = aux1.getInfo().toString();
                                origen = aux1.getpNext().getInfo().toString();
                            } else {
                                origen = aux1.getInfo().toString();
                                destino = aux1.getpNext().getInfo().toString();
                            }

                            Arco arcoAux = this.obtenerArcoEntreNodos(origen, destino);
                            if (arcoAux == Arcoaux) {
                                grafito.getEdge(idUnico).setAttribute("ui.class", "blue");

                            }

                            aux1 = aux1.getpNext();

                        }

                        idArista++; // Incrementar el identificador para la próxima arista

                    }
                    Arcoaux = Arcoaux.getSiguiente();
                }
                ciudadesVisitadas.InsertAtTheEnd((String) temporal1.getDato()); // Agregar la ciudad a la lista de ciudades visitadas
                temporal1 = temporal1.getSiguiente();
            }
        }
        grafito.nodes().forEach(node -> node.setAttribute("ui.label", node.getId()));
        grafito.edges().forEach(edge -> edge.setAttribute("ui.label", edge.getId()));

        grafito.setAttribute("ui.stylesheet", styleSheet);
        // grafoVisible.setAttribute("ui.freeze", true);
        return grafito;
    }

    public void CrearGrafoVisible(ListaSimple caminoMasOptimo) {
        String styleSheet
                = "node {"
                + "   text-size: 24;"
                + // Tamaño del texto
                "   text-color: white;"
                + // Color del texto
                "   text-background-mode: plain;"
                + // Modo de fondo para el texto
                "   text-background-color: black;"
                + // Color de fondo para el texto
                "   size: 50px;"
                + // Tamaño del nodo
                "}"
                + "edge {"
                + "   text-size: 16;"
                + // Tamaño del texto
                "   text-color: black;"
                + // Color del texto
                "   text-background-mode: plain;"
                +// Modo de fondo para el texto
                "   text-background-color: white;"
                +// Color de fondo para el texto
                "   size: 5px;"
                + // Grosor de la arista
                "   shape: line;"
                + // Forma de la arista
                "   fill-color: black;"
                + // Color de relleno de la arista
                "}"
                + "edge.red {"
                + // Definición para aristas rojas
                "   fill-color: red;"
                + "}"
                + "edge.blue {"
                + // Definición para aristas azules
                "   fill-color: blue;"
                + "}";
        if (!grafoVacio()) {
            NodoGrafo temporal1 = getPrimero();
            ListaSimple ciudadesVisitadas = new ListaSimple(); // Lista para rastrear las aristas agregadas
            int idArista = 1; // Identificador inicial para las aristas

            while (temporal1 != null) {
                grafoVisible.addNode((String) temporal1.getDato()).setAttribute("ui.label", temporal1.getDato());
                temporal1 = temporal1.getSiguiente();
            }

            temporal1 = getPrimero();
            while (temporal1 != null) {
                Arco Arcoaux = temporal1.getLista().getPrimero();
                while (Arcoaux != null) {
                    // Construir un identificador único para la arista
                    String idUnico = idArista + "- Distancia: " + Float.toString(Arcoaux.getDistancia()) + " - Feromonas: " + Float.toString(Arcoaux.getFeromonas());

                    // Verificar si la arista ya ha sido agregada
                    if (!ciudadesVisitadas.contains((String) Arcoaux.getDestino())) {
                        grafoVisible.addEdge(idUnico, (String) temporal1.getDato(), (String) Arcoaux.getDestino()).setAttribute("ui.label", idUnico);
                        Nodo aux1 = caminoMasOptimo.getpFirst();
                        String origen;
                        String destino;
                        while (aux1.getpNext() != null) {

                            if (Integer.parseInt((String) aux1.getInfo()) > Integer.parseInt((String) aux1.getpNext().getInfo())) {
                                destino = aux1.getInfo().toString();
                                origen = aux1.getpNext().getInfo().toString();
                            } else {
                                origen = aux1.getInfo().toString();
                                destino = aux1.getpNext().getInfo().toString();
                            }

                            Arco arcoAux = this.obtenerArcoEntreNodos(origen, destino);
                            if (arcoAux == Arcoaux) {
                                grafoVisible.getEdge(idUnico).setAttribute("ui.class", "blue");

                            }

                            aux1 = aux1.getpNext();

                        }

                        idArista++; // Incrementar el identificador para la próxima arista

                    }
                    Arcoaux = Arcoaux.getSiguiente();
                }
                ciudadesVisitadas.InsertAtTheEnd((String) temporal1.getDato()); // Agregar la ciudad a la lista de ciudades visitadas
                temporal1 = temporal1.getSiguiente();
            }
        }
        grafoVisible.nodes().forEach(node -> node.setAttribute("ui.label", node.getId()));
        grafoVisible.edges().forEach(edge -> edge.setAttribute("ui.label", edge.getId()));

        grafoVisible.setAttribute("ui.stylesheet", styleSheet);
        // grafoVisible.setAttribute("ui.freeze", true);

    }

    @Override

    public Grafo clone() {
        try {
            Grafo clonedGraph = (Grafo) super.clone();

            // Clonar los nodos del grafo
            clonedGraph.primero = cloneNodos(this.primero);

            return clonedGraph;
        } catch (CloneNotSupportedException e) {
            // Manejo de excepción si la clase no es clonable
            return null;
        }
    }

    // Método auxiliar para clonar los nodos del grafo
    private NodoGrafo cloneNodos(NodoGrafo original) {
        if (original == null) {
            return null;
        }

        NodoGrafo clonedNode = new NodoGrafo(original.getDato());

        // Clonar la lista de adyacencia
        clonedNode.setLista(cloneListaAdyacencia(original.getLista()));

        // Clonar el siguiente nodo recursivamente
        clonedNode.setSiguiente(cloneNodos(original.getSiguiente()));

        return clonedNode;
    }
    
    private ListaAdyacencia cloneListaAdyacencia(ListaAdyacencia original) {
        if (original == null) {
            return null;
        }

        ListaAdyacencia clonedList = new ListaAdyacencia();

        // Clonar los arcos de la lista de adyacencia
        Arco currentArc = original.getPrimero();
        while (currentArc != null) {
            clonedList.insertar(currentArc.clone());
            currentArc = currentArc.getSiguiente();
        }

        return clonedList;
    }
}
