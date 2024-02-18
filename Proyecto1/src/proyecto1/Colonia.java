/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Daniel
 */
public class Colonia {
    
    private int factorHormiga;
    private Grafo grafo;
    private ListaSimple hormigas;
    private float rho;

    public Colonia(int factorHormiga, Grafo grafo, float rho) {
        this.factorHormiga = factorHormiga;
        this.grafo = grafo;
        this.hormigas = new ListaSimple();
        this.rho = rho;
    }

    public void inicializarHormigas(float alpha, float beta) { 
        for (int i = 0; i < factorHormiga; i++){
            Hormiga hormiga = new Hormiga(grafo, alpha, beta); 
            hormigas.InsertAtTheEnd(hormiga);
        }
    }
    
    public void ejecutarBusquedaCaminos() {
        Nodo aux = hormigas.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            hormiga.buscarCamino(hormiga.getGrafo());
            aux = aux.getpNext();
        }
        evaporarFeromonas();
        setGrafo(grafo);
    }
    
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

    private void setGrafoEnHormigas(Grafo nuevoGrafo) {
        Nodo aux = hormigas.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            hormiga.setGrafo(nuevoGrafo);
            aux = aux.getpNext();
        }
    }
    
    public int getFactorHormiga() {
        return factorHormiga;
    }

    public void setFactorHormiga(int factorHormiga) {
        this.factorHormiga = factorHormiga;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public ListaSimple getHormigas() {
        return hormigas;
    }

    public void setHormigas(ListaSimple hormigas) {
        this.hormigas = hormigas;
    }
  
    
}
