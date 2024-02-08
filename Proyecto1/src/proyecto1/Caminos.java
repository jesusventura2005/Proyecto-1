/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author jesus
 */
public class Caminos {

    //Metodo para determinar los caminos 
    public String algoritmoGrafo(long[][] mADY) {
        int vertices = mADY.length;
        long matrizPeso[][] = mADY;
        String caminos[][] = new String[vertices][vertices];
        String CaminosAxuciliares[][] = new String[vertices][vertices];
        String CaminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;

        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                CaminosAxuciliares[i][j] = "";
            }
        }
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizPeso[i][j];
                    temporal2 = matrizPeso[i][k];
                    temporal3 = matrizPeso[k][j];
                    temporal4 = temporal2 + temporal3;
                    //econtrar el camino minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            CaminoRecorrido = "";
                            CaminosAxuciliares[i][j] = k + "";
                            caminos[i][j] = caminoR(i, k, CaminosAxuciliares, CaminoRecorrido) + (k + 1);
                        }

                    }
                    matrizPeso[i][j] = (long) minimo;

                }
            }
        }

        //agregando el camino minimo a cadena
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena = cadena + "[" + matrizPeso[i][j] + "]";

            }
            cadena = cadena + "\n";
        }
        ////////////////////////////////////
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizPeso[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por....(" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por....(" + (i + 1) + ", " + caminos[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }

                }

            }
        }

        return "La matriz de Caminos mas cortos entre los vertices es:\n" + cadena
                + "\nLos diferentes caminos mas cortos entre vertices son:\n" + caminitos;

    }

    public String caminoR(int i, int k, String[][] caminosAux, String caminoRecorrido) {
        if (caminosAux[i][k].equals("")) {
            return "";
        } else {
            //////////////Recursividad
            caminoRecorrido += caminoR(i, Integer.parseInt(caminosAux[i][k].toString()), 
            caminosAux, caminoRecorrido) + 
            (Integer.parseInt(caminosAux[i][k].toString()) + 1)+", ";
            return caminoRecorrido;
            
        }
    
    
    }
    

}
