/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 * Clase que modela el comportamiento de una hormiga en la búsqueda de caminos óptimos en un grafo utilizando el algoritmo de colonia de hormigas.
 * @author Daniel Fariña
 * @version 22/02/2024
 */
public class Hormiga {

    private ListaSimple camino;
    private float alpha;
    private float beta;
    private Grafo grafo;

    /**
     * Constructor de la clase Hormiga.
     * @param grafo El grafo sobre el cual la hormiga realizará su búsqueda de camino.
     * @param alpha El parámetro alpha utilizado en el cálculo de probabilidades durante la búsqueda.
     * @param beta El parámetro beta utilizado en el cálculo de probabilidades durante la búsqueda.
     */
    public Hormiga(Grafo grafo, float alpha, float beta) {
        this.camino = new ListaSimple();
        this.alpha = alpha;
        this.beta = beta;
        this.grafo = grafo;
    }
    
    /**
     * Constructor por defecto de la clase Hormiga.
     * Inicializa la hormiga con valores predeterminados para alpha y beta, y sin asignar un grafo.
     */
    public Hormiga() {
        this.camino = null;
        this.alpha = 1.0f;
        this.beta = 2.0f;
        this.grafo = null;
    }

    /**
     * Realiza la búsqueda del camino óptimo utilizando el algoritmo de la hormiga.
     * @param grafo El grafo sobre el cual se realiza la búsqueda del camino.
     */
    public void buscarCamino(Grafo grafo) {
        camino.vaciar();
        NodoGrafo nodoActual = this.grafo.getPrimero();
        // nodoActual.setSiguiente(null);
        camino.InsertAtTheEnd(nodoActual.getDato());
        while (nodoActual != this.grafo.getUltimo()) {
            Arco arcoAux = nodoActual.getLista().getPrimero();
            ListaAdyacencia aristasDisponibles = new ListaAdyacencia();
            aristasDisponibles.setPrimero(arcoAux);
            aristasDisponibles = filtrarAristasDisponibles(aristasDisponibles);
            if (aristasDisponibles.esvacia()) { // verificar si el nodo actual es una calle ciega (sin aristas disponibles)
                break;
            }
            float sumaProbabilidades = 0.0f;
            ListaSimple probabilidades = new ListaSimple();
            Arco arista = aristasDisponibles.getPrimero();
            while (arista != null) {
                sumaProbabilidades += Math.pow(arista.getFeromonas(), alpha) * Math.pow(arista.getVisibilidad(), beta);
                arista = arista.getSiguiente();
            }
            arista = aristasDisponibles.getPrimero();
            while (arista != null) {
                float probabilidad = (float) (Math.pow(arista.getFeromonas(), alpha) * Math.pow(arista.getVisibilidad(), beta) / sumaProbabilidades);
                probabilidades.InsertAtTheEnd(probabilidad);
                arista = arista.getSiguiente();
            }
            arista = aristasDisponibles.getPrimero();
            float probabilidadAcumulada = 0.0f;
            float valorAleatorio = (float) Math.random();
            Arco aristaElegida = null;
            Nodo aux = probabilidades.getpFirst();
            while (arista != null) {
                probabilidadAcumulada += (float) aux.getInfo();
                if (valorAleatorio <= probabilidadAcumulada) {
                    aristaElegida = arista;
                    break;
                }
                arista = arista.getSiguiente();
                aux = aux.getpNext();
            }      
            
            if (aristaElegida != null) {
                String siguienteNodo = (String) aristaElegida.getDestino();
                camino.InsertAtTheEnd(siguienteNodo);
                nodoActual = grafo.obtenerNodo(siguienteNodo);
            } else {
                // Si no se eligió ninguna arista, salir del bucle
                break;
            }
        }
    }
    
    /**
     * Deposita feromonas en las aristas del camino recorrido por la hormiga.
     */
    public void depositarFeromonas() {
        Nodo aux = camino.getpFirst();
        while (aux.getpNext() != null) {
            Object origen = aux.getInfo();
            Object destino = aux.getpNext().getInfo();
            Arco arco = grafo.obtenerArcoEntreNodos(origen, destino);
            float cantidadFeromonas = 1.0f / arco.getDistancia();
            arco.setFeromonas(arco.getFeromonas() + cantidadFeromonas);
            aux = aux.getpNext();
        }
    }
    
    /**
     * Filtra las aristas disponibles para la hormiga, excluyendo aquellas que conducen a nodos ya visitados.
     * @param aristas Las aristas disponibles para la hormiga.
     * @return Una lista de aristas filtradas, que no conducen a nodos ya visitados.
     */
    private ListaAdyacencia filtrarAristasDisponibles(ListaAdyacencia aristas) {
        ListaAdyacencia aristasFiltradas = new ListaAdyacencia();
        Arco arista = aristas.getPrimero();
        int cont = 0;
        while (arista != null) {
            cont++;
            arista = arista.getSiguiente();
        }
        arista = aristas.getPrimero();
        for (int i = 0; i < cont; i++ ) {
            if (!NodoVisitado(arista.getDestino())) {
                Arco aristaFilt = arista.clone();
                aristaFilt.setSiguiente(null);
                aristasFiltradas.insertar(aristaFilt);
            }
            arista = arista.getSiguiente();
        }
        
        return aristasFiltradas;
    }
    
    /**
     * Verifica si un nodo ha sido visitado por la hormiga.
     * @param nodo El nodo que se desea verificar si ha sido visitado.
     * @return true si el nodo ha sido visitado, false en caso contrario.
     */
    public boolean NodoVisitado(Object nodo) {
        Nodo aux = camino.getpFirst();
        while (aux != null) {
            if (nodo.equals(aux.getInfo())) {
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }    

    /**
     * Obtiene el camino recorrido por la hormiga.
     * @return El camino recorrido por la hormiga.
     */
    public ListaSimple getCamino() {
        return camino;
    }

    /**
     * Establece el camino recorrido por la hormiga.
     * @param camino El camino recorrido por la hormiga.
     */
    public void setCamino(ListaSimple camino) {
        this.camino = camino;
    }

    /**
     * Obtiene el valor de alpha utilizado por la hormiga en la búsqueda del camino.
     * @return El valor de alpha.
     */
    public float getAlpha() {
        return alpha;
    }

    /**
     * Establece el valor de alpha utilizado por la hormiga en la búsqueda del camino.
     * @param alpha El valor de alpha.
     */
    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    /**
     * Obtiene el valor de beta utilizado por la hormiga en la búsqueda del camino.
     * @return El valor de beta.
     */
    public float getBeta() {
        return beta;
    }

    /**
     * Establece el valor de beta utilizado por la hormiga en la búsqueda del camino.
     * @param beta El valor de beta.
     */
    public void setBeta(float beta) {
        this.beta = beta;
    }

    /**
     * Obtiene el grafo asociado a la hormiga.
     * @return El grafo asociado a la hormiga.
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * Establece el grafo asociado a la hormiga.
     * @param grafo El grafo asociado a la hormiga.
     */
    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    
}
