/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

/**
 *
 * @author jesus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListaAdyacencia lista = new ListaAdyacencia();
        Grafo grafo = new Grafo();
        
        grafo.nuevoNodo("A");
        grafo.nuevoNodo("B");
        grafo.nuevoNodo("C");
        grafo.nuevoNodo("D");
        
        grafo.NuevaArista("A", "B");
        grafo.NuevaArista("B", "C");
        
        
        
        
        
        
        System.out.println(grafo.toString());
        
        
        
     
            



        // TODO code application logic here
    }
    
}
