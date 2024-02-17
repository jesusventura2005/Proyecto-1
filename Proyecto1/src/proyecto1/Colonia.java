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

    public Colonia(int factorHormiga, Grafo grafo) {
        this.factorHormiga = factorHormiga;
        this.grafo = grafo;
        this.hormigas = new ListaSimple();
        this.rho = 0.5f;
    }

    public void inicializarHormigas() { 
        for (int i = 0; i < factorHormiga; i++){
            Hormiga hormiga = new Hormiga(); 
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
