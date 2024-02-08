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
        
        long matrizA[][]={{1,2,3,5,4,6},{1,3,6,4,2,5},{6,5,3,2,1,4}};
        Caminos ruta= new Caminos();
        System.out.println(ruta.algoritmoGrafo(matrizA));
        



        // TODO code application logic here
    }
    
}
