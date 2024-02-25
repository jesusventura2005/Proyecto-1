/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesAux;

import EDD.Arco;
import EDD.Grafo;
import EDD.ListaSimple;
import EDD.NodoGrafo;
import EDD.Nodo;

/**
 * Clase que representa una colonia de hormigas para encontrar caminos óptimos en un grafo utilizando el algoritmo de colonia de hormigas.
 * @author Daniel Fariña
 * @version 22/02/2024
 */
public class Colonia {

    private int factorHormiga;
    private Grafo grafo;
    private ListaSimple hormigas;
    private float rho;

    /**
     * Constructor de la clase Colonia.
     * @param factorHormiga El número de hormigas que formarán parte de la colonia.
     * @param grafo El grafo sobre el cual las hormigas realizarán la búsqueda de caminos.
     * @param rho El coeficiente de evaporación de feromonas.
     */
    public Colonia(int factorHormiga, Grafo grafo, float rho) {
        this.factorHormiga = factorHormiga;
        this.grafo = grafo;
        this.hormigas = new ListaSimple();
        this.rho = rho;
    }

    /**
     * Inicializa las hormigas de la colonia con los parámetros alpha y beta especificados, agrega cada hormiga a la lista de hormigas.
     * @param alpha El parámetro alpha utilizado en el cálculo de probabilidades durante la búsqueda de caminos.
     * @param beta El parámetro beta utilizado en el cálculo de probabilidades durante la búsqueda de caminos.
     */
    public void inicializarHormigas(float alpha, float beta) {
        for (int i = 0; i < factorHormiga; i++) {
            Hormiga hormiga = new Hormiga(grafo, alpha, beta);
            hormigas.InsertAtTheEnd(hormiga);
        }
    }

    /**
     * Ejecuta la búsqueda de caminos por parte de todas las hormigas en la colonia.
     */
    public void ejecutarBusquedaCaminos() {
        Nodo aux = hormigas.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            hormiga.buscarCamino(hormiga.getGrafo());
            aux = aux.getpNext();
        }
        aux = hormigas.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            hormiga.depositarFeromonas();
            aux = aux.getpNext();
        }
        evaporarFeromonas();
        setGrafo(grafo);
    }

    /**
     * Obtiene la longitud del camino más corto encontrado por las hormigas en la colonia.
     * @return La longitud del camino más corto.
     */
    public float obtenerLongitudCaminoMasCorto() {
        float longitudMasCorta = Float.MAX_VALUE;
        Nodo aux = hormigas.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            ListaSimple caminoHormiga = hormiga.getCamino();
            float longitudCaminoHormiga = calcularLongitudCamino(caminoHormiga);
            if (longitudCaminoHormiga < longitudMasCorta) {
                longitudMasCorta = longitudCaminoHormiga;
            }
            aux = aux.getpNext();
        }
        return longitudMasCorta;
    }

    /**
     * Obtiene el camino más corto encontrado por las hormigas en la colonia.
     * @return El camino más corto como una lista simple implementada con nodos.
     */
    public ListaSimple obtenerCaminoMasCorto() {
        ListaSimple caminoMasCorto = null;
        float longitudMasCorta = Float.MAX_VALUE; // Inicializa con un valor grande

        Nodo aux = hormigas.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            ListaSimple caminoHormiga = hormiga.getCamino();

            // Calcula la longitud del camino de la hormiga
            float longitudCamino = calcularLongitudCamino(caminoHormiga);

            // Si es más corto que el actual, actualiza el camino más corto
            if (longitudCamino < longitudMasCorta) {
                caminoMasCorto = caminoHormiga;
                longitudMasCorta = longitudCamino;
            }

            aux = aux.getpNext();
        }

        return caminoMasCorto;
    }

    /**
     * Calcula la longitud total de un camino dado en función de las distancias de los arcos
     * @param camino ListaSimple que representa el camino cuya longitud se va a calcular
     * @return La longitud total del camino
     */
    private float calcularLongitudCamino(ListaSimple camino) {
        float longitud = 0;
        Nodo aux = camino.getpFirst();
        while (aux.getpNext() != null) {
            Object origen = aux.getInfo();
            Object destino = aux.getpNext().getInfo();
            Arco arco = grafo.obtenerArcoEntreNodos(origen, destino);
            longitud += arco.getDistancia();
            aux = aux.getpNext();
        }
        return longitud;
    }

    /**
     * Evapora las feromonas en todas las aristas del grafo.
     */
    public void evaporarFeromonas() {
        NodoGrafo temp = grafo.getPrimero();
        while (temp != null) {
            Arco arcoTemp = temp.getLista().getPrimero();
            while (arcoTemp != null) {
                arcoTemp.setFeromonas(arcoTemp.getFeromonas() * (1 - rho));
                arcoTemp = arcoTemp.getSiguiente();
            }
            temp = temp.getSiguiente();
        }
        setGrafoEnHormigas(grafo);
    }

    /**
     * Establece el grafo actualizado en todas las hormigas de la colonia
     * @param nuevoGrafo El nuevo Grafo que se establecerá en todas las hormigas
     */
    private void setGrafoEnHormigas(Grafo nuevoGrafo) {
        Nodo aux = hormigas.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            hormiga.setGrafo(nuevoGrafo);
            aux = aux.getpNext();
        }
    }

    /**
    * Obtiene el factor de las hormigas de la colonia.
    * @return El factor de las hormigas de la colonia.
    */
    public int getFactorHormiga() {
        return factorHormiga;
    }

    /**
    * Establece el factor de las hormigas de la colonia.
    * @param factorHormiga El nuevo factor de las hormigas de la colonia.
    */
    public void setFactorHormiga(int factorHormiga) {
        this.factorHormiga = factorHormiga;
    }

    /**
    * Obtiene el grafo asociado a la colonia.
    * @return El grafo asociado a la colonia.
    */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
    * Establece el grafo asociado a la colonia.
    * @param grafo El nuevo grafo asociado a la colonia.
    */
    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    /**
    * Obtiene la lista de hormigas de la colonia.
    * @return La lista de hormigas de la colonia.
    */
    public ListaSimple getHormigas() {
        return hormigas;
    }

    /**
    * Establece la lista de hormigas de la colonia.
    * @param hormigas La nueva lista de hormigas de la colonia.
    */
    public void setHormigas(ListaSimple hormigas) {
        this.hormigas = hormigas;
    }

}