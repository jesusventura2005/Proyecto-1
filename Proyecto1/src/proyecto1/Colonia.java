/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author drali
 */
public class Colonia {
    
    private int FactorHormiga; 
    private Grafo grafo;
    private ListaSimple Hormigas; 

    public Colonia(int FactorHormiga, Grafo grafo) {
        this.FactorHormiga = FactorHormiga;
        this.grafo = grafo;
        this.Hormigas = new ListaSimple(); 
    }

    public void CrearHormigas() { 
        for (int i = 0; i < getFactorHormiga(); i++){
            Hormiga hormiga = new Hormiga(); 
            Hormigas.InsertAtTheEnd(hormiga);
        }
    }
    
    
    
    public int getFactorHormiga() {
        return FactorHormiga;
    }

    public void setFactorHormiga(int FactorHormiga) {
        this.FactorHormiga = FactorHormiga;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public ListaSimple getHormigas() {
        return Hormigas;
    }

    public void setHormigas(ListaSimple Hormigas) {
        this.Hormigas = Hormigas;
    }

    public ListaAdyacencia getCaminosUsados() {
        return CaminosUsados;
    }

    public void setCaminosUsados(ListaAdyacencia CaminosUsados) {
        this.CaminosUsados = CaminosUsados;
    }
        
    
}
